import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultDAOMySQLImpl implements ResultDAO{

    private static PreparedStatement createPS;
    private PreparedStatement allPS;
    private PreparedStatement getByIdPS;
    private PreparedStatement getByNamePS;
    private static Connection connection;


    public void resultDAOMySQLImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/moo", "robert", "Robert12345");
            createPS = connection.prepareStatement("INSERT INTO results (result, playerid) VALUES (?,?)");
            allPS = connection.prepareStatement("SELECT * FROM results");


        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute...", e);
        }
    }

    public static void saveResult(int nGuess, int playerId) throws SQLException {
        createPS.executeUpdate("INSERT INTO results (result, playerid) VALUES (" + nGuess + "," + playerId + ")");
    }

    public static void showTopTen() throws SQLException {
        ArrayList<Player.PlayerAverage> topList = new ArrayList<>();
        Statement stmt2 = connection.createStatement();
        ResultSet rs = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            rs = stmt2.executeQuery("select * from results where playerid = " + id);
            int nGames = 0;
            int totalGuesses = 0;
            while (rs.next()) {
                nGames++;
                totalGuesses += rs.getInt("result");
            }
            if (nGames > 0) {
                topList.add(new Player.PlayerAverage(name, (double) totalGuesses / nGames));
            }
        }

        MainUsingDAO.gw.addString("Top Ten List\n    Player     Average\n");
        int pos = 1;
        topList.sort((p1, p2) -> (Double.compare(p1.average, p2.average)));
        for (Player.PlayerAverage p : topList) {
            MainUsingDAO.gw.addString(String.format("%3d %-10s%5.2f%n", pos, p.name, p.average));
            if (pos++ == 10) break;
        }
    }
}

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOMySQLImpl implements PlayerDAO {
    static Connection connection;
    static Statement statement;
    static ResultSet rs;
    static PreparedStatement createPS,allPS,getByNamePS;

    public void PlayerDAOMySQLImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/moo", "robert", "Robert12345");

            // Initialize prepared statements
            createPS = connection.prepareStatement("INSERT INTO players (name) VALUES (?)");
            allPS = connection.prepareStatement("SELECT * FROM players");
            getByNamePS = connection.prepareStatement("SELECT * FROM players WHERE name = (?)");

        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute...", e);
        }
    }

    public static int login() throws SQLException, InterruptedException {
        MainUsingDAO.gw.addString("Enter your user name:\n");
        String name = MainUsingDAO.gw.getString();

        int id = 0;
//        connection = DriverManager.getConnection("jdbc:mysql://localhost/Moo","robert","Robert12345");
//        stmt = connection.createStatement();
        ResultSet rs = getByNamePS.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        } else {
            MainUsingDAO.gw.addString("User not in database, please register with admin");
            Thread.sleep(5000);
            MainUsingDAO.gw.exit();
        }
        return id;
    }

    @Override
    public List<Player> getAll() {
        List<Player> players = new ArrayList<>();

        try (ResultSet resultSet = allPS.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                players.add(new Player(name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public Player getByName(String name) {
        try {
            getByNamePS.setString(1, name);
            try (ResultSet resultSet = getByNamePS.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    return new Player(name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
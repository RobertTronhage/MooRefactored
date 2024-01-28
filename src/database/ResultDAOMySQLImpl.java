package database;/*
 * SQL Implementation of database.ResultDAO, connection/queries to table "results" in DB.
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */

import IO.IO;
import entity.PlayerAverage;

import java.sql.*;
import java.util.ArrayList;

public class ResultDAOMySQLImpl implements ResultDAO {

    private static PreparedStatement createPS;
    private PreparedStatement allPS;
    private PreparedStatement getByIdPS;
    private PreparedStatement getByNamePS;
    private static Connection connection;


    public ResultDAOMySQLImpl(IO io) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/moo", "robert", "Robert12345");
            createPS = connection.prepareStatement("INSERT INTO results (result, playerid) VALUES (?,?)");
            allPS = connection.prepareStatement("SELECT * FROM results");

        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute...", e);
        }
    }

    @Override
    public void saveResult(int nGuess, int playerId) throws SQLException {
        createPS.setInt(1, nGuess);
        createPS.setInt(2, playerId);
    }

    public void showTopTen(IO io) throws SQLException {
        ArrayList<PlayerAverage> topList = new ArrayList<>();
        Statement stmt2 = connection.createStatement();
        ResultSet rs = stmt2.executeQuery("SELECT players.name, AVG(results.result) AS average " +
                "FROM players " +
                "JOIN results ON players.id = results.playerid " +
                "GROUP BY players.id " +
                "ORDER BY average ASC " +
                "LIMIT 10");

        while (rs.next()) {
            String name = rs.getString("name");
            double average = rs.getDouble("average");
            topList.add(new PlayerAverage(name, average));
        }

        io.addString("Top Ten List\n    entity.Player     Average\n");
        int pos = 1;
        for (PlayerAverage p : topList) {
            io.addString(String.format("%3d %-10s%5.2f%n", pos, p.name, p.average));
            if (pos++ == 10) break;
        }
    }
}

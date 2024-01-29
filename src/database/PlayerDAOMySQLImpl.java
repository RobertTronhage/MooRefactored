package database;/*
 * SQL Implementation of database.PlayerDAO, connection/queries to table "players" in DB.
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
import IO.IO;
import entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOMySQLImpl implements PlayerDAO {
    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    private PreparedStatement createPS,allPS,getByNamePS;

    public PlayerDAOMySQLImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/moo", "robert", "Robert12345");

            // Initialize prepared statements
            createPS = connection.prepareStatement("INSERT INTO players (name) VALUES (?)");
            allPS = connection.prepareStatement("SELECT * FROM players");
            getByNamePS = connection.prepareStatement("SELECT id,name FROM players WHERE name = (?)");

        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute...", e);
        }
    }

    public Player login(IO io){
        io.addString("Enter your user name:\n");
        String name = io.getString();

        int id = 0;
        String playerName;

        try {
            getByNamePS.setString(1,name);
            rs = getByNamePS.executeQuery();
            Player player = null;
            if (rs.next()) {
                playerName = rs.getString("name");
                id = rs.getInt("id");
                player = new Player(id, playerName);

            } else {
                io.addString("User not in database, please register with admin");
                Thread.sleep(5000);
                io.exit();
            }
            return player;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute...", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to execute...", e);
        }
    }
}
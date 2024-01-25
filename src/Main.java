/*
 * Main calling controller & runGame method.
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, InterruptedException {
        IO io = new SimpleWindow("Moo");
        Game game = new Game();
        PlayerDAO playerDAO = new PlayerDAOMySQLImpl();
        ResultDAO resultDAO = new ResultDAOMySQLImpl(io);
        Controller gameController = new Controller(game,playerDAO,resultDAO,io);
        gameController.runGame();
    }
}
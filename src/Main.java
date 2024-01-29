/**
 * Main.java
 *
 * The main class of the game application.
 * Responsible for initializing the game components and starting the game loop.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-25
 */
import IO.IO;
import IO.SimpleWindow;
import database.PlayerDAO;
import database.PlayerDAOMySQLImpl;
import database.ResultDAO;
import database.ResultDAOMySQLImpl;
import logic.BullsAndCowsGame;
import logic.Controller;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, InterruptedException {
        IO io = new SimpleWindow("Moo");
        //IO.IO io = new IO.SystemIO(); // remove comment and comment out row above to run app in console! :)
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        PlayerDAO playerDAO = new PlayerDAOMySQLImpl();
        ResultDAO resultDAO = new ResultDAOMySQLImpl(io);
        Controller gameController = new Controller(bullsAndCowsGame,playerDAO,resultDAO,io);
        gameController.runGame();
    }
}
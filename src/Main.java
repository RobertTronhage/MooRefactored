/**
 * Main.java
 * The main class of the game application.
 * Responsible for initializing the game components and starting the game loop.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-25
 */
import IO.IO;
import IO.SimpleWindow;
import IO.SystemIO;
import database.PlayerDAO;
import database.PlayerDAOMySQLImpl;
import database.ResultDAO;
import database.ResultDAOMySQLImpl;
import logic.BullsAndCowsGame;
import logic.Controller;
import logic.GuessingGame;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        IO io = new SimpleWindow("Moo");
//        IO io = new SystemIO(); // remove comment and comment out row above to run app in console! :)
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
//        GuessingGame guessingGame = new GuessingGame(); // this is guessingGame instead of bullsAndCows
        PlayerDAO playerDAO = new PlayerDAOMySQLImpl();
        ResultDAO resultDAO = new ResultDAOMySQLImpl();
        Controller gameController = new Controller(bullsAndCowsGame,playerDAO,resultDAO,io);
        gameController.runGame();
    }
}
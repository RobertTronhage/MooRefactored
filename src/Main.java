/*
 * Main creating new instances of everything and calling controller & runGame method
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, InterruptedException {
        IO io = new SimpleWindow("Moo");
        //IO io = new SystemIO(); // remove comment and comment out row 11 to run app in console! :)
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        PlayerDAO playerDAO = new PlayerDAOMySQLImpl();
        ResultDAO resultDAO = new ResultDAOMySQLImpl(io);
        Controller gameController = new Controller(bullsAndCowsGame,playerDAO,resultDAO,io);
        gameController.runGame();
    }
}
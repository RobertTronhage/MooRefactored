/*
 * Main calling controller & runGame method.
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
import java.sql.SQLException;

public class Main {
    static IO gw;
    public static void main(String[] args) throws SQLException, InterruptedException {
        Controller gameController = new Controller();
        gameController.runGame();
    }
}
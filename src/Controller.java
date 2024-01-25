/*
 * Controller for program.
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */

import java.sql.SQLException;

public class Controller {

    private IO gameWindow;

    public Controller(){
        this.gameWindow = new SimpleWindow("Moo-refactored");
    }

    public IO getGameWindow(){
        return gameWindow;
    }

    public void runGame() throws SQLException, InterruptedException {
        ResultDAO resultDAO = new ResultDAOMySQLImpl();
        PlayerDAO pdao = new PlayerDAOMySQLImpl();
        Player p1 = pdao.login();
        Game.playGame(resultDAO, p1.getId());
    }
}
/*
 * Controller for program.
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */

import java.sql.SQLException;

public class Controller {
    IO io;
    PlayerDAO playerDAO;
    ResultDAO resultDAO;
    Game game;

    public Controller(Game game, PlayerDAO playerDAO, ResultDAO resultDAO, IO io){
        this.io = io;
        this.playerDAO = playerDAO;
        this.resultDAO = resultDAO;
        this.game = game;
    }

    public void runGame() throws SQLException, InterruptedException {
        Player loggedInPlayer = playerDAO.login(io);
        game.playGame(io, resultDAO, loggedInPlayer.getId());
    }
}
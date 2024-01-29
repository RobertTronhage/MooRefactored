package logic;/*
 * logic.Controller for program.
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */

import IO.IO;
import database.PlayerDAO;
import database.ResultDAO;
import entity.Player;

import java.sql.SQLException;

public class Controller {
    IO io;
    PlayerDAO playerDAO;
    ResultDAO resultDAO;
    BullsAndCowsGame bullsAndCowsGame;

    public Controller(BullsAndCowsGame bullsAndCowsGame, PlayerDAO playerDAO, ResultDAO resultDAO, IO io){
        this.io = io;
        this.playerDAO = playerDAO;
        this.resultDAO = resultDAO;
        this.bullsAndCowsGame = bullsAndCowsGame;
    }

    public void runGame(){
        Player loggedInPlayer = playerDAO.login(io);
        bullsAndCowsGame.playGame(io, resultDAO, loggedInPlayer.getId());
    }
}
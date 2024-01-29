package logic;/*
* Game logic for bullsAndCows is stored within this file, implements gameable
* Author: Robert Tronhage, robert.tronhage@iths.se
* 2024-01-25
 */

import IO.IO;
import database.ResultDAO;

import java.sql.SQLException;

public class BullsAndCowsGame implements Gameable {

    @Override
    public void playGame(IO io, ResultDAO resultDAO, int loggedInPlayerId)  {
        boolean answer = true;
        while (answer) {
            String goalNumber = createGoalNumber();
            io.clear();
            io.addString("New game:\n");
            io.addString(goalNumber); //remove comment to see GoalNumber
            String guess = io.getString();
            io.addString(guess + "\n");
            int nGuess = 1;
            String bbcc = checkGuessToGoalNumber(goalNumber, guess);
            io.addString(bbcc + "\n");
            while (!bbcc.equals("BBBB,")) {
                nGuess++;
                guess = io.getString();
                io.addString(guess + ": ");
                bbcc = checkGuessToGoalNumber(goalNumber, guess);
                io.addString(bbcc + "\n");
            }
            resultDAO.saveResult(nGuess, loggedInPlayerId);
            resultDAO.showTopTen(io);
            answer = io.yesNo("Correct, it took " + nGuess + " guesses\nContinue?");
        }
    }

    @Override
    public String createGoalNumber() {
        String goal = "";
        for (int i = 0; i < 4; i++) {
            int random = (int) (Math.random() * 10);
            String randomDigit = "" + random;
            while (goal.contains(randomDigit)) {
                random = (int) (Math.random() * 10);
                randomDigit = "" + random;
            }
            goal += randomDigit;
        }
        return goal;
    }

    @Override
    public String checkGuessToGoalNumber(String goal, String guess) {
        guess += "    ";
        int cows = 0, bulls = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (goal.charAt(i) == guess.charAt(j)) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }
        String result = "";
        for (int i = 0; i < bulls; i++) {
            result = result + "B";
        }

        result = result + ",";
        for (int i = 0; i < cows; i++) {
            result = result + "C";
        }
        return result;
    }

}

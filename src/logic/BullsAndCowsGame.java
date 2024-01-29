/**
 * BullsAndCowsGame.java
 *
 * This file contains the game logic implementation for Bulls and Cows.
 * It implements the Gameable interface, defining the behavior of the game.
 *
 * @author Robert Tronhage, Ulf Bilting
 * @contact robert.tronhage@iths.se, ulf.bilting@iths.se
 * @date 2024-01-25
 */

package logic;
import IO.IO;
import database.ResultDAO;

public class BullsAndCowsGame implements Gameable {

    @Override
    public void playGame(IO io, ResultDAO resultDAO, int loggedInPlayerId)  {
        boolean answer = true;
        while (answer) {
            String goalNumber = createGoalNumber();
            io.clear();
            io.addString("New game:\n");
            io.addString(goalNumber + "\n"); //remove comment to see GoalNumber
            String playerGuess = io.getString();
            io.addString(playerGuess + "\n");
            int numberOfGuesses = 1;
            String bbcc = checkGuessToGoalNumber(goalNumber, playerGuess);
            io.addString(bbcc + "\n");
            while (!bbcc.equals("BBBB,")) {
                numberOfGuesses++;
                playerGuess = io.getString();
                io.addString(playerGuess + ": ");
                bbcc = checkGuessToGoalNumber(goalNumber, playerGuess);
                io.addString(bbcc + "\n");
            }
            resultDAO.saveResult(numberOfGuesses, loggedInPlayerId);
            resultDAO.showTopTen(io);
            answer = io.yesNo("Correct, it took " + numberOfGuesses + " guesses\nContinue?");
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

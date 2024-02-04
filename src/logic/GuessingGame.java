/**
 * GuessingGame.java
 * This file contains tests for the game logic implementation for GuessingGame.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-02-04
 */

package logic;

import IO.IO;
import database.ResultDAO;

public class GuessingGame implements Gameable {

    @Override
    public void playGame(IO io, ResultDAO resultDAO, int loggedInPlayerId) {
        boolean answer = true;

        while (answer) {
            String goalNumber = createGoalNumber();
            io.clear();
            io.addString("Guess the number between 1 and 100");
            // Kommentera ut raden nedan för att spela spelet utan att visa målnumret
            io.addString(goalNumber);

            String guess = "";
            String guessResult;

            int numberOfGuesses = 0;
            do {
                guess = io.getString();
                numberOfGuesses++;
                guessResult = checkGuessToGoalNumber(goalNumber, guess);
            } while (!guessResult.equals(goalNumber));

            io.clear();
            io.addString("Congratulations! You guessed the number in " + numberOfGuesses + " tries!");

            resultDAO.saveResult(loggedInPlayerId, numberOfGuesses);
            io.addString("Do you want to play again? (yes/no)");
            answer = io.yesNo("");
        }
    }

    @Override
    public String createGoalNumber() {
        int difficulty = 100; //sets the difficulty between 1 - N
        int goal = (int) (Math.random() * difficulty) + (1);
        String goalNumber = "" + goal;

        return goalNumber;
    }

    @Override
    public String checkGuessToGoalNumber(String goal, String guess) {
        try {
            int guessNumber = Integer.parseInt(guess);
            int goalNumber = Integer.parseInt(goal);

            if (guessNumber > goalNumber) {
                return "To high! Try again.";

            } else if (guessNumber < goalNumber) {
                return "To low! Try again.";

            } else{
                return goal;
            }
        } catch (NumberFormatException e) {
            return "invalid input";
        }
    }
}

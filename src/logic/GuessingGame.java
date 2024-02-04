package logic;

import IO.IO;
import database.ResultDAO;

import java.sql.SQLException;

public class GuessingGame implements Gameable {

    @Override
    public void playGame(IO io, ResultDAO resultDAO, int loggedInPlayerId) {
        boolean answer=true;

        while(answer){
            String goalNumber = createGoalNumber();
            io.clear();
            io.addString(goalNumber);

            String guess = io.getString();
            String guessResult = checkGuessToGoalNumber(goalNumber,guess);

            int numberOfGuesses=1;
            while(!guessResult.equals(goalNumber)){
                numberOfGuesses++;
                guess=io.getString();
            }

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
        int guessNumber = Integer.parseInt(guess);
        int goalNumber = Integer.parseInt(goal);

        if (guessNumber > goalNumber) {
            return null;

        } else if (guessNumber < goalNumber) {
            return null;

        } else if (guessNumber == goalNumber) {
            return null;
        }
        return null;
    }
}

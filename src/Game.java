/*
* Game logic is stored within this file
* Author: Robert Tronhage, robert.tronhage@iths.se
* 2024-01-25
 */

import java.sql.SQLException;

public class Game {

    public void playGame(Controller controller,ResultDAO resultDAO, int playerId) throws SQLException {
        boolean answer = true;
        while (answer) {
            String goalNumber = createGoalNumber();
            Controller.getGameWindow.clear();
            Controller.gameWindow.addString("New game:\n");
            Controller.gameWindow.addString(goalNumber);
            String guess = Controller.gameWindow.getString();
            Controller.gameWindow.addString(guess + "\n");
            int nGuess = 1;
            String bbcc = checkBC(goalNumber, guess);
            Controller.gameWindow.addString(bbcc + "\n");
            while (!bbcc.equals("BBBB,")) {
                nGuess++;
                guess = Controller.gameWindow.getString();
                Controller.gameWindow.addString(guess + ": ");
                bbcc = checkBC(goalNumber, guess);
                Controller.gameWindow.addString(bbcc + "\n");
            }
            resultDAO.saveResult(nGuess, playerId);
            ResultDAOMySQLImpl.showTopTen();
            answer = Controller.gameWindow.yesNo("Correct, it took " + nGuess + " guesses\nContinue?");
        }
    }

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

    public String checkBC(String goal, String guess) {
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

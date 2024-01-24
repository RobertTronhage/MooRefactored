import java.sql.SQLException;

public class Game {

    public static void playGame(int playerId) throws SQLException {
        boolean answer = true;
        while (answer) {
            String goalNumber = createGoalNumber();
            MainUsingDAO.gw.clear();
            MainUsingDAO.gw.addString("New game:\n");
            String guess = MainUsingDAO.gw.getString();
            MainUsingDAO.gw.addString(guess + "\n");
            int nGuess = 1;
            String bbcc = checkBC(goalNumber, guess);
            MainUsingDAO.gw.addString(bbcc + "\n");
            while (!bbcc.equals("BBBB,")) {
                nGuess++;
                guess = MainUsingDAO.gw.getString();
                MainUsingDAO.gw.addString(guess + ": ");
                bbcc = checkBC(goalNumber, guess);
                MainUsingDAO.gw.addString(bbcc + "\n");
            }
            ResultDAOMySQLImpl.saveResult(nGuess, playerId);
            ResultDAOMySQLImpl.showTopTen();
            answer = MainUsingDAO.gw.yesNo("Correct, it took " + nGuess + " guesses\nContinue?");
        }
    }

    public static String createGoalNumber() {
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

    public static String checkBC(String goal, String guess) {
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

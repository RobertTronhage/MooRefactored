/*
 * Interface for gamelogic for a numbers guessing game
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-27
 */
import java.sql.SQLException;

public interface Gameable {
    void playGame(IO io, ResultDAO resultDAO, int loggedInPlayerId) throws SQLException;

    String createGoalNumber();

    String checkGuessToGoalNumber(String goal, String guess);
}

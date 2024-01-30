/**
 * Gameable.java
 * Interface defining the contract for game-related operations.
 * Implemented by BullsAndCowsGame to provide game logic.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-25
 */

package logic;
import IO.IO;
import database.ResultDAO;

import java.sql.SQLException;

public interface Gameable {
    void playGame(IO io, ResultDAO resultDAO, int loggedInPlayerId) throws SQLException;
    String createGoalNumber();
    String checkGuessToGoalNumber(String goal, String guess);
}

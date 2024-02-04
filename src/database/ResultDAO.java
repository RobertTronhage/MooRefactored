/**
 * ResultDAO.java
 * Interface for data access operations related to game results in the Bulls and Cows game.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-25
 */

package database;

import IO.IO;

import java.sql.SQLException;

public interface ResultDAO {

    void saveResult(int nGuess, int playerId);

    void showTopTen(IO io);
}

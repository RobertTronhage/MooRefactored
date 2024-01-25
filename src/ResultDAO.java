/*
 * Interface for handling result table in DB
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */

import java.sql.SQLException;
import java.util.List;

public interface ResultDAO {

    void saveResult(int nGuess, int playerId) throws SQLException;

    void showTopTen() throws SQLException;

}

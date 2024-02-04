/**
 * PlayerDAO.java
 * Interface for data access operations related to players in the Bulls and Cows game.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-25
 */

package database;
import IO.IO;
import entity.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDAO {
    Player login(IO io);
}

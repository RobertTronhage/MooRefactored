/*
 * Interface for handling players table in DB
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
import java.sql.SQLException;
import java.util.List;

public interface PlayerDAO {
    List<Player> getAll();

    Player getByName(String name);

    Player login(IO io) throws SQLException, InterruptedException;

}

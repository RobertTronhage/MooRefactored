/*
 * Interface for handling players table in DB
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
import java.util.List;

public interface PlayerDAO {
    public List<Player> getAll();

    public Player getByName(String name);

}

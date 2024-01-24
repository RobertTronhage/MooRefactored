import java.util.List;

public interface PlayerDAO {
    public List<Player> getAll();

    public Player getByName(String name);

}

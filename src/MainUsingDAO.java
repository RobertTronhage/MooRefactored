import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainUsingDAO {

    static IO gw;

    public static void main(String[] args) throws SQLException, InterruptedException {
        gw = new SimpleWindow("Moo-refactored");
        int p1 = PlayerDAOMySQLImpl.login();
        Game.playGame(p1);
    }
}
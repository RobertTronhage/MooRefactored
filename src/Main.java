import java.sql.SQLException;

public class Main {
    static IO gw;
    public static void main(String[] args) throws SQLException, InterruptedException {
        gw = new SimpleWindow("Moo-refactored");
        int p1 = PlayerDAOMySQLImpl.login();
        Game.playGame(p1);
    }
}
import java.sql.SQLException;

public interface Gameable {
    void playGame(IO io, ResultDAO resultDAO, int loggedInPlayerId) throws SQLException;

    String createGoalNumber();

    String checkBC(String goal, String guess);
}

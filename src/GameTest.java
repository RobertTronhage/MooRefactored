import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void createGoalNumber() {
        Game game = new Game();
        assertEquals("BBBB,",game.checkBC("1234","1234"));
        assertEquals(",CCCC",game.checkBC("4321","1234"));
        assertEquals("BB,CC",game.checkBC("1243","1234"));
    }

    @Test
    void checkBC() {
    }
}
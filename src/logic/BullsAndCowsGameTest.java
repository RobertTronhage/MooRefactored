package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BullsAndCowsGameTest {

    @Test
    void createGoalNumber() {
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        assertEquals("BBBB,", bullsAndCowsGame.checkGuessToGoalNumber("1234","1234"));
        assertEquals(",CCCC", bullsAndCowsGame.checkGuessToGoalNumber("4321","1234"));
        assertEquals("BB,CC", bullsAndCowsGame.checkGuessToGoalNumber("1243","1234"));
    }

    @Test
    void checkBC() {
    }
}
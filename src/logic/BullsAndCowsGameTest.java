package logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BullsAndCowsGameTest {

    @Test
    void checkGuessToGoalNumber() {
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        assertEquals("BBBB,", bullsAndCowsGame.checkGuessToGoalNumber("1234","1234"));
        assertEquals(",CCCC", bullsAndCowsGame.checkGuessToGoalNumber("4321","1234"));
        assertEquals("BB,CC", bullsAndCowsGame.checkGuessToGoalNumber("1243","1234"));
    }

    @RepeatedTest(value = 20, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Test creation of goalNumber")
    public void testCreateGoalNumber() {
        BullsAndCowsGame game = new BullsAndCowsGame();

        String goalNumber = game.createGoalNumber();

        assertTrue(goalNumber.length() == 4, "goalNumber should be 4 didgits");

        assertTrue(goalNumber.chars().distinct().count() == 4, "each number should be unique");
    }
}
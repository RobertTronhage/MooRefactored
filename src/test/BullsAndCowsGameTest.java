/**
 * BullsAndCowsGameTest.java
 * This file contains tests for the game logic implementation for Bulls and Cows.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-29
 */

package test;

import logic.BullsAndCowsGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsGameTest {

    @Test
    void testGuessToGoalNumber() {
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        assertEquals("BBBB,", bullsAndCowsGame.checkGuessToGoalNumber("1234","1234"));
        assertEquals(",CCCC", bullsAndCowsGame.checkGuessToGoalNumber("4321","1234"));
        assertEquals("BB,CC", bullsAndCowsGame.checkGuessToGoalNumber("1243","1234"));
        assertEquals(",", bullsAndCowsGame.checkGuessToGoalNumber("0000","1234"));

        assertNotEquals("BBBB",bullsAndCowsGame.checkGuessToGoalNumber("1234","1111"));
    }

    //Should player be able to input letters instead of positive numbers?
    @Test
    void testGuessToGoalNumberWithLettersIsteadOfNumbers() {
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        String result = bullsAndCowsGame.checkGuessToGoalNumber("1234", "abcd");
        assertNotEquals("BBBB", result);
    }

    //Should player be able to input negative numbers instead of positive numbers?
    @Test
    void testGuessToGoalNumberWithNegativeNumber() {
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        String result = bullsAndCowsGame.checkGuessToGoalNumber("1234", "-1234");
        assertNotEquals("BBBB", result);
    }
    //Should player be able to input to many numbers?
    @Test
    void testGuessToGoalNumberWithToManyDigits() {
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        String result = bullsAndCowsGame.checkGuessToGoalNumber("1234", "123456789");
        assertNotEquals("BBBB", result);
    }
    //Should player be able to input to few numbers?
    @Test
    void testGuessToGoalNumberWithToFewDigits() {
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        String result = bullsAndCowsGame.checkGuessToGoalNumber("1234", "1");
        assertNotEquals("BBBB", result);
    }

    @RepeatedTest(value = 20, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Test creation of goalNumber")
    public void testCreateGoalNumber() {
        BullsAndCowsGame game = new BullsAndCowsGame();

        String goalNumber = game.createGoalNumber();

        assertTrue(goalNumber.length() == 4, "goalNumber should be 4 didgits");

        assertTrue(goalNumber.chars().distinct().count() == 4, "each number should be unique");
    }

    public void testIncorrectInput(){

    }
}
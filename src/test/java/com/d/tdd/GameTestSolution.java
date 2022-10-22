package com.d.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTestSolution {

    GameSolution gameSolution = new GameSolution();

    @Test
    public void testAllZeros() {

        rollMultipleTimes(0, 20);

        assertEquals(0, gameSolution.score());
    }

    @Test
    public void testAllOnes() {

        rollMultipleTimes(1, 20);

        assertEquals(20, gameSolution.score());
    }

    @Test
    public void testHalfOneAndHalfTwos() {

        rollMultipleTimes(1, 10);
        rollMultipleTimes(2, 10);

        assertEquals(30, gameSolution.score());
    }

    @Test
    public void testSpare() {

        rollASpare();
        rollMultipleTimes(1, 18);

        assertEquals(29, gameSolution.score());
    }

    @Test
    public void testTwoSpares() {

        rollASpare();
        rollASpare();
        rollMultipleTimes(1, 16);

        assertEquals(42, gameSolution.score());
    }

    @Test
    public void testStrike() {
        gameSolution.roll(10);
        rollMultipleTimes(1, 18);

        assertEquals(30, gameSolution.score());
    }


    private void rollASpare() {
        rollMultipleTimes(5, 2);
    }

    private void rollMultipleTimes(int pinsKnockedDown, int noOfTimes) {
        for (int roll = 1; roll <= noOfTimes; roll++) {
            gameSolution.roll(pinsKnockedDown);
        }
    }

}

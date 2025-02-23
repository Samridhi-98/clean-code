package com.c.refactoring.movie;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    @Test
    public void testIsValidRating() {    	
        assertTrue(new Movie("B1").isValidRating());
        assertTrue(new Movie("B2").isValidRating());
        assertTrue(new Movie("B3").isValidRating());
        assertTrue(new Movie("B4").isValidRating());
        assertFalse(new Movie("B5").isValidRating());
        assertFalse(new Movie("B10").isValidRating());

        assertTrue(new Movie("A10").isValidRating());
        assertTrue(new Movie("A11").isValidRating());
        assertTrue(new Movie("A99").isValidRating());

        assertFalse(new Movie("A1").isValidRating());
        assertFalse(new Movie("A2").isValidRating());
        assertFalse(new Movie("A100").isValidRating());
        assertFalse(new Movie("A786").isValidRating());
    }

    @Test
    public void shouldReturnValidRating() {
        assertTrue(new MovieSolution("B1").isValidRating());
        assertTrue(new MovieSolution("B2").isValidRating());
        assertTrue(new MovieSolution("B3").isValidRating());
        assertTrue(new MovieSolution("B4").isValidRating());
        assertFalse(new MovieSolution("B5").isValidRating());
        assertFalse(new MovieSolution("B10").isValidRating());

        assertTrue(new MovieSolution("A10").isValidRating());
        assertTrue(new MovieSolution("A11").isValidRating());
        assertTrue(new MovieSolution("A99").isValidRating());

        assertFalse(new MovieSolution("A1").isValidRating());
        assertFalse(new MovieSolution("A2").isValidRating());
        assertFalse(new MovieSolution("A100").isValidRating());
        assertFalse(new MovieSolution("A786").isValidRating());
    }

}
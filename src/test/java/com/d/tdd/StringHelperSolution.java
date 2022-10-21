package com.d.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperSolution {
    StringHelper helper = new StringHelper();

    @Test
    public void testReplaceAInFirstTwoPositions() {
        assertEquals("BCD", helper.replaceAInFirstTwoPositions("ABCD"));
        assertEquals("CD", helper.replaceAInFirstTwoPositions("AACD"));
        assertEquals("BCD", helper.replaceAInFirstTwoPositions("BACD"));
        assertEquals("AA", helper.replaceAInFirstTwoPositions("AAAA"));
        assertEquals("MNAA", helper.replaceAInFirstTwoPositions("MNAA"));
        assertEquals("", helper.replaceAInFirstTwoPositions(""));
        assertEquals("", helper.replaceAInFirstTwoPositions("A"));
        assertEquals("", helper.replaceAInFirstTwoPositions("AA"));
        assertEquals("B", helper.replaceAInFirstTwoPositions("B"));
        assertEquals("BC", helper.replaceAInFirstTwoPositions("BC"));
    }

    @Test
    public void testAreFirstTwoAndLastTwoCharsTheSame() {
        assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame(""));
        assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("A"));
        assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("AB"));
        assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABC"));
        assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("AAA"));
        assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("ABCAB"));
        assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABCDEBA"));
    }
}

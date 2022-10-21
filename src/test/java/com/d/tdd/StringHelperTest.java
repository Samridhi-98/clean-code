package com.d.tdd;

import org.junit.Test;
import static org.junit.Assert.*;

class StringHelperTest {
	//"", "A", "AA", "B", "BC"
	StringHelper helper = new StringHelper();

	@Test
	void testReplaceAInFirst2Positions() {
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
	
	//""=>false, "A"=>false, "AB"=>true, "ABC"=>false, "AAA"=>true, "ABCAB"=>true, "ABCDEBA"=>false
	//Red
	//Green
	//Refactor

	@Test
	void testAreFirstTwoAndLastTwoCharsTheSame() {
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame(""));
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("A"));
		assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("AB"));
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABC"));
		assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("AAA"));
		assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("ABCAB"));
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABCDEBA"));	
	}

}

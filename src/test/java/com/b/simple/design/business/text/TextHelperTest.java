package com.b.simple.design.business.text;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Disabled;

public class TextHelperTest {

	TextHelper helper = new TextHelper();
	TextHelperSolution helperSolution = new TextHelperSolution();
	
	@Test
	@Disabled
	public void testSwapLastTwoCharacters() {
		assertEquals("",helper.swapLastTwoCharacters(""));
		assertEquals("A",helper.swapLastTwoCharacters("A"));
		assertEquals("BA",helper.swapLastTwoCharacters("AB"));
		assertEquals("RANI",helper.swapLastTwoCharacters("RAIN"));
	}

	@Test
	@Disabled
	public void testTruncateAInFirst2Positions() {
		assertEquals("",helper.truncateAInFirst2Positions(""));
		assertEquals("BCD",helper.truncateAInFirst2Positions("ABCD"));
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
		assertEquals("BCD",helper.truncateAInFirst2Positions("BACD"));
		assertEquals("BBAA",helper.truncateAInFirst2Positions("BBAA"));
	}

	@Test
	public void shouldSwapLastTwoCharacters() {
		assertEquals("",helperSolution.swapLastTwoCharacters(""));
		assertEquals("A",helperSolution.swapLastTwoCharacters("A"));
		assertEquals("BA",helperSolution.swapLastTwoCharacters("AB"));
		assertEquals("RANI",helperSolution.swapLastTwoCharacters("RAIN"));
	}

	@Test
	public void shouldTruncateAInFirst2Positions() {
		assertEquals("",helperSolution.truncateAInFirst2Positions(""));
		assertEquals("BCD",helperSolution.truncateAInFirst2Positions("ABCD"));
		assertEquals("CD",helperSolution.truncateAInFirst2Positions("AACD"));
		assertEquals("BCD",helperSolution.truncateAInFirst2Positions("BACD"));
		assertEquals("BBAA",helperSolution.truncateAInFirst2Positions("BBAA"));
	}
}

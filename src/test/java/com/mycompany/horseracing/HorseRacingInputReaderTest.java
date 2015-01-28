package com.mycompany.horseracing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test case for HorseRacingInputReader.java
 * 
 * @author colin
 *
 */
public class HorseRacingInputReaderTest extends TestCase {

	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		GamePlay.gameWon = false;
	}

	/**
	 * Testing the readInput method
	 */
	@Test
	public void testReadInput(){
		
		String input = "Star, Dakota, Cheyenne, Misty, Spirit\n" + 
				"1 60\n" +
				"3 5\n" +
				"1 60\n" +
				"4 5\n" +
				"4 10\n" +
				"2 5\n" +
				"5 10\n" +
				"1 60\n" +
				"3 20\n" +
				"7 10\n" +
				"1 40\n" +
				"2 60\n";
		
		List<String> inputLines =  HorseRacingInputReader.readInput(input);
		
		List<String> expectedInput = new ArrayList<>();
		expectedInput.add("Star, Dakota, Cheyenne, Misty, Spirit");
		expectedInput.add("1 60");
		expectedInput.add("3 5");
		expectedInput.add("1 60");
		expectedInput.add("4 5");
		expectedInput.add("4 10");
		expectedInput.add("2 5");
		expectedInput.add("5 10");
		expectedInput.add("1 60");
		expectedInput.add("3 20");
		expectedInput.add("7 10");
		expectedInput.add("1 40");
		expectedInput.add("2 60");
		
		assertEquals(expectedInput, inputLines);
		assertNotNull(inputLines);
		
	}
}

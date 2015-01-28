/**
 * 
 */
package com.mycompany.horseracing;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test case for GamePlay.java
 * 
 * @author colin
 *
 */
public class GamePlayTest extends TestCase {

	/**
	 * @param name
	 */
	public GamePlayTest(String name) {
		super(name);
	}


	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Tests the whole game play
	 */
	@Test
	public void testGamePlay(){
		
		GamePlay game = new GamePlay();
		
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
		
		game.startGame(input);
		
		String expectedGameEndResult = "Position, Lane, Horse name\n" + 
				"1, 1, Star\n" +
				"2, 3, Cheyenne\n" +
				"3, 4, Misty\n" +
				"4, 5, Spirit\n" +
				"5, 2, Dakota\n";
		
		String actualGameEndResult = HorseRacingResultsWriter.printOutRaceResults(game.getGameResults());
		
		assertNotNull(actualGameEndResult);
		assertEquals(expectedGameEndResult, actualGameEndResult);
		
		
	}


}

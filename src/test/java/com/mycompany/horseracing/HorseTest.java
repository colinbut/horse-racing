/**
 * 
 */
package com.mycompany.horseracing;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * @author colin
 *
 */
public class HorseTest extends TestCase {

	private Horse horse;
	
	/**
	 * @param name
	 */
	public HorseTest(String name) {
		super(name);
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected static void tearDownAfterClass() throws Exception {
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	//@Before
	protected void setUp() throws Exception {
		super.setUp();
		horse = new Horse("Star", 1);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	//@Before
	protected void tearDown() throws Exception {
		super.tearDown();
		horse = null;
		GamePlay.gameWon = false;
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetName(){
		
		String expectedName = "Star";
		String actualName = horse.getName();
		
		assertEquals(expectedName, actualName);
		assertNotSame("Name should not be Misty", "Misty", actualName);
		assertNotNull(actualName);
		assertSame(expectedName, actualName);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetLane(){
		
		int expectedLane = 1;
		int actualLane = horse.getLane();
		
		assertEquals(expectedLane, actualLane);
		assertNotSame(3, actualLane);
		assertSame(expectedLane, actualLane);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetYardsAdvanced(){
		
		int expected = 60;
		horse.advance(60);
		int actual = horse.getYardsAdvanced();
		
		assertEquals(expected, actual);
		assertNotSame(20, actual);
		assertNotSame(0, actual);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testAdvance(){
		
		// normal condition
		int expected = 20;
		horse.advance(20);
		int actual = horse.getYardsAdvanced();
		assertEquals(expected, actual);
		assertNotSame(120, actual);
		assertFalse(GamePlay.gameWon);
		
		// negative testing
		horse.advance(-3);
		actual = horse.getYardsAdvanced();
		assertNotSame(57, actual);
		assertNotSame(-3, actual);
		
		// test condition of winning the game
		horse.advance(60);
		horse.advance(60);
		horse.advance(60);
		horse.advance(20);
		assertEquals(HorseRacing.DISTANCE, horse.getYardsAdvanced());
		assertTrue(GamePlay.gameWon);
		
		// test that once game is won it doesn't advance further
		horse.advance(40);
		assertEquals(HorseRacing.DISTANCE, horse.getYardsAdvanced());
		
	}

}

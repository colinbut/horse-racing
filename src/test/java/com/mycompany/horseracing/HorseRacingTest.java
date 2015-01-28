/**
 * 
 */
package com.mycompany.horseracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test case for HorseRacing.java
 * 
 * @author colin
 *
 */
public class HorseRacingTest extends TestCase {

	private HorseRacing horseRace = null;
	private Horse horse1;
	private Horse horse2;
	private Horse horse3;
	private Horse horse4;
	private Horse horse5;
	private Horse horse6;
	private Horse horse7;
	private Horse horse8;
	
	private Horse[] horses = null;


	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		horseRace = new HorseRacing();
		horses = new Horse[]{
			horse1 = new Horse("Star", 1),
			horse2 = new Horse("Dakota", 2),
			horse3 = new Horse("Cheyenne", 3),
			horse4 = new Horse("Misty", 4),
			horse5 = new Horse("Spirit", 5),
			horse6 = new Horse("Jimmy", 6),
			horse7 = new Horse("Sunshine", 7),
			horse8 = new Horse("Lucky", 8),
		};
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		horseRace = null;
		horse1 = null;
		horse2 = null;
		horse3 = null;
		horse4 = null;
		horse5 = null;
		horse6 = null;
		horse7 = null;
		horse8 = null;
		GamePlay.gameWon = false;
	}
	
	/**
	 * Testing the startRace() method
	 */
	@Test
	public void testStartRace(){
		
		List<Horse> expected = new ArrayList<Horse>(
									Arrays.asList(
											new Horse[]{horse1,horse2,horse3, horse4,horse5,horse6,horse7}));
		
		horseRace.startRace(expected);
		
		List<Horse> actual = horseRace.getHorses();
		
		assertEquals(expected, actual);
		assertSame(expected, actual);
		assertNotNull(actual);
		assertNotSame(new ArrayList<>(), actual);
		
		// test each horse actually exist
		for(Horse horse : actual){
			assertNotNull(horse);
		}
	}
	
	/**
	 * Testing the race() method
	 */
	@Test
	public void testRace(){
		
		List<Horse> horses = new ArrayList<Horse>(
				Arrays.asList(
						new Horse[]{horse1,horse2,horse3, horse4,horse5,horse6,horse7}));

		horseRace.startRace(horses);
		
		horseRace.race(1, 60);
		horseRace.race(2, 40);
		horseRace.race(3, 20);
		horseRace.race(-1, 20);
		
		assertEquals(60, horse1.getYardsAdvanced());
		assertEquals(40, horse2.getYardsAdvanced());
		assertEquals(20, horse3.getYardsAdvanced());
		
		assertNotSame(80, horse1.getYardsAdvanced());
		
	}
	
	/**
	 * Testing the finishRace() method
	 */
	@Test
	public void testFinishRace(){
		
		List<Horse> horses = new ArrayList<Horse>(
				Arrays.asList(
						new Horse[]{horse1,horse2,horse3, horse4,horse5,horse6,horse7}));

		horseRace.startRace(horses);
		
		horseRace.race(1, 60);
		horseRace.race(2, 40);
		horseRace.race(3, 20);
		
		horseRace.finishRace();
		
		SortedMap<Integer, Horse> actualResults = horseRace.getResults();
		
		assertNotNull(actualResults);
		assertFalse(actualResults.size() == 0);
		assertTrue(actualResults.size() > 0);
		
		
		for(Map.Entry<Integer, Horse> resultEntry : actualResults.entrySet()){
			
			int yardMoved = resultEntry.getKey();
			Horse horse = resultEntry.getValue();
			
			switch(horse.getLane()){
			case 1:
				assertEquals(60, yardMoved);
				assertEquals("Star", horse.getName());
				break;
			case 2:
				assertEquals(40, yardMoved);
				assertEquals("Dakota", horse.getName());
				break;
			case 3:
				assertEquals(20, yardMoved);
				assertEquals("Cheyenne", horse.getName());
				break;
			default:
				break;
			}
			
		}
		
		
	}

}

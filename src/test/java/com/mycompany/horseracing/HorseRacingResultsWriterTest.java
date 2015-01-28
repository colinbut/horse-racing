package com.mycompany.horseracing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * 
 * @author colin
 *
 */
public class HorseRacingResultsWriterTest extends TestCase {

	public HorseRacingResultsWriterTest(String name) {
		super(name);
	}

	protected static void setUpBeforeClass() throws Exception {
	}

	protected static void tearDownAfterClass() throws Exception {
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * 
	 */
	@Test
	public void testPrintOutRaceResults(){
		
		Horse horse1 = new Horse("Star", 1);
		Horse horse2 = new Horse("Dakota", 2);
		Horse horse3 = new Horse("Cheyenne", 3);
		Horse horse4 = new Horse("Misty", 4);
		Horse horse5 = new Horse("Spirit", 5);
		Horse horse7 = new Horse("Horse-DoesNot-Exist", 6);
		
		HorseRacing horseRacing = new HorseRacing();
		List<Horse> horses = new ArrayList<>();
		horses.add(horse1);
		horses.add(horse2);
		horses.add(horse3);
		horses.add(horse4);
		horses.add(horse5);
		horseRacing.startRace(horses);
		
		horse1.advance(60);
		horse3.advance(5);
		horse1.advance(60);
		horse4.advance(5);
		horse4.advance(10);
		horse2.advance(5);
		horse5.advance(10);
		horse1.advance(60);
		horse3.advance(20);
		horse7.advance(10);
		horse1.advance(40);
		horse2.advance(60);
		
		horseRacing.finishRace();
		
		String actualResults = HorseRacingResultsWriter.printOutRaceResults(horseRacing.getResults());
		
		String expectedResults = "Position, Lane, Horse name\n" + 
							"1, 1, Star\n" +
							"2, 3, Cheyenne\n" +
							"3, 4, Misty\n" +
							"4, 5, Spirit\n" +
							"5, 2, Dakota\n";
		
		assertEquals(expectedResults, actualResults);
		
		
	}

}

/**
 * 
 */
package com.mycompany.horseracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;


/**
 * The game engine. This class controls the play of the game
 * 
 * @author colin
 *
 */
public class GamePlay implements IGame{

	/** global flag to indicate whether the game has been won or not */
	public static boolean gameWon = false;
	
	private HorseRacing horseRace = null;
	private List<Integer> holes = null;
	private List<Integer> lanes = null;
	
	/**
	 * Constructor
	 */
	public GamePlay(){
		
		horseRace = new HorseRacing();
		
		lanes = new ArrayList<Integer>(
			Arrays.asList(new Integer[] {1,2,3,4,5,6,7}));
		
		holes = new ArrayList<Integer>(
			Arrays.asList(new Integer[]{5,5,5,5,10,10,10,20,20,40,60}));
		
	}
	
	/**
	 * Default startGame() method.
	 * 
	 * Only used for the default sample data:
	 * 
	 * Star, Dakota, Cheyenne, Misty, Spirit
     *		1 60
     *		3 5
     *		1 60
     *		4 5
     *		4 10
     *		2 5
     *		5 10
     *		1 60
     *		3 20
     *		7 10
     *		1 40
     * 		2 60
     * 
     * when running as a standalone program
	 */
	public void startGame(){
		String input = "Star, Dakota, Cheyene, Misty, Spirit\n" + 
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
		
		startGame(input);
	}
	
	/**
	 * 
	 * The logic for the game play is:
	 * 
	 * - Reads in input
	 * - Sets up the horses
	 * - Performs a series of validation checks to ensure the input data are correct
	 * - race (ball throws)
	 * - If game is won then end it
	 * 
	 * @param inputData the input
	 */
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.horseracing.Game#startGame()
	 */
	@Override
	public void startGame(String inputData){
			
		/* reads in the input */
		List<String> input = HorseRacingInputReader.readInput(inputData);
		
		/* starts the race */
		String[] horsesNames = input.get(0).split(", "); //assume first line is ..
		horseRace.startRace(initialiseHorses(horsesNames));
		
		/* racing... */
		for(int i = 1; i < input.size(); i++){
			String[] ballThrow = input.get(i).split(" ");
			
			validateAndThrowBalls(ballThrow);
			
			// if the game is won - we ignore the rest
			if(gameWon){
				horseRace.finishRace();
				endGame();
			}
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.horseracing.Game#endGame()
	 */
	@Override
	public void endGame(){
		HorseRacingResultsWriter.printOutRaceResults(horseRace.getResults());
		System.exit(1);
	}
	
	/**
	 * Gets back the results of the race
	 * 
	 * @return results
	 */
	public SortedMap<Integer, Horse> getGameResults(){
		return horseRace.getResults();
	}
	
	
	/*
	 * Sets up the horses
	 * 
	 * @param horsesNames the names of the horses
	 * @return horses the list of horses objects
	 */
	private List<Horse> initialiseHorses(String[] horsesNames){
		
		if(horsesNames.length > lanes.size()){
			System.out.println("Too many horses in the game. ");
			System.out.println("Please restart game with correct data. ");
			System.out.println(-1);
		}
		
		List<Horse> horses = new ArrayList<>();
		
		for(int j = 0; j < horsesNames.length; j++){
			horses.add(new Horse(horsesNames[j], j + 1));
		}
		
		return horses;
		
	}
	
	/*
	 * Helper method to validate the ball throw input lines
	 */
	private void validateAndThrowBalls(String[] ballThrow){
		
		if(ballThrow.length != 2){
			System.out.println("Ball Throw data incorrect");
			System.exit(-1);
		}
		
		try{
			int lane = Integer.parseInt(ballThrow[0]);
			int yards = Integer.parseInt(ballThrow[1]);
			
			if((holes.contains(yards) && lanes.contains(lane))){
				
				// throw ball (i.e. advance)
				horseRace.race(lane, yards);
			}
		}
		catch(NumberFormatException e){
			System.err.println("Ball Throw data not in numeric format");
			System.exit(-1);
		}
		catch(Exception e){
			System.out.println("Unexpected Error occurred");
			System.exit(-1);
		}
		
	}
	
	
}

/**
 * 
 */
package com.mycompany.horseracing;

/**
 * An 'data class' to represent the Horse object
 * 
 * @author colin
 *
 */
public class Horse {

	private String name = null;
	private int lane;
	private int yardsAdvanced= 0;
	
	/**
	 * Constructor
	 * 
	 * @param name the horse's name
	 * @param lane the lane the horse is in
	 */
	public Horse(String name, int lane){
		this.name = name;
		this.lane = lane;
	}
	
	/**
	 * Gets the horse's name
	 * 
	 * @return horse's name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returns the lane the horse is in
	 * 
	 * @return the lane number
	 */
	public int getLane(){
		return lane;
	}
	
	
	/**
	 * Gets the number of yards this horse has moved
	 * 
	 * @return yards moved
	 */
	public int getYardsAdvanced(){
		return yardsAdvanced;
	}
	
	/**
	 * Move the horse with the given distance
	 * 
	 * @param yard the number of yards to advance
	 */
	public void advance(int yard){
		
		// while the game is not yet won and number of yards to move is valid
		if(yard >= 0 && !GamePlay.gameWon){
			
			yardsAdvanced += yard;
			
			if(yardsAdvanced >= HorseRacing.DISTANCE){
				// this horse has won the race
				GamePlay.gameWon = true;
			}
			
		}
		
		// Assumption: yard will not be a negative value passed in by caller
		
	}
	
	
	
}

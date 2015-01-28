/**
 * 
 */
package com.mycompany.horseracing;

/**
 * Representation of a "Game"
 * 
 * @author colin
 *
 */
public interface IGame {

	/**
	 * Starts the game
	 * 
	 * @param inputData the input
	 */
	void startGame(String inputData);
	
	/**
	 * Ends the game
	 */
	void endGame();
}

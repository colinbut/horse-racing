/**
 * 
 */
package com.mycompany.horseracing;

import java.util.List;

/**
 * Representation of 'Horse Racing" in general
 * 
 * @author colin
 *
 */
public interface IHorseRacing {

	/**
	 * Starts the horse race
	 * 
	 * @param horses list of horses in the race
	 */
	void startRace(List<Horse> horses);
	
	/**
	 * Race 
	 * 
	 * @param lane lane number
	 * @param yard the number of yards to move
	 */
	void race(int lane, int yard);
	
	/**
	 * Finishes the race
	 */
	void finishRace();
}

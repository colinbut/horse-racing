/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model.state;

/**
 * {@link GameState} interface
 * 
 * @author colin
 *
 */
public interface GameState {

	/**
	 * The action to do upon changing to the current state
	 */
	void doAction();
	
}

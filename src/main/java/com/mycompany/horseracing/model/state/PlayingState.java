/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model.state;

import org.apache.log4j.Logger;

/**
 * {@link PlayingState} class
 * 
 * @author colin
 *
 */
public class PlayingState implements GameState {

	final Logger logger = Logger.getLogger(getClass()); 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAction() {
		logger.info("Entered playing state");
	}

}

/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import org.apache.log4j.Logger;

/**
 * {@link StartedState} class
 * 
 * @author colin
 *
 */
public class StartedState implements GameState {

	final Logger logger = Logger.getLogger(getClass()); 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAction() {
		logger.info("Entered started state");
	}

}

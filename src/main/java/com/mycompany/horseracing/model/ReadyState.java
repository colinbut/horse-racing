/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import org.apache.log4j.Logger;

/**
 * {@link ReadyState} class
 * 
 * @author colin
 *
 */
public class ReadyState implements GameState {

	final Logger logger = Logger.getLogger(getClass()); 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAction() {
		logger.info("Entered ready state");
	}

}

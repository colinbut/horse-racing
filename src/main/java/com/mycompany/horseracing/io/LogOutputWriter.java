/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.io;

import org.apache.log4j.Logger;

/**
 * {@link LogOutputWriter} class
 * 
 * @author colin
 *
 */
public class LogOutputWriter implements OutputWriter {

	final Logger logger = Logger.getLogger(getClass()); 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeOutput(String text) {
		logger.info(text);
	}

}

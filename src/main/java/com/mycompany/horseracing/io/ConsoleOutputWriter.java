/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.io;

/**
 * @author colin
 *
 */
public class ConsoleOutputWriter implements OutputWriter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void writeOutput(String text) {
		System.out.println(text);
	}

}

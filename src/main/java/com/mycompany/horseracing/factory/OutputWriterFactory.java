/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.factory;

import com.mycompany.horseracing.io.ConsoleOutputWriter;
import com.mycompany.horseracing.io.LogOutputWriter;
import com.mycompany.horseracing.io.OutputWriter;

/**
 * {@link OutputWriterFactory} factory - used to create output writers
 * 
 * @author colin
 *
 */
public final class OutputWriterFactory extends GameFactory<WriterType, OutputWriter>{

	// eager initialization
	private static OutputWriterFactory factory = new OutputWriterFactory();
	
	private OutputWriterFactory() {}
	
	/**
	 * Singleton Design Pattern
	 * 
	 * @return factory
	 */
	public static OutputWriterFactory getFactory() {
		return factory;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public OutputWriter getObject(WriterType writerType, Object... args) {
		if(writerType == WriterType.CONSOLE) {
			return new ConsoleOutputWriter();
		} else if(writerType == WriterType.LOG) {
			return new LogOutputWriter();
		}
		throw new RuntimeException();
	}
}

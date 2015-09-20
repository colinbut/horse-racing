/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.factory;

import com.mycompany.horseracing.io.ConsoleInputReader;
import com.mycompany.horseracing.io.FileInputReader;
import com.mycompany.horseracing.io.InputReader;
import com.mycompany.horseracing.io.ReaderType;

/**
 * {@link InputReaderFactory} factory - create input readers
 * 
 * @author colin
 */
public final class InputReaderFactory extends GameFactory<ReaderType, InputReader> {

	// eager initialization
	private static InputReaderFactory factory = new InputReaderFactory();
	
	private InputReaderFactory() {}
	
	/**
	 * Singleton Design Pattern
	 * 
	 * @return factory
	 */
	public static InputReaderFactory getFactory() {
		return factory;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public InputReader getObject(ReaderType readerType, Object... args) {
		if(readerType == ReaderType.FILE) {
			return new FileInputReader((String)args[0]);
		} else if(readerType == ReaderType.CONSOLE) {
			return new ConsoleInputReader();
		}
		
		throw new RuntimeException();
	}
}

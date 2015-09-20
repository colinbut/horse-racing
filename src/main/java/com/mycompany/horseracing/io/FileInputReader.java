/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

import com.mycompany.horseracing.factory.GameFactory;
import com.mycompany.horseracing.factory.InputActionFactory;

/**
 * {@link FileInputReader} - a reader that reads from a file
 * 
 * @author colin
 *
 */
public class FileInputReader implements InputReader {

	final Logger logger = Logger.getLogger(getClass());
	
	private String fileName;
	
	private GameFactory<InputActionType, InputAction> factory = InputActionFactory.getFactory();
	
	/**
	 * Constructor
	 * 
	 * @param fileName
	 */
	public FileInputReader(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void readInput() {
		Objects.requireNonNull(fileName);
		readInputFromFile(factory.getObject(InputActionType.GAME_INPUT_ACTION));
	}
	
	
	private void readInputFromFile(InputAction inputAction) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
			String line = "";
			List<String> lines = new ArrayList<>();
			while((line = reader.readLine()) != null) {
				lines.add(line);
			}
			inputAction.action(lines);
			
		} catch (IOException e) {
			logger.error(e);
		}
	}

}

/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import com.mycompany.horseracing.io.FileInputReader;
import com.mycompany.horseracing.io.InputReader;

/**
 * {@link GameApplication} class
 * 
 * @author colin
 *
 */
public class GameApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GameEngine game = new GameEngine();
		
		InputReader fileInputReader = new FileInputReader("src/main/resources/input.txt");
		fileInputReader.readInput();
		
		
	}

}
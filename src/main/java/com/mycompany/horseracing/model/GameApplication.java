/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

/**
 * {@link GameApplication} class - main entry class
 * 
 * @author colin
 *
 */
public class GameApplication {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		GameEngine game = GameEngine.getGameEngine();
		
		String file = "src/main/resources/input.txt";
		if(args.length == 1) {
			file = args[0];
		} 
		
		game.playGame(file);
		
	}

}

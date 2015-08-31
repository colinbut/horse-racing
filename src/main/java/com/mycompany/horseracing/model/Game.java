/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author colin
 *
 */
public class Game {

	private List<Player> players;
	private Race race;
	
	public Game() {
		players = new ArrayList<>();
		race = new Race();
	}
	
	private void gameSetup() {
		
	}
	
	
}

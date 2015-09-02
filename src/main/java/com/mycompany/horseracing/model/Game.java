/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.horseracing.domain.Player;
import com.mycompany.horseracing.domain.Race;

/**
 * @author colin
 *
 */
public class Game {

	
	
	private List<Player> players;
	private Race race;
	
	public Game() {
		setPlayers(new ArrayList<>());
		race = new Race();
	}
	
	private void gameSetup() {
		
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
}

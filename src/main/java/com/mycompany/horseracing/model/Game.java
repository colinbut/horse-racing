/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mycompany.horseracing.domain.Player;
import com.mycompany.horseracing.domain.Race;

/**
 * @author colin
 *
 */
public class Game {

	final Logger logger = Logger.getLogger(getClass()); 
	
	private List<Player> players;
	private Race race;
	
	public Game() {
		setPlayers(new ArrayList<>());
		race = new Race();
		gameSetup();
	}
	
	private void gameSetup() {
		logger.info("initialising game");
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
}

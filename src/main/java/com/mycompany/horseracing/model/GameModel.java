/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;

/**
 * {@link GameModel} - game data model of the game
 * 
 * Singleton pattern
 * 
 * @author colin
 *
 */
public class GameModel extends Observable {

	final Logger logger = Logger.getLogger(getClass()); 
	
	private static GameModel INSTANCE = null;
	
	private String[] horsesNames;
	private List<PlayerBalls> playersBalls;
	
	private boolean horsesReady;
	
	public boolean isHorsesReady() {
		return horsesReady;
	}

	public void setHorsesReady(boolean horsesReady) {
		this.horsesReady = horsesReady;
	}

	private GameModel() {
		logger.info("initialising GameModel");
		playersBalls = Collections.emptyList();
	}
	
	public static GameModel getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new GameModel();
		}
		return INSTANCE;
	}

	public String[] getHorsesNames() {
		return horsesNames;
	}
	
	public void setHorsesNames(String[] horsesNames) {
		this.horsesNames = horsesNames;
		notifyChanges(horsesNames);
	}

	public List<PlayerBalls> getPlayersBalls() {
		return playersBalls;
	}
	
	public void setPlayersBalls(List<PlayerBalls> playersBalls) {
		this.playersBalls = playersBalls;
		notifyChanges(playersBalls);
	}
	
	private void notifyChanges(Object obj) {
		this.setChanged();
		this.notifyObservers(obj);
	}
	
	@Override
	public String toString() {
		return "GameModel [horsesNames=" + Arrays.toString(horsesNames) + ", playersBalls="
				+ playersBalls + "]";
	}
		
}

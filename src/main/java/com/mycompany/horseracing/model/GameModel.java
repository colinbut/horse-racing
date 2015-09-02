/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.Collections;
import java.util.List;


import org.apache.log4j.Logger;

/**
 * {@link GameModel} - game data model of the game
 * 
 * Singleton pattern
 * 
 * @author colin
 *
 */
public class GameModel extends AbstractGameModel {

	final Logger logger = Logger.getLogger(getClass()); 
	
	private static GameModel INSTANCE = null;
	
	private String[] horsesNames;
	private List<PlayerBallsMapPair> playersBallsMap;
	
	private GameModel() {
		logger.info("initialising GameModel");
		playersBallsMap = Collections.emptyList();
	}
	
	public static GameModel getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new GameModel();
		}
		return INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void populateHorseNames(String[] horsesNames) {
		this.horsesNames = horsesNames;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void populatePlayersBallsMap(List<PlayerBallsMapPair> playersBallsMap) {
		this.playersBallsMap = playersBallsMap;
	}

	public String[] getHorsesNames() {
		return horsesNames;
	}

	public List<PlayerBallsMapPair> getPlayersBallsMap() {
		return playersBallsMap;
	}
	
	
}

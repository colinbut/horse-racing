/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	private List<String> horsesNames;
	private List<Integer> horseNumbers;
	private List<Integer> ballNumbers;
	
	private GameModel() {
		logger.info("initialising GameModel");
		horsesNames = new ArrayList<>();
		horseNumbers = new ArrayList<>();
		ballNumbers = new ArrayList<>();
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
		this.horsesNames = Arrays.stream(horsesNames).collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void populatePlayersBallsMap(Map<Integer, Integer> playersBallsMap) {
		for(Map.Entry<Integer, Integer> entry : playersBallsMap.entrySet()) {
			horseNumbers.add(entry.getKey());
			ballNumbers.add(entry.getValue());
		}
	}

	public List<String> getHorsesNames() {
		return horsesNames;
	}

	public List<Integer> getHorseNumbers() {
		return horseNumbers;
	}

	public List<Integer> getBallNumbers() {
		return ballNumbers;
	}
	
	
}

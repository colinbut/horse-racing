/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.Map;
import java.util.Observable;

import org.apache.log4j.Logger;

/**
 * {@link AbstractGameModel} class
 * 
 * Template method pattern
 * 
 * @author colin
 *
 */
public abstract class AbstractGameModel extends Observable {

	final Logger logger = Logger.getLogger(getClass()); 
	
	/**
	 * 
	 * @param horsesNames
	 * @param playersBallsMap
	 */
	public final void populateGameData(String[] horsesNames, Map<Integer, Integer> playersBallsMap) {
		populateHorseNames(horsesNames);
		populatePlayersBallsMap(playersBallsMap);
		notifyGameEngine();
	}
	
	/**
	 * 
	 * @param horsesNames
	 */
	protected abstract void populateHorseNames(String[] horsesNames);
	
	/**
	 * 
	 * @param playersBallsMap
	 */
	protected abstract void populatePlayersBallsMap(Map<Integer, Integer> playersBallsMap);
	
	/*
	 * 
	 */
	final void notifyGameEngine() {
		logger.info("Game model data populated - signalling to Game Engine");
		this.setChanged();
		this.notifyObservers();
	}
}

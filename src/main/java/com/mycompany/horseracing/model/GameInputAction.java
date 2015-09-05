/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mycompany.horseracing.io.InputAction;

/**
 * {@link GameInputAction} class
 * 
 * @author colin
 *
 */
public class GameInputAction implements InputAction {

	final Logger logger = Logger.getLogger(getClass());
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void action(List<String> inputLines) {
		
		GameModel gameModel = GameModel.getInstance();
		
		if(logger.isDebugEnabled()) {
			inputLines.stream().forEach(line -> {logger.debug(line);});
		}
		
		String horses = inputLines.get(0); // assume first line is horses names
		String[] horsesNames = horses.split(", ");
		
		List<PlayerBallsMapPair> playerBallsPairList = new ArrayList<>();
		
		for(int i = 1; i < inputLines.size(); i++) {
			String[] line = inputLines.get(i).split(" ");
			
			playerBallsPairList.add(new PlayerBallsMapPair(Integer.parseInt(line[0]), 
					Integer.parseInt(line[1])));
		}
		
		if(logger.isDebugEnabled()) {
			playerBallsPairList.stream().forEach((playerBallsPair) -> {
				logger.debug(playerBallsPair);
			});
		}
		
		
		gameModel.populateGameData(horsesNames, playerBallsPairList);
	}

}

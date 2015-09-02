/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mycompany.horseracing.io.InputAction;

/**
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
		
		if(logger.isDebugEnabled()) {
			inputLines.stream().forEach(line -> {logger.debug(line);});
		}
		
		String horses = inputLines.get(0); // assume first line is horses names
		String[] horsesNames = horses.split(", ");
		
		Map<Integer, Integer> playerBallsMap = new HashMap<>();
		
		for(int i = 1; i < inputLines.size(); i++) {
			String[] line = inputLines.get(i).split(" ");
			
			if(logger.isDebugEnabled()) {
				logger.debug(line);
			}
			
			playerBallsMap.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
		}
		
		if(logger.isDebugEnabled()) {
			playerBallsMap.forEach((key,value) -> {logger.debug(key + " " + value);});
		}
		
		GameModel gameModel = GameModel.getInstance();
		gameModel.populateGameData(horsesNames, playerBallsMap);
	}

}

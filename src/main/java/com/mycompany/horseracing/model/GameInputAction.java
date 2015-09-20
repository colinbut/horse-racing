/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
		
		// we got the horses name - setup the game to be played
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<?> future = executor.submit(new Runnable() {

			@Override
			public void run() {
				gameModel.setHorsesNames(horsesNames);				
			}
		});
		
		while(!gameModel.isHorsesReady()) {
			logger.info("Horses not ready yet - still waiting");
		}
		
		// it must be done now
		if(future.isDone()) {
			List<PlayerBalls> playerBalls = new ArrayList<>();
			
			// single thread of playing
			for(int i = 1; i < inputLines.size(); i++) {
				String[] line = inputLines.get(i).split(" ");
				
				playerBalls.add(new PlayerBalls(Integer.parseInt(line[0]), 
						Integer.parseInt(line[1])));
				
				
			}
			
			gameModel.setPlayersBalls(playerBalls);
			
			executor.shutdown();
		}
		
	}

}

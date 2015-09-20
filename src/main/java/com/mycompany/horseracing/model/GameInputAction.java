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

import com.mycompany.horseracing.domain.Ball;
import com.mycompany.horseracing.domain.GameObject;
import com.mycompany.horseracing.domain.GameObjectType;
import com.mycompany.horseracing.domain.Player;
import com.mycompany.horseracing.factory.GameFactory;
import com.mycompany.horseracing.factory.GameObjectFactory;
import com.mycompany.horseracing.io.InputAction;

/**
 * {@link GameInputAction} class
 * 
 * @author colin
 *
 */
public class GameInputAction implements InputAction {

	final Logger logger = Logger.getLogger(getClass());
	
	private GameFactory<GameObjectType, GameObject> factory = GameObjectFactory.gameObjectFactory();
	
	private GameEngine gameEngine = GameEngine.getGameEngine();
	
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
			
			// group player-ball together as part of the game play
			List<PlayerBalls> playerBalls = new ArrayList<>();
			
			// single thread of playing
			for(int i = 1; i < inputLines.size(); i++) {
				String[] line = inputLines.get(i).split(" ");
				
				int playerNumber = Integer.parseInt(line[0]);
				int ballNumber = Integer.parseInt(line[1]);
				
				// player already setup - just find that player
				Player player = gameEngine.getPlayer(playerNumber);
				if(player == null) {
					//throw new RuntimeException("Unknown player");
					continue;
				}
				
				// delay validation of ball number until during game play
				// TODO: might change this logic later
				Ball ball = (Ball) factory.getObject(GameObjectType.BALL);
				ball.setNumber(ballNumber);
				
				PlayerBalls playerBall = new PlayerBalls();
				playerBall.setPlayer(player);
				playerBall.setBall(ball);
				
				playerBalls.add(playerBall);
				
			}
			
			gameModel.setPlayersBalls(playerBalls);
			
			executor.shutdown();
		}
		
	}

}

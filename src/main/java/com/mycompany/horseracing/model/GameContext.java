/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

/**
 * @author colin
 *
 */
public final class GameContext implements GameState {

	private static final GameContext GAME_CONTEXT = new GameContext();
	
	private GameState gameState;
	
	private GameContext() {
		gameState = new UndefinedState();
	}
	
	public static GameContext getGameContext() {
		return GAME_CONTEXT;
	}
	
	public void setState(GameState newState) {
		gameState = newState;
		gameState.doAction();
	}
	
	public GameState getState() {
		return gameState;
	}
	
	public GameState getCurrentState() {
		return getState();
	}
	
	@Override
	public void doAction() {
		gameState.doAction();
	}

}

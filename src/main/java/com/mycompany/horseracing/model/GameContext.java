/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import com.mycompany.horseracing.model.state.GameState;
import com.mycompany.horseracing.model.state.UndefinedState;

/**
 * {@link GameContext} - the context of the game storing information about the
 * state of the game it is in
 * 
 * @author colin
 */
public final class GameContext implements GameState {

	private static final GameContext GAME_CONTEXT = new GameContext();
	
	private GameState gameState;
	
	/*
	 * There should only be 1 single instance of this
	 * class at all times - Singleton Design Pattern
	 */
	private GameContext() {
		gameState = new UndefinedState();
	}
	
	/**
	 * Returns the {@link GameContext} instance
	 * 
	 * @return the instance
	 */
	public static GameContext getGameContext() {
		return GAME_CONTEXT;
	}
			
	public GameState getState() {
		return gameState;
	}
	
	public void setState(GameState newState) {
		gameState = newState;
		gameState.doAction();
	}
	
	public GameState getCurrentState() {
		return getState();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAction() {
		gameState.doAction();
	}

}

/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.factory;

import com.mycompany.horseracing.model.state.FinishedState;
import com.mycompany.horseracing.model.state.GameState;
import com.mycompany.horseracing.model.state.NewState;
import com.mycompany.horseracing.model.state.PlayingState;
import com.mycompany.horseracing.model.state.ReadyState;
import com.mycompany.horseracing.model.state.StartedState;
import com.mycompany.horseracing.model.state.UndefinedState;

/**
 * {@link StateFactory} 
 * 
 * @author colin
 *
 */
public final class StateFactory extends GameFactory<StateType, GameState>{

	// eager initialization
	private static StateFactory factory = new StateFactory();
	
	private StateFactory() {}
	
	/**
	 * Singleton Design Pattern
	 * 
	 * @return factory
	 */
	public static StateFactory getFactory() {
		return factory;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public GameState getObject(StateType state, Object... args) {
		switch (state) {
		case NEW:
			return new NewState();
		case STARTED:
			return new StartedState();
		case READY:
			return new ReadyState();
		case PLAYING:
			return new PlayingState();
		case FINISHED:
			return new FinishedState();
		case UNDEFINED:
			return new UndefinedState();
		default:
			throw new RuntimeException();
		}
	}
}

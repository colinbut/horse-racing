/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.factory;

import com.mycompany.horseracing.domain.Ball;
import com.mycompany.horseracing.domain.GameObject;
import com.mycompany.horseracing.domain.GameObjectType;
import com.mycompany.horseracing.domain.Hole;
import com.mycompany.horseracing.domain.Horse;
import com.mycompany.horseracing.domain.Lane;
import com.mycompany.horseracing.domain.Player;
import com.mycompany.horseracing.domain.Race;
import com.mycompany.horseracing.domain.Track;

/**
 * {@link GameObjectFactory} factory class to create game objects
 * 
 * Simple Factory Design Pattern used
 * 
 * @author colin
 *
 */
public final class GameObjectFactory extends GameFactory<GameObjectType, GameObject>{

	// eager initialization
	private static GameObjectFactory factory = new GameObjectFactory();
	
	private GameObjectFactory() {}
	
	/**
	 * Singleton Design Pattern
	 * 
	 * @return factory
	 */
	public static GameObjectFactory gameObjectFactory() {
		return factory;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public GameObject getObject(GameObjectType gameObjectType, Object... args) {
		switch (gameObjectType) {
		case BALL:
			return new Ball();
		case HOLE:
			return new Hole();
		case HORSE:
			return new Horse();
		case LANE:
			return new Lane();
		case PLAYER:
			return new Player();
		case RACE:
			return new Race();
		case TRACK:
			return Track.getInstance();
		default:
			throw new RuntimeException();
		}
	}
}

/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

/**
 * {@link GameFactory} class
 * 
 * Simple Factory pattern
 * 
 * @author colin
 *
 */
public class GameFactory {

	public GameObject getGameObject(GameObjectType gameObjectType) {
		switch(gameObjectType) {
		case PLAYER: 
			return new Player(null);
		case HORSE:
			return new Horse();
		case LANE:
			return new Lane(0);
		case TRACK:
			return Track.getInstance();
		case HOLE:
			return new Hole(1);
			default: throw new IllegalArgumentException();
		}
	}
}

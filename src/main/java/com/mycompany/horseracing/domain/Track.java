/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.horseracing.factory.GameFactory;
import com.mycompany.horseracing.factory.GameObjectFactory;

/**
 * {@link Track} - represents the race track
 * 
 * @author colin
 *
 */
public class Track implements GameObject {

	public static final int LENGTH = 220; // 1 furlong is 220 yards
	
	private static Track INSTANCE = null;
	
	private List<Lane> lanes;
	
	private GameFactory<GameObjectType, GameObject> factory = GameObjectFactory.gameObjectFactory();
	
	/* 
	 * Singleton Design Pattern
	 */
	private Track() {
		lanes = new ArrayList<>();
		
		for(int i = 1; i <= 7; i++) {
			Lane lane = (Lane) factory.getObject(GameObjectType.LANE);
			lane.setLaneNumber(i);
			lanes.add(lane);
		}
		
	}
	
	/**
	 * Returns this Track instance - there can only be 1
	 * 
	 * @return the track instance
	 */
	public static Track getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Track();
		}
		return INSTANCE;
	}
	
	public List<Lane> getLanes() {
		return lanes;
	}
	
	/**
	 * Gets back the lane by the given lane number
	 * 
	 * @param laneNumber the number of the lane
	 * @return the lane, or null if not found
	 */
	public Lane getLane(int laneNumber) {
		for(Lane lane : lanes) {
			if(lane.getLaneNumber() == laneNumber) {
				return lane;
			}
		}
		return null;
	}
	
	/**
	 * Enters a horse into the lane
	 * 
	 * @param horse the horse to enter
	 * @param laneNumber number of the lane to enter
	 */
	public void enterLane(Horse horse, int laneNumber) {
		lanes.stream().forEach(lane -> {
			if(lane.getLaneNumber() == laneNumber) {
				lane.setHorse(horse);	
			}
		});
	}
}

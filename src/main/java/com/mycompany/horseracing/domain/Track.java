/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.horseracing.model.GameObject;

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
	
	/* 
	 * Singleton Design Pattern
	 */
	private Track() {
		lanes = new ArrayList<>();
		lanes.add(new Lane(1));
		lanes.add(new Lane(2));
		lanes.add(new Lane(3));
		lanes.add(new Lane(4));
		lanes.add(new Lane(5));
		lanes.add(new Lane(6));
		lanes.add(new Lane(7));
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

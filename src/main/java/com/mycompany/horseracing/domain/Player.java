/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import org.apache.log4j.Logger;

import com.mycompany.horseracing.model.GameObject;

/**
 * {@link Player} class
 * 
 * @author colin
 *
 */
public class Player implements GameObject {

	final Logger logger = Logger.getLogger(getClass()); 
	
	private String name;
	private Horse horse;
	private Lane lane;
	
	public Player(Horse horse) {
		setHorse(horse);
	}
	
	public void tossBall(int yardsToMove) {
		Hole hole = lane.findHoleByNumber(yardsToMove);
		if(hole != null) {
			logger.info(horse + " advancing " + yardsToMove + " yards");
			horse.advance(yardsToMove);
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public Lane getLane() {
		return lane;
	}

	public void setLane(Lane lane) {
		this.lane = lane;
	}
}

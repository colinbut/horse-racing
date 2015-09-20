/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import org.apache.log4j.Logger;

/**
 * {@link Player} - the game player
 * 
 * @author colin
 *
 */
public class Player implements GameObject {

	final Logger logger = Logger.getLogger(getClass()); 
	
	private String name;
	private Horse horse;
	private Lane lane;
		
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
	
	/**
	 * A player tosses the ball into a hole with a number indicating
	 * how much the horse must advance
	 * 
	 * @param yardsToMove number of yards to move forward
	 */
	public void tossBall(Ball ball) {
		Hole hole = lane.findHoleByNumber(ball.getNumber());
		if(hole != null) {
			int yardsToMove = ball.getNumber();
			logger.info(horse + " advancing " + yardsToMove + " yards");
			horse.advance(yardsToMove);
		}
		
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", horse=" + horse + ", lane=" + lane + "]";
	}

}

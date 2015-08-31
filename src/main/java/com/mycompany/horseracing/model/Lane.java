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
public class Lane {

	private int laneNumber;
	private Horse horse;

	/**
	 * @param laneNumber
	 */
	public Lane(int laneNumber) {
		super();
		this.laneNumber = laneNumber;
	}

	public int getLaneNumber() {
		return laneNumber;
	}

	public void setLaneNumber(int laneNumber) {
		this.laneNumber = laneNumber;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}
	
	
}

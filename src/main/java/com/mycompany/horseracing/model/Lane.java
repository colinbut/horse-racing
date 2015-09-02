/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Lane} class
 * 
 * @author colin
 *
 */
public class Lane implements GameObject {

	private int laneNumber;
	private Horse horse;
	private List<Hole> holes;

	

	/**
	 * @param laneNumber
	 */
	public Lane(int laneNumber) {
		super();
		this.laneNumber = laneNumber;
		holes = new ArrayList<>(11);
		
		// holes - 5, 5, 5, 5, 10, 10, 10, 20, 20, 40, 60
		
		holes.add(new Hole(5));
		holes.add(new Hole(5));
		holes.add(new Hole(5));
		holes.add(new Hole(5));
		holes.add(new Hole(10));
		holes.add(new Hole(10));
		holes.add(new Hole(10));
		holes.add(new Hole(20));
		holes.add(new Hole(20));
		holes.add(new Hole(40));
		holes.add(new Hole(60));
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
	
	public List<Hole> getHoles() {
		return holes;
	}

	public void setHoles(List<Hole> holes) {
		this.holes = holes;
	}
	
	public Hole findHoleByNumber(int number) {
		Hole holeFound = null;
		for(Hole hole : holes) {
			if(hole.getNumber() == number) {
				holeFound = hole;
			}
		}
		return holeFound;
	}
	
	
}

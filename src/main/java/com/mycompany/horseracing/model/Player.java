/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

/**
 * {@link Player} class
 * 
 * @author colin
 *
 */
public class Player {

	private String name;
	private Horse horse;
	
	public Player(Horse horse) {
		setHorse(horse);
	}
	
	public void tossBall(int yardsToMove) {
		horse.setYardsMoved(yardsToMove);
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
}
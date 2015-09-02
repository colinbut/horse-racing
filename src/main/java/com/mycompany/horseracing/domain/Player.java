/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import com.mycompany.horseracing.model.GameObject;

/**
 * {@link Player} class
 * 
 * @author colin
 *
 */
public class Player implements GameObject {

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

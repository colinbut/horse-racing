/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author colin
 *
 */
public class Race implements GameObject, Observer {

	private List<Horse> horses;
	private Track raceTrack;
	
	public static final int NUMBER_OF_HORSES = 7;
	
	public Race() {
		raceTrack = Track.getInstance();
		horses = new ArrayList<>(NUMBER_OF_HORSES);
	}
	
	public void addHorse(Horse horse) {
		horse.addObserver(this);
		horses.add(horse);
	}
	
	public int getNumberOfHorses() {
		return horses.size();
	}

	public Track getRaceTrack() {
		return raceTrack;
	}
	
	public void enterLane() {
		for(int i = 0; i < horses.size(); i++) {
			raceTrack.enterLane(horses.get(i), i);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Horse) {
			Horse horse = (Horse) o;
		} else {
			throw new IllegalArgumentException("Incorrect type observed - something went wrong");
		}
		
	}
}

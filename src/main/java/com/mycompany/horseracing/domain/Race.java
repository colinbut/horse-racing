/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import com.mycompany.horseracing.model.GameObject;
import com.mycompany.horseracing.model.PlayerBallsMapPair;

/**
 * @author colin
 *
 */
public class Race implements GameObject, Observer {

	final Logger logger = Logger.getLogger(getClass()); 
	
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
	
	public void race(List<PlayerBallsMapPair> playerBallsMap) {
		logger.info("racing started");
		for(PlayerBallsMapPair pair : playerBallsMap) {
			
			int horseLaneNumber = pair.getPlayerNumber();
			
			Horse horse = findHorseById(horseLaneNumber);
			if(horse == null) {
				logger.warn("can't find horse " + horseLaneNumber);
				continue; //skip this iteration as there's no horse registered with this number
			}
			
			int yardToMove = pair.getBallNumber();
			
			Lane lane = raceTrack.getLane(horseLaneNumber);
			
			if(lane != null) {
				
				Hole hole = lane.findHoleByNumber(yardToMove);
				
				if(hole != null) {
					logger.info(horse + " advancing " + yardToMove + " yards");
					horse.advance(yardToMove);
				}
				
			}
			
			
		}
		
		logger.info("racing finished");
	}
	
	private Horse findHorseById(int horseNumber) {
		for(Horse horse : horses) {
			if(horse.getHorseNumber() == horseNumber) {
				return horse;
			}
		}
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Horse) {
			Horse horse = (Horse) o;
			logger.info(horse + " won the race! ");
		} else {
			throw new IllegalArgumentException("Incorrect type observed - something went wrong");
		}
		
	}
}

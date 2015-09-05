/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.mycompany.horseracing.model.GameContext;
import com.mycompany.horseracing.model.GameObject;
import com.mycompany.horseracing.model.PlayerBallsMapPair;
import com.mycompany.horseracing.model.state.FinishedState;
import com.mycompany.horseracing.model.state.PlayingState;


/**
 * {@link Race} class
 * 
 * @author colin
 *
 */
public class Race extends Observable implements GameObject, Observer {

	final Logger logger = Logger.getLogger(getClass()); 
	
	private List<Horse> horses;
	private Track raceTrack;
	private SortedMap<Integer, Horse> raceResults;
	private GameContext gameContext = GameContext.getGameContext();
	
	
	public static final int NUMBER_OF_HORSES = 7;
	
	public Race() {
		raceTrack = Track.getInstance();
		horses = new ArrayList<>(NUMBER_OF_HORSES);
		raceResults = new TreeMap<>(Collections.reverseOrder());
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
	
	public void race(List<PlayerBallsMapPair> playerBallsMap, List<Player> players) {
		logger.info("racing started");
		
		gameContext.setState(new PlayingState());
		
		for(PlayerBallsMapPair pair : playerBallsMap) {
			
			if(gameContext.getCurrentState() instanceof FinishedState) {
				logger.info("racing stopped");
				break;
			}
			
			int horseLaneNumber = pair.getPlayerNumber();
			
			Horse horse = findHorseById(horseLaneNumber);
			if(horse == null) {
				logger.warn("can't find horse " + horseLaneNumber);
				continue; //skip this iteration as there's no horse registered with this number
			}
			
			// get the player
			Player player = null;
			for(Player p : players) {
				if(p.getHorse() == horse) {
					player = p;
					break;
				}
			}
			
			Lane lane = raceTrack.getLane(horseLaneNumber);
			
			if(lane != null) {
				
				int yardToMove = pair.getBallNumber();
				if(player.getLane() == null) {
					player.setLane(lane);
				}
				player.tossBall(yardToMove);
				
			}
			
		}
		
		logger.info("racing finished");
		
		for(Horse horse : horses) {
			raceResults.put(horse.getYardsMoved(), horse);
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	private Horse findHorseById(int horseNumber) {
		for(Horse horse : horses) {
			if(horse.getHorseNumber() == horseNumber) {
				return horse;
			}
		}
		return null;
	}

	public SortedMap<Integer, Horse> getRaceResults() {
		return raceResults;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Horse) {
			Horse horse = (Horse) o;
			logger.info(horse + " won the race! ");
			
			gameContext.setState(new FinishedState());
			
		} else {
			throw new IllegalArgumentException("Incorrect type observed - something went wrong");
		}
		
	}
}

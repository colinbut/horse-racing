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
import com.mycompany.horseracing.model.PlayerBalls;
import com.mycompany.horseracing.model.state.FinishedState;
import com.mycompany.horseracing.model.state.PlayingState;


/**
 * {@link Race} - the race
 * 
 * @author colin
 *
 */
public class Race extends Observable implements GameObject, Observer {

	public static final int NUMBER_OF_HORSES = 7;
	
	final Logger logger = Logger.getLogger(getClass()); 
	
	private List<Horse> horses;
	private Track raceTrack;
	private SortedMap<Integer, Horse> raceResults;
	private GameContext gameContext = GameContext.getGameContext();
	
	/**
	 * Constructor
	 */
	public Race() {
		raceTrack = Track.getInstance();
		horses = new ArrayList<>(NUMBER_OF_HORSES);
		raceResults = new TreeMap<>(Collections.reverseOrder());
	}
	
	public Track getRaceTrack() {
		return raceTrack;
	}
	
	public void addHorse(Horse horse) {
		horse.addObserver(this);
		horses.add(horse);
	}
	
	public int getNumberOfHorses() {
		return horses.size();
	}
	
	public void enterLane() {
		for(int i = 0; i < horses.size(); i++) {
			raceTrack.enterLane(horses.get(i), i);
		}
	}
	
	public void race(List<PlayerBalls> playerBallsMap, List<Player> players) {
		logger.info("racing started");
		
		gameContext.setState(new PlayingState());
		
		for(PlayerBalls pair : playerBallsMap) {
			
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
			Player player = findPlayer(players, horse);
			if(player != null) {
				
				Lane lane = raceTrack.getLane(horseLaneNumber);
				
				if(lane != null) {
					
					int yardToMove = pair.getBallNumber();
					if(player.getLane() == null) {
						player.setLane(lane);
					}
					
					Ball ball = new Ball();
					ball.setNumber(yardToMove);
					player.tossBall(ball);
					
				}
				
			}
			
		}
		
		finishRace();
		
	}
	
	private void finishRace() {
		logger.info("racing finished");
		
		for(Horse horse : horses) {
			raceResults.put(horse.getYardsMoved(), horse);
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	private Player findPlayer(List<Player> players, Horse horse) {
		for(Player player : players) {
			if(player.getHorse() == horse) {
				return player;
			}
		}
		return null;
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

	@Override
	public String toString() {
		return "Race [horses=" + horses + ", raceTrack=" + raceTrack + ", raceResults=" + raceResults + ", gameContext="
				+ gameContext + "]";
	}
	
}

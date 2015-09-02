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

import org.apache.log4j.Logger;

import com.mycompany.horseracing.domain.Horse;
import com.mycompany.horseracing.domain.Player;
import com.mycompany.horseracing.domain.Race;

/**
 * @author colin
 *
 */
public class GameEngine implements Observer {

	final Logger logger = Logger.getLogger(getClass()); 
	
	private List<Player> players;
	private Race race;
	private GameModel gameModel;
	
	public GameEngine() {
		setPlayers(new ArrayList<>());
		race = new Race();
		gameModel = GameModel.getInstance();
		gameModel.addObserver(this);
	}
	
	private void gameSetup() {
		logger.info("initialising game");
		
		// set up horses
		for(int i = 0; i < gameModel.getHorsesNames().length; i++) {
			//logger.info(gameModel.getHorsesNames().length);
			Horse horse = new Horse();
			horse.setName(gameModel.getHorsesNames()[i]);
			horse.setHorseNumber(i + 1);
			race.addHorse(horse);
		}
		
		logger.info("finished setting game up");
		playGame();
	}

	public void playGame() {
		logger.info("playing the game");
		
		race.race(gameModel.getPlayersBallsMap());
		
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public void update(Observable o, Object arg) {
		gameSetup();
	}
	
	
}

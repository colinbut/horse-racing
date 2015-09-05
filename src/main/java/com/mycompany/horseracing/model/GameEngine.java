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
import com.mycompany.horseracing.io.ConsoleOutputWriter;
import com.mycompany.horseracing.io.OutputWriter;
import com.mycompany.horseracing.model.state.NewState;
import com.mycompany.horseracing.model.state.ReadyState;
import com.mycompany.horseracing.model.state.StartedState;
import com.mycompany.horseracing.model.state.UndefinedState;

/**
 * {@link GameEngine} class
 * 
 * @author colin
 *
 */
public class GameEngine implements Observer {

	final Logger logger = Logger.getLogger(getClass()); 
	
	private List<Player> players;
	private Race race;
	private GameModel gameModel;
	
	private GameContext gameContext = GameContext.getGameContext();
	
	/**
	 * Constructor
	 */
	public GameEngine() {
		setPlayers(new ArrayList<>());
		race = new Race();
		gameModel = GameModel.getInstance();
		gameModel.addObserver(this);
		race.addObserver(this);
	}
	
	private void gameSetup() {
		logger.info("initialising game");
		
		if(gameContext.getCurrentState() instanceof UndefinedState) {
			logger.info("Initialising game state to 'NEW'");
			gameContext.setState(new NewState());
		} else {
			logger.error("Game state not in Undefined state");
			throw new RuntimeException();
		}
		
		// set up horses
		for(int i = 0; i < gameModel.getHorsesNames().length; i++) {
			Horse horse = new Horse();
			horse.setName(gameModel.getHorsesNames()[i]);
			horse.setHorseNumber(i + 1);
			race.addHorse(horse);
			
			Player player = new Player(horse);
			players.add(player);
		}
		
		logger.info("finished setting game up");
		gameContext.setState(new ReadyState());
		playGame();
	}

	public void playGame() {
		logger.info("playing the game");
		gameContext.setState(new StartedState());
		race.race(gameModel.getPlayersBallsMap(), players);
		
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(o instanceof Race) {
			OutputWriter consoleOutputWriter = new ConsoleOutputWriter();
			consoleOutputWriter.writeOutput(ResultsOutputFormat.raceResultsFormat(race.getRaceResults()));
		} else {
			gameSetup();
		}
	}
	
	
}

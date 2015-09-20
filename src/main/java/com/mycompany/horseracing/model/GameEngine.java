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

import com.mycompany.horseracing.domain.GameObject;
import com.mycompany.horseracing.domain.GameObjectType;
import com.mycompany.horseracing.domain.Horse;
import com.mycompany.horseracing.domain.Player;
import com.mycompany.horseracing.domain.Race;
import com.mycompany.horseracing.factory.GameFactory;
import com.mycompany.horseracing.factory.GameObjectFactory;
import com.mycompany.horseracing.factory.InputReaderFactory;
import com.mycompany.horseracing.factory.OutputWriterFactory;
import com.mycompany.horseracing.factory.StateFactory;
import com.mycompany.horseracing.io.InputReader;
import com.mycompany.horseracing.io.OutputWriter;
import com.mycompany.horseracing.io.ReaderType;
import com.mycompany.horseracing.io.WriterType;
import com.mycompany.horseracing.model.state.GameState;
import com.mycompany.horseracing.model.state.StateType;
import com.mycompany.horseracing.model.state.UndefinedState;

/**
 * {@link GameEngine} class
 * 
 * @author colin
 *
 */
public final class GameEngine implements Observer {

	final Logger logger = Logger.getLogger(getClass()); 
	
	private List<Player> players;
	private Race race;
	private GameModel gameModel;
	
	private GameContext gameContext = GameContext.getGameContext();
	private GameFactory<GameObjectType, GameObject> gameObjectFactory = GameObjectFactory.gameObjectFactory();
	private GameFactory<StateType, GameState> stateFactory = StateFactory.getFactory();
	private GameFactory<WriterType, OutputWriter> outputWriterFactory = OutputWriterFactory.getFactory();
	private GameFactory<ReaderType, InputReader> inputReaderFactory = InputReaderFactory.getFactory();
	
	private static GameEngine INSTANCE = null;
	
	public static GameEngine getGameEngine() {
		if(INSTANCE == null) {
			INSTANCE = new GameEngine();
		}
		return INSTANCE;
	}
	
	/**
	 * Constructor
	 */
	private GameEngine() {
		setPlayers(new ArrayList<>());
		race = (Race) gameObjectFactory.getObject(GameObjectType.RACE);
		gameModel = GameModel.getInstance();
		race.addObserver(this);
		gameModel.addObserver(this);
	}
		
	private void gameSetup() {
		logger.info("initialising game");
		
		initialiseGameState();
		
		// set up horses
		if(gameModel.getHorsesNames() != null) {
			for(int i = 0; i < gameModel.getHorsesNames().length; i++) {
				Horse horse = (Horse) gameObjectFactory.getObject(GameObjectType.HORSE);
				horse.setName(gameModel.getHorsesNames()[i]);
				horse.setHorseNumber(i + 1);
				race.addHorse(horse);
				
				Player player = (Player) gameObjectFactory.getObject(GameObjectType.PLAYER);
				player.setHorse(horse);
				players.add(player);
			}
		}
		
		logger.info("finished setting game up");
		gameContext.setState(stateFactory.getObject(StateType.READY));
		startGame();
	}
	
	private void initialiseGameState() {
		if(gameContext.getCurrentState() instanceof UndefinedState) {
			logger.info("Initialising game state to 'NEW'");
			gameContext.setState(stateFactory.getObject(StateType.NEW));
		} else {
			logger.error("Game state not in Undefined state");
			throw new RuntimeException();
		}
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public void startGame() {
		logger.info("starting the game");
		gameContext.setState(stateFactory.getObject(StateType.STARTED));
		gameModel.setHorsesReady(true);
	}
	
	public void playGame() {
		logger.info("playing the game");
		race.race(gameModel.getPlayersBalls(), players);
	}
	
	public void printResults() {
		OutputWriter consoleOutputWriter = outputWriterFactory.getObject(WriterType.CONSOLE);
		consoleOutputWriter.writeOutput(ResultsOutputFormat.raceResultsFormat(race.getRaceResults()));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Race) {
			printResults();
		} else if(o instanceof GameModel) {
			if(arg instanceof List<?>) {
				playGame();
			} else {
				gameSetup();
			}
		}
	}

	@Override
	public String toString() {
		return "GameEngine [players=" + players + ", race=" + race + ", gameModel=" + gameModel + "]";
	}
	
}

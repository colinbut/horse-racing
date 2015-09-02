/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

/**
 * @author colin
 *
 */
public class PlayerBallsMapPair {

	private Integer playerNumber;
	private Integer ballNumber;
	
	/**
	 * @param playerNumber
	 * @param ballNumber
	 */
	public PlayerBallsMapPair(Integer playerNumber, Integer ballNumber) {
		super();
		this.playerNumber = playerNumber;
		this.ballNumber = ballNumber;
	}

	public Integer getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(Integer playerNumber) {
		this.playerNumber = playerNumber;
	}

	public Integer getBallNumber() {
		return ballNumber;
	}

	public void setBallNumber(Integer ballNumber) {
		this.ballNumber = ballNumber;
	}

	@Override
	public String toString() {
		return "PlayerBallsMapPair [playerNumber=" + playerNumber + ", ballNumber=" + ballNumber + "]";
	}
	
	
	
}

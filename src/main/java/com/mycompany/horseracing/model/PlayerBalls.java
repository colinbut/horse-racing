/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

/**
 * {@link PlayerBalls} - Player number - Ball number
 * @author colin
 *
 */
public class PlayerBalls {

	private Integer playerNumber;
	private Integer ballNumber;
	
	/**
	 * Constructor
	 * 
	 * @param playerNumber
	 * @param ballNumber
	 */
	public PlayerBalls(Integer playerNumber, Integer ballNumber) {
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
		return "PlayerBalls [playerNumber=" + playerNumber + ", ballNumber=" + ballNumber + "]";
	}
	
}

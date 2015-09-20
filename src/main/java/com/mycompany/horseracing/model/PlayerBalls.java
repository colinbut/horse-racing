/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import com.mycompany.horseracing.domain.Ball;
import com.mycompany.horseracing.domain.Player;

/**
 * {@link PlayerBalls} - Player - Ball
 * @author colin
 *
 */
public class PlayerBalls {

	private Player player;
	private Ball ball;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	@Override
	public String toString() {
		return "PlayerBalls [player=" + player + ", ball=" + ball + "]";
	}
	
}

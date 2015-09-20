/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

/**
 * {@link Ball} - the ball a player throws into a hole
 * 
 * @author colin
 *
 */
public class Ball implements GameObject, Cloneable {

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public Ball clone() throws CloneNotSupportedException {
		return (Ball) super.clone();
	}

	@Override
	public String toString() {
		return "Ball [number=" + number + "]";
	}

}

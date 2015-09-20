/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

/**
 * {@link Hole} class
 *  
 * @author colin
 *
 */
public class Hole implements GameObject, Cloneable {

	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Hole [number=" + number + "]";
	}
	
	@Override
	public Hole clone() throws CloneNotSupportedException {
		return (Hole) super.clone();
	}
		
}
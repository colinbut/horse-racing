/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import com.mycompany.horseracing.model.GameObject;

/**
 * {@link Hole} class
 *  
 * @author colin
 *
 */
public class Hole implements GameObject {

	private int number;

	/**
	 * Constructor
	 * 
	 * @param number the number this hole presents
	 */
	public Hole(int number) {
		this.number = number;
	}
	
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
		
}
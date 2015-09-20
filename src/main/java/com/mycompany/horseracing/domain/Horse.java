/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import java.util.Observable;

/**
 * {@link Horse} - represents a Horse
 * 
 * @author colin
 *
 */
public class Horse extends Observable implements GameObject {

	private int horseNumber;
	private String name;
	private int yardsMoved;
	
	public int getHorseNumber() {
		return horseNumber;
	}

	public void setHorseNumber(int horseNumber) {
		this.horseNumber = horseNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getYardsMoved() {
		return yardsMoved;
	}
	
	public void advance(int yardsToMove) {
		yardsMoved += yardsToMove;
		if(yardsMoved >= Track.LENGTH) {
			crossingTheFinishLine();
		}
	}
	
	private void crossingTheFinishLine() {
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public String toString() {
		return "Horse [horseNumber=" + horseNumber + ", name=" + name + ", yardsMoved=" + yardsMoved + "]";
	}
	
}

/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.Observable;

/**
 * {@link Horse} class
 * 
 * @author colin
 *
 */
public class Horse extends Observable implements GameObject {

	private String name;
	private int yardsMoved;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getYardsMoved() {
		return yardsMoved;
	}
	
	public void setYardsMoved(int yardsMoved) {
		this.yardsMoved = yardsMoved;
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
	
}

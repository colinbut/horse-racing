/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.domain;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.horseracing.factory.GameFactory;
import com.mycompany.horseracing.factory.GameObjectFactory;

/**
 * {@link Lane} class
 * 
 * @author colin
 *
 */
public class Lane implements GameObject {

	private static final int NUMBER_OF_HOLES = 11;
	
	private int laneNumber;
	private Horse horse;
	private List<Hole> holes;
	
	private GameFactory<GameObjectType, GameObject> factory = GameObjectFactory.gameObjectFactory();

	/**
	 * Constructor
	 * 
	 * @param laneNumber
	 */
	public Lane() {
		holes = new ArrayList<>(NUMBER_OF_HOLES);
		
		// holes - 5, 5, 5, 5, 10, 10, 10, 20, 20, 40, 60
		initHoles();
	}
	
	private void initHoles() {
				
		Hole hole5 = (Hole) factory.getObject(GameObjectType.HOLE);
		hole5.setNumber(5);
		holes.add(hole5);
		
		try {
			holes.add(hole5.clone());
			holes.add(hole5.clone());
			holes.add(hole5.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		Hole hole10 = (Hole) factory.getObject(GameObjectType.HOLE);
		hole10.setNumber(10);
		holes.add(hole10);
		try {
			holes.add(hole10.clone());
			holes.add(hole10.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		Hole hole20 = (Hole) factory.getObject(GameObjectType.HOLE);
		hole20.setNumber(20);
		holes.add(hole20);
		try {
			holes.add(hole20.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		Hole hole40 = (Hole) factory.getObject(GameObjectType.HOLE);
		hole40.setNumber(40);
		holes.add(hole40);
		
		Hole hole60 = (Hole) factory.getObject(GameObjectType.HOLE);
		hole60.setNumber(60);
		holes.add(hole60);
	}

	public int getLaneNumber() {
		return laneNumber;
	}

	public void setLaneNumber(int laneNumber) {
		this.laneNumber = laneNumber;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}
	
	public List<Hole> getHoles() {
		return holes;
	}

	public void setHoles(List<Hole> holes) {
		this.holes = holes;
	}
	
	public Hole findHoleByNumber(int number) {
		Hole holeFound = null;
		for(Hole hole : holes) {
			if(hole.getNumber() == number) {
				holeFound = hole;
			}
		}
		return holeFound;
	}

	@Override
	public String toString() {
		return "Lane [laneNumber=" + laneNumber + ", horse=" + horse + ", holes=" + holes + "]";
	}
	
}

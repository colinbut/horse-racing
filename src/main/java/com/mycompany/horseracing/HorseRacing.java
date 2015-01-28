/**
 * 
 */
package com.mycompany.horseracing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * Class that does the horse racing
 * 
 * @author colin
 *
 */
public class HorseRacing implements IHorseRacing{

	/** 1 FURLONG is 220 yards */
	public static final int DISTANCE = 220; 
	
	private List<Horse> horses = null;
	private SortedMap<Integer, Horse> results = null;
	
	
	/**
	 * Constructor
	 */
	public HorseRacing(){
		
		horses = new ArrayList<>();
		
		results = new TreeMap<>(Collections.reverseOrder());

	}
	
	/**
	 * Gets the list of horses
	 * 
	 * @return horses list of horses
	 */
	public List<Horse> getHorses(){
		return horses;
	}
	
	/**
	 * Returns the race results
	 * 
	 * @return results race results
	 */
	public SortedMap<Integer, Horse> getResults(){
		return results;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.horseracing.IHorseRacing#startRace(java.util.List)
	 */
	@Override
	public void startRace(List<Horse> horses){
		this.horses = horses;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.horseracing.IHorseRacing#race(int, int)
	 */
	@Override
	public void race(int lane, int yards){
		
		for(int i = 0; i < horses.size(); i++){
			
			Horse horse = horses.get(i);
			
			if(lane == horse.getLane()){
				horse.advance(yards);
			}
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.horseracing.IHorseRacing#finishRace()
	 */
	@Override
	public void finishRace(){
		
		for(Horse horse : horses){
			results.put(horse.getYardsAdvanced(), horse);
		}
		
	}
	
	
}

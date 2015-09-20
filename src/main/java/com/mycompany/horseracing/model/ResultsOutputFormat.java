/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.Map;
import java.util.SortedMap;

import com.mycompany.horseracing.domain.Horse;

/**
 * {@link ResultsOutputFormat} class - represents the output format to be printed
 * 
 * @author colin
 *
 */
public final class ResultsOutputFormat {

	private static final String RESULTS_HEADER = "Position, Lane, Horse name";
	
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	/**
	 * Returns the race results in a format
	 * 
	 * @param results the results map
	 * @return race result in string 
	 */
	public static String raceResultsFormat(SortedMap<Integer, Horse> results) {
		StringBuilder sb = new StringBuilder();
		sb.append(RESULTS_HEADER);
		sb.append(NEW_LINE_SEPARATOR);
		
		int position = 1;
		for(Map.Entry<Integer, Horse> result : results.entrySet()){
			
			sb.append(position + ", " + result.getValue().getHorseNumber() + ", " +
							result.getValue().getName() + NEW_LINE_SEPARATOR);
			
			position++;
		}
		return sb.toString();
	}
	
}

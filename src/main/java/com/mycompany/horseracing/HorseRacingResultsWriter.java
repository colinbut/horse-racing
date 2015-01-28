/**
 * 
 */
package com.mycompany.horseracing;

import java.util.Map;
import java.util.SortedMap;

/**
 * Utility class to print out the race result in format:
 * 
 * Position, Lane, Horse name
 * [Position], [Lane Number], [Name of Horse]
 * 
 * @author colin
 *
 */
public class HorseRacingResultsWriter {

	private static final String RESULTS_HEADER = "Position, Lane, Horse name";
	
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	/**
	 * Prints out the race results
	 * 
	 * @param results the results map
	 * @return race result in string 
	 */
	public static String printOutRaceResults(SortedMap<Integer, Horse> results){
		
		StringBuilder sb = new StringBuilder();
		sb.append(RESULTS_HEADER);
		sb.append(NEW_LINE_SEPARATOR);
		
		int position = 1;
		for(Map.Entry<Integer, Horse> result : results.entrySet()){
			
			sb.append(position + ", " + result.getValue().getLane() + ", " +
							result.getValue().getName() + NEW_LINE_SEPARATOR);
			
			position++;
		}
		
		System.out.println(sb.toString());
		
		return sb.toString();
				
	}
}

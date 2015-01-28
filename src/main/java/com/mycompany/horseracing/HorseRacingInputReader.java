package com.mycompany.horseracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class to read in the input data
 * 
 * @author colin
 *
 */
public class HorseRacingInputReader {

	private static final String NEW_LINE_SEPARATOR = "\n";
	
	/**
	 * Reads in the multi line input data and puts it in a list stripping out all
	 * new lines
	 * 
	 * @param input the raw input
	 * @return list of all lines
	 */
	public static List<String> readInput(String input){
		
		String[] inputLines = input.split(NEW_LINE_SEPARATOR);
		
		return new ArrayList<>(Arrays.asList(inputLines));
		
	}
	
}

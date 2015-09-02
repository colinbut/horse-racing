/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.io;

import java.util.List;

/**
 * An action to take on the input data
 * 
 * Execute Around pattern
 * 
 * 
 * @author colin
 *
 */
public interface InputAction {

	/**
	 * Action to take when reading a file
	 * 
	 * @param inputLines
	 */
	void action(List<String> inputLines);
}

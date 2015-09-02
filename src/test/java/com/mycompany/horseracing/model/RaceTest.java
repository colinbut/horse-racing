/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

/**
 * @author colin
 *
 */
public class RaceTest {

	private Race race = new Race();
	
	public void testAddHorse() {
		race.addHorse(new Horse());
	}
}

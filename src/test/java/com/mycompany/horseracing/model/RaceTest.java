/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mycompany.horseracing.domain.Horse;
import com.mycompany.horseracing.domain.Race;

/**
 * @author colin
 *
 */
public class RaceTest {

	@Mock
	List<Horse> horses;
	
	@InjectMocks
	private Race race = new Race();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddHorse() {
		Horse horse = new Horse();
		race.addHorse(horse);
		Mockito.verify(horses, Mockito.times(1)).add(horse);
	}
}

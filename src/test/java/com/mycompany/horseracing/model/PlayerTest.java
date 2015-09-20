/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mycompany.horseracing.domain.Ball;
import com.mycompany.horseracing.domain.Horse;
import com.mycompany.horseracing.domain.Player;

/**
 * @author colin
 *
 */
public class PlayerTest {

	@Mock
	private Horse horse;
	
	@InjectMocks
	private Player player = new Player();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testTossBall() {
		Ball ball = new Ball();
		ball.setNumber(10);
		player.tossBall(ball);
		//Mockito.verify(horse, Mockito.times(1)).setYardsMoved(10);
	}
}

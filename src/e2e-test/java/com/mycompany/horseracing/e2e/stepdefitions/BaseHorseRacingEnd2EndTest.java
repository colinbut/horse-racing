/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.e2e.stepdefitions;

import cucumber.api.java.en.Given;
import static org.junit.Assert.*;

import com.mycompany.horseracing.domain.Player;
import com.mycompany.horseracing.domain.Race;
import com.mycompany.horseracing.domain.Track;
import com.mycompany.horseracing.model.GameEngine;

/**
 * {@link BaseHorseRacingEnd2EndTest} test class
 * 
 * @author colin
 *
 */
public class BaseHorseRacingEnd2EndTest {

	private Race race = new Race();
	private Track track = race.getRaceTrack();
	private GameEngine game = GameEngine.getGameEngine();
	
	@Given("^the track length is (\\d+) yards # (\\d+) furlong$")
	public void the_track_length_is_yards_furlong(int trackLength, int furlongLength) throws Throwable {
	    assertEquals(Track.LENGTH, trackLength);
	}

	@Given("^there are a maximum of (\\d+) horses playing$")
	public void there_are_a_maximum_of_horses_playing(int numberOfHorses) throws Throwable {
	    assertEquals(numberOfHorses, Race.NUMBER_OF_HORSES);
	}

	@Given("^the track has (\\d+) lanes in it \\(numbered lanes (\\d+) to (\\d+)\\)$")
	public void the_track_has_lanes_in_it_numbered_lanes_to(int numberOfLanes, int lowestLaneNumber, int highestLaneNumber) throws Throwable {
	    assertEquals(numberOfLanes, track.getLanes().size());
	}

	@Given("^each horse has a name$")
	public void each_horse_has_a_name() throws Throwable {
	    for(Player player : game.getPlayers()) {
	    	assertNotNull(player.getName());
	    }
	}

	@Given("^each horse will be in one lane$")
	public void each_horse_will_be_in_one_lane() throws Throwable {
	    // make sure horse 1 is on lane 1 etc...
	}
}

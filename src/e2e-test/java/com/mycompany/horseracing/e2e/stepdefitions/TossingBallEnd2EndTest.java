/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.e2e.stepdefitions;

import org.junit.experimental.categories.Category;

import com.mycompany.horseracing.e2e.End2EndCategory;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * {@link TossingBallEnd2EndTest} test class
 * 
 * @author colin
 *
 */
@Category(End2EndCategory.class)
public class TossingBallEnd2EndTest {

	@Given("^there are (\\d+) holes for each lane$")
	public void there_are_holes_for_each_lane(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^each hole has a number # this is the number of the yards the horse will move$")
	public void each_hole_has_a_number_this_is_the_number_of_the_yards_the_horse_will_move() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the numbers in the holes are the following: (\\d+), (\\d+), (\\d+), (\\d+), (\\d+), (\\d+), (\\d+), (\\d+), (\\d+), (\\d+), (\\d+)$")
	public void the_numbers_in_the_holes_are_the_following(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^a virtual player tosses a ball to a set of holes$")
	public void a_virtual_player_tosses_a_ball_to_a_set_of_holes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the horse belonging to the virtual player advances by the number of yards indicated by the hole number$")
	public void the_horse_belonging_to_the_virtual_player_advances_by_the_number_of_yards_indicated_by_the_hole_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}

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
 * {@link RacingEnd2EndTest} test class
 * 
 * @author colin
 *
 */
@Category(End2EndCategory.class)
public class RacingEnd2EndTest {

	@Given("^we have read the input$")
	public void we_have_read_the_input() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^each virtual player indicated by the input\\.\\.\\.$")
	public void each_virtual_player_indicated_by_the_input() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^each virtual player is tossing the balls$")
	public void each_virtual_player_is_tossing_the_balls() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the winner will be the first horse to reach the goal \\(i\\.e\\. first horse to get (\\d+) furlong\\)$")
	public void the_winner_will_be_the_first_horse_to_reach_the_goal_i_e_first_horse_to_get_furlong(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the race ends here$")
	public void the_race_ends_here() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the positions of other horses will be frozen despite more balls are thrown$")
	public void the_positions_of_other_horses_will_be_frozen_despite_more_balls_are_thrown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}

/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.horseracing.e2e;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * {@link E2EBDDTestRunConfiguration} class
 * 
 * @author colin
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/e2e-test/resources/")
public class E2EBDDTestRunConfiguration {
}

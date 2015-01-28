package com.mycompany.horseracing;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class KentuckyDerbyTestSuite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(KentuckyDerbyTestSuite.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(HorseRacingInputReaderTest.class);
		suite.addTestSuite(HorseRacingResultsWriterTest.class);
		suite.addTestSuite(HorseRacingTest.class);
		suite.addTestSuite(HorseTest.class);
		suite.addTestSuite(GamePlayTest.class);
		
		//$JUnit-END$
		return suite;
	}

}

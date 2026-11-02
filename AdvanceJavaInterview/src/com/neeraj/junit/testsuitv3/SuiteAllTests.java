package com.neeraj.junit.testsuitv3;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class SuiteAllTests {

	public static void main(String[] args) {

		TestSuite sui = new TestSuite();

		sui.addTestSuite(SuiteTest1.class);
		sui.addTestSuite(SuiteTest2.class);

		TestRunner.run(sui);
	}
	
	/*
	 * TestSuite ka use multiple test classes ko ek saath execute karne ke liye hota
	 * hai.
	 * 
	 * 
	 * 
	 * addTestSuite() method se hum test classes ko suite mein add karte hain.
	 * 
	 * 
	 * 
	 * TestRunner.run() method poore test suite ko execute karta hai.
	 * 
	 * 
	 * 
	 * Isse humein har test class ko separately run nahi karna padta.
	 */

}
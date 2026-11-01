package com.neeraj.junit.testsuitv4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.neeraj.junit.testsuitv3.SuiteTest1;
import com.neeraj.junit.testsuitv3.SuiteTest2;

@RunWith(Suite.class)
@Suite.SuiteClasses({ SuiteTest1.class, SuiteTest2.class })
public class SuitsAllClasses {
//empty

	/*
	 * @RunWith(Suite.class) JUnit ko Suite Runner use karne ke liye kehta hai.
	 * 
	 * 
	 * 
	 * @Suite.SuiteClasses mein multiple test classes specify karte hain.
	 * 
	 * 
	 * 
	 * JUnit un sabhi classes ke test methods execute karta hai.
	 * 
	 * 
	 * 
	 * Isse multiple test classes ko ek saath run kar sakte hain.
	 */
}
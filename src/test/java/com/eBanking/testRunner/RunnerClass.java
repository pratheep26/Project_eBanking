package com.eBanking.testRunner;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RunnerClass {

	public static void main(String[] args) {
		
		TestNG runnerTestNG=new TestNG();
		
		List<String> suites=new ArrayList<String>();
		
		suites.add("TestNG.xml");
		
		runnerTestNG.setTestSuites(suites);
		
		runnerTestNG.run();

	}

}

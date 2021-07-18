package com.eBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.eBanking.pageObjects.LoginPageObjects;

public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException 
	{
		test=report.createTest("Login Test");
		test.log(Status.INFO, "Navigating to an Applicaation");
		
		logger.info("Login Test begins");
		logger.info("Navigating to an Applicaation");

		LoginPageObjects loginObjects=new LoginPageObjects(driver);
		loginObjects.setUserName(username);
		
		test.log(Status.INFO, "Entered Username");
		
		logger.info("Entered Username");
		
		loginObjects.setPassword(password);
		
		test.log(Status.INFO, "Entered Password");
		
		logger.info("Entered Password");

		loginObjects.clickSubmit();
		
		test.log(Status.INFO, "Logging into the Homepage");
		test.log(Status.INFO, "Verifying the Title");
		
		logger.info("Logging into the Homepage");
		logger.info("Verifying tht Title");
		
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Guru99 Bank Manager HomePage"));

		/*
		 * if(driver.getTitle().equals("Guru99 Bank Manage HomePage")) {
		 * Assert.assertTrue(true); } else { Assert.assertTrue(false); }
		 */
		
		test.log(Status.INFO, "End of TC_LoginTest_001");
		
		logger.info("End of TC_LoginTest_001");

	}

}

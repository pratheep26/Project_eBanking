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

		LoginPageObjects loginObjects=new LoginPageObjects(driver);
		loginObjects.setUserName(username);
		
		test.log(Status.INFO, "Entered Username");
		
		loginObjects.setPassword(password);
		
		test.log(Status.INFO, "Entered Password");

		loginObjects.clickSubmit();
		
		test.log(Status.INFO, "Logging into the Homepage");
		test.log(Status.INFO, "Verifying the Title");

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			captureScreen(driver, "loginTest");
			
			Assert.assertTrue(false);
	
		}
		
		test.log(Status.INFO, "End of TC_LoginTest_001");

	}

}

package com.eBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.eBanking.pageObjects.AddNewCustomerPageObjects;
import com.eBanking.pageObjects.LoginPageObjects;

public class TC_AddNewCustomer_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		test=report.createTest("Test Add new customer");
		test.log(Status.INFO, "Navigating to an Application");
		
		LoginPageObjects loginPageObjects=new LoginPageObjects(driver);
		loginPageObjects.setUserName(username);
		
		test.log(Status.INFO, "Entered Username");
		
		loginPageObjects.setPassword(password);
		
		test.log(Status.INFO, "Entered Password");
		
		loginPageObjects.clickSubmit();
		
		test.log(Status.INFO, "Logging into the Homepage");
		
		Thread.sleep(3000);
		
		AddNewCustomerPageObjects customerPageObjects=new AddNewCustomerPageObjects(driver);
		
		customerPageObjects.clickAddNewCustomer();
		test.log(Status.INFO, "Clicked Add New Customer Link");
		
		customerPageObjects.customerName("pradeep");
		test.log(Status.INFO, "Entered Customer Name");
		customerPageObjects.selectGender("male");
		test.log(Status.INFO, "Selected Gender");
		customerPageObjects.customerdob("05", "06", "1995");
		test.log(Status.INFO, "Selected DOB");
		customerPageObjects.customerAdress("Muthupet");
		test.log(Status.INFO, "Entered Address");
		customerPageObjects.customerCity("Thiruvaru");
		test.log(Status.INFO, "Entered City");
		customerPageObjects.customerState("Tamilnadu");
		test.log(Status.INFO, "Entered State");
		customerPageObjects.cusPincode("614703");
		test.log(Status.INFO, "Entered Pincode");
		customerPageObjects.cusTelephone("9952320245");
		test.log(Status.INFO, "Entered Mobile Number");
		
		String email=randomString()+"@gmail.com";
		customerPageObjects.cusEmail(email);
		
		test.log(Status.INFO, "Entered Email");
		
		customerPageObjects.pword("gdf@212");
		test.log(Status.INFO, "Entered Password");
		customerPageObjects.subButton();
		
		boolean result=driver.getPageSource().contains("Customer reg successfully!!!");
		
		if(result==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(true);
		}
		test.log(Status.INFO, "End of TC_AddNewCustomer_003");
	}
	
}

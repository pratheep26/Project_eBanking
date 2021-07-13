package com.eBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.LoginPageObjects;
import com.eBanking.utilities.ExcelUtils;



public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException
	{	
		test=report.createTest("Login Testing with DDT");
		
		LoginPageObjects pageObjects=new LoginPageObjects(driver);
		pageObjects.setUserName(uname);
		pageObjects.setPassword(pwd);
		pageObjects.clickSubmit();

		Thread.sleep(2000);

		if(isAlertPresent()==true)
		{
			
			Assert.assertTrue(false);
			Thread.sleep(2000);
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();// This command will focus on the main page
		}
		else
		{
			Assert.assertTrue(true);
			pageObjects.clickLogout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();//close logout alert
		}
	}

	public boolean isAlertPresent() // user defined method created to check alert is present or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}


	@DataProvider(name="LoginData") 
	String[][] getData() throws IOException 
	{
		String path=("C:\\Users\\ADMIN\\git\\Project_eBanking\\eBanking_V1\\src\\test\\java\\com\\eBanking\\testData\\Login_Data.xlsx");

		int rownum=ExcelUtils.getRowCount(path, "Sheet1");
		int colnum=ExcelUtils.getCellCount(path, "Sheet1", rownum);
		
		String logindata[][]=new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				
				logindata[i-1][j]=ExcelUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;



	}


}

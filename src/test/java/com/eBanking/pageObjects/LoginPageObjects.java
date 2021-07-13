package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	WebDriver ldriver;
	 
	//Constructor
	
	public LoginPageObjects(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtusername;
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtpassword;
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement loginbtn;
	@FindBy(xpath = "//a[text()='Log out']")
	@CacheLookup
	WebElement logoutLink;
	
	//Action methods
	
	public void setUserName(String uname)
	{
		txtusername.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickSubmit() 
	{
		loginbtn.click();
	}
	
	public void clickLogout()
	{
		logoutLink.click();
	}

}

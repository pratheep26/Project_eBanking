package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPageObjects {

	WebDriver ldriver;

	public AddNewCustomerPageObjects(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how=How.XPATH, using = "//a[text()='New Customer']")
	@CacheLookup
	WebElement AddNewCustomerLink;
	@FindBy(name = "name")
	@CacheLookup
	WebElement txtCustomerName;
	@FindBy(name = "rad1")
	@CacheLookup
	WebElement rdGender;
	@FindBy(id = "dob")
	@CacheLookup
	WebElement dob;
	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtAddress;
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtCity;
	@FindBy(name = "state")
	@CacheLookup
	WebElement txtState;
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtPin;
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txtMobile;
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtEmail;
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	@FindBy(name = "sub")
	@CacheLookup
	WebElement submitLink;


public void clickAddNewCustomer()
{
	AddNewCustomerLink.click();
}
public void customerName(String cname)
{
	txtCustomerName.sendKeys(cname);
}
public void selectGender(String cgender)
{
	rdGender.click();
}
public void customerdob(String dd, String mm, String yyyy)
{
	dob.sendKeys(dd);
	dob.sendKeys(mm);
	dob.sendKeys(yyyy);
}
public void customerAdress(String cadd)
{
	txtAddress.sendKeys(cadd);
}
public void customerCity(String ccity)
{
	txtCity.sendKeys(ccity);
}
public void customerState(String cstate)
{
	txtState.sendKeys(cstate);
}
public void cusPincode(String cpin)
{
	txtPin.sendKeys(String.valueOf(cpin));
}
public void cusTelephone(String cphone)
{
	txtMobile.sendKeys(cphone);
}
public void cusEmail(String cemail)
{
	txtEmail.sendKeys(cemail);
}
public void pword(String pwd)
{
	password.sendKeys(pwd);
}
public void subButton()
{
	submitLink.click();
}






























}
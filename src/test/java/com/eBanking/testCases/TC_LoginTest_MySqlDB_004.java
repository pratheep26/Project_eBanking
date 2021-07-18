package com.eBanking.testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.LoginPageObjects;


public class TC_LoginTest_MySqlDB_004 extends BaseClass{


	@Test(dataProvider = "LoginData")
	public void validateLogin(String uname, String pword) throws InterruptedException
	{

		LoginPageObjects pageObjects=new LoginPageObjects(driver);
		pageObjects.setUserName(uname);
		pageObjects.setPassword(pword);
		pageObjects.clickSubmit();
		
		Thread.sleep(2000);
		
	}

	@DataProvider(name = "LoginData")
	public String[][] loginDataInDB() throws ClassNotFoundException, SQLException
	{
		String data[][]=getDBValues();
		return data;
	}


	public String[][] getDBValues() throws ClassNotFoundException, SQLException
	{

		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_data", "root", "MySql");

		Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

		ResultSet resultSet=statement.executeQuery("select * from test_data.ebanking_login_data");


		resultSet.last();

		int row=resultSet.getRow();


		ResultSetMetaData metaData=resultSet.getMetaData();
		int column=metaData.getColumnCount();


		String data[][]=new String[row][column];

		int i=0;
		resultSet.beforeFirst();
		while(resultSet.next())
		{
			for(int j=0;j<column;j++)
			{
				data[i][j]=resultSet.getString(j+1);
			}
			i++;
		}
		return data;
	}


}

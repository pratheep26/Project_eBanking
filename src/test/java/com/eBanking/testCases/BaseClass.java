package com.eBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.eBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig=new ReadConfig();

	public static WebDriver driver;
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.setUsername();
	public String password=readConfig.getPassword();


	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;

	@Parameters("browser")
	@BeforeClass
	public void setup(String chromeBrowser) 
	{


		//System.setProperty ("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		if(chromeBrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty ("webdriver.chrome.driver", readConfig.getChrompath());
			driver=new ChromeDriver();
		}
		else if(chromeBrowser.equalsIgnoreCase("firefox"))
		{
			System.setProperty ("webdriver.gecko.driver", readConfig.getFirefoxpath());
			driver=new FirefoxDriver();	
		}
		else if(chromeBrowser.equalsIgnoreCase("ie"))
		{
			System.setProperty ("webdriver.ie.driver", readConfig.getIEpath());
			driver=new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

	@BeforeSuite
	public void extentReportSetUp()
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());//Time stamp
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);//Specify location

		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}


		report=new ExtentReports();
		report.attachReporter(htmlReporter);

		report.setSystemInfo("Project_Name", "eBanking");
		report.setSystemInfo("User", "pradeep");
		report.setSystemInfo("Host name", "localhost");
		report.setSystemInfo("Environment", "QA");

		htmlReporter.config().setDocumentTitle("eBanking Test Project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

	}
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail(MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass(MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.GREEN));
		}
		else
		{
			test.skip(MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.INDIGO));
			test.skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void onFinal()
	{
		report.flush();
	}
	public void captureScreen(WebDriver driver, String TC_Name) throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File(TC_Name +".png");
		FileHandler.copy(sourceFile, destinationFile);
		test.addScreenCaptureFromPath(TC_Name +".png");
		System.out.println("Screenshot Taken");
	}

	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	public static String randomNum()
	{
		String generatedString2=RandomStringUtils.randomNumeric(5);
		return generatedString2;
	}
}

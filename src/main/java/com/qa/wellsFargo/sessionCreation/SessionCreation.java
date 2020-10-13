package com.qa.wellsFargo.sessionCreation;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.qa.wellsFargo.Base.Base;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SessionCreation extends Base {

	public static Logger log = Logger.getLogger(SessionCreation.class);
	public ExtentReports extent;
	public ExtentTest extentTest;

	// how can i add screenshot in extent report how to do that .

	// creating extent report
	@BeforeTest
	public void setExtent() {
		// first add avantstack reports dependency but doesn't work but why??
		// add relevant report dependency then work properly but how & why?

		extent = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\ExtendReports.html", true);
		extent.addSystemInfo("Host Name", "Shakel");
		extent.addSystemInfo("Enviorment", "Wells Fargo Automation");
		extent.addSystemInfo("User Name", "S A");

	}

// launching browser then open the url 
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Chrome launching ");
		
		driver.manage().window().maximize();
		
		// how can I use explicit wait concept in here
		
		// driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(implicitywait, TimeUnit.SECONDS);

		driver.get(getPro("url"));
		log.info(" Homepage open ");

	}

	@DataProvider(name = "TestData")
	public void testDataRead() {

	}

	// browser quit after execution
	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.quit();

	}

	@AfterTest
	public void endReport() {
		// writing the documents
		// flush() - to write or update test information in your report

		extent.flush();

		// Call close() at the very end of your session to clear all resources
		extent.close();
	}

}

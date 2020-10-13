package com.qa.wellsFargo.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.wellsFargo.Utils.ExcelReadData;
import com.qa.wellsFargo.sessionCreation.SessionCreation;

import junit.framework.Assert;

@Listeners(com.qa.wellsFargo.Utils.CapturedScreenShot.class)
public class TestCaseScripts extends SessionCreation {

	// one error comes after execute have to fixed
	// go to run configuration th

	@Test(priority = 1,groups = {"functional"}) // checking customersService is Display
	public void customerServiceDisplay() {
		boolean csd = driver.findElement(By.xpath("//a[contains(text(),'Customer Service')]")).isDisplayed();
		if (csd) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

	}

	@Test(priority = 2,groups = {"functional"}) // verified Personal module
	public void verifiedPersonalModule() {
		String actualText = driver.findElement(By.xpath("//a[@id='tabNavPersonal']")).getText();
		String expected = "Personal";
		// Assert.assertEquals(expected, actualText);
		Assert.assertEquals(expected, actualText);
	}

	@Test(priority = 3, groups = {"functional"}) // verified small business module
	public void verifiedSmallBusinessModule() {
		String smallBusText = driver.findElement(By.linkText("Small Business")).getText();
		String expect = "Small Business";
		Assert.assertEquals("Test Message ", expect, smallBusText);

	}

	@Test(priority = 4, groups = {"functional","smoke"}) // verified commercial module
	public void verifiedCommericalModule() {
		String commercText = driver.findElement(By.id("tabNavCommercial")).getText();
		String expect = "Commercial";
		Assert.assertEquals(expect, commercText);

	}

	@Test(priority = 5, groups = {"smoke"}) // verified financila module
	public void verifiedFinancialEduModule() {
		String resourcText = driver.findElement(By.linkText("Financial Education")).getText();
		String expect = "Financial Education";
		Assert.assertEquals(expect, resourcText);

	}

	@Test(priority = 6, groups = {"smoke"}) // verified about wells module
	public void verifiedAbutWellsModule() {
		String wellsFargoText = driver.findElement(By.xpath("//a[contains(text(),'About Wells Fargo')]")).getText();
		String expect = "About Wells Fargo";
		Assert.assertEquals(expect, wellsFargoText);

	}

	@Test(priority = 7, groups = {"smoke"}) // Personal link clickable
	public void verifiedPersonalClickAbleModule() {
		WebElement personalClick = driver.findElement(By.id("tabNavPersonal"));
		personalClick.click();
		System.out.println("Personal Loan is enable : " + personalClick.isEnabled());

	}

	@Test(priority = 8, groups = {"functional"}) // verified banking and credit feature
	public void verifiedBankingAndCreditFeature() {
		driver.findElement(By.name("tabNavPersonal")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("bankingTab"))).build().perform();

	
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Credit Cards")));
		
		
		//	driver.manage().timeouts().implicitlyWait(implicitywait, TimeUnit.SECONDS);

		// why had to use it here ??? how to resolve it in dynamic way

		driver.findElement(By.linkText("Credit Cards")).click();
		String creditText = driver.findElement(By.id("skip")).getText();
		String expect = "Credit Card";
		Assert.assertEquals(expect, creditText);

	}

	@Test(priority = 9, groups = {"smoke"}) // verified commercial clickable
	public boolean verifiedCommercialClickAble() {
		try {

			WebElement commercialElement = driver.findElement(By.linkText("Commercial"));
			commercialElement.click();
		} catch (StaleElementReferenceException elementReference) {
			return true;

		}
		return false;

	}

	@Test(priority = 10, groups = {"smoke"}) // verified Industry link
	public void verifiedIndustryExpertiseLink() {
		WebElement commercialLink = driver.findElement(By.linkText("Commercial"));
		commercialLink.click();
		WebElement industryExpertiseLink = driver.findElement(By.linkText("Industry Expertise"));
		industryExpertiseLink.click();
		System.out.println(" Industry Expertise link is enable : " + industryExpertiseLink.isEnabled());
	}

	@Test(priority = 11, groups = {"functional","smoke"})
	public void aboutWellsFargoHomepage() {
		WebElement aboutWellsFar = driver.findElement(By.linkText("About Wells Fargo"));
		aboutWellsFar.click();
		String aboutText = driver.findElement(By.id("skip")).getText();
		String expect = "about Wells Fargo";
		Assert.assertEquals(expect, aboutText);
	}

	@DataProvider // data comes from excel file by reading data from different package & class help of apache poi
	public Object[][] getData() {
		Object[][] data = ExcelReadData.getDataFromExcel("testData1");
		return data;

	}

	// read the userName and password from dataProvider
	@Test(dataProvider = "getData",groups = {"smoke"})
	public void logInTest(String username, String password) {

		driver.findElement(By.id("userid")).sendKeys(username);

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		WebElement signOnBtn = driver.findElement(By.xpath("//input[@id='btnSignon']"));
		if (signOnBtn.isDisplayed() == signOnBtn.isEnabled()) {
			signOnBtn.click();
		}
	}

	// why doesn't running in testNG suite while executing 
	
	// extent report with screenShot 
	
	
}

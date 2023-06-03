package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import org.testng.annotations.Parameters;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {

	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	AccountsPage accountsPage;
	SearchResultsPage searchResultsPage;
	ProductInfoPage productInfoPage;
	RegistrationPage registrationPage;
	SoftAssert softAssert;
	
	@Parameters({"browser","browserversion","testcasename"})
	@BeforeTest
	public void setUp(String browserName,String browserVersion,String testCaseName)
	{
		df = new DriverFactory();
		prop = df.inti_Prop();
		
		if(browserName!=null)
		{
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);
			prop.setProperty("testcasename", testCaseName);
		}
	
		driver = df.inti_Driver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}

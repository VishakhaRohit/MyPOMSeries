package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Design Open Cart App : Login Page")
@Story("Open Cart Login Page Design with multiple features...")
@Listeners(TestAllureListener.class)

public class LoginPageTest extends BaseTest{

	@Description("Login Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		Assert.assertTrue(loginPage.getLoginPageTitle());
	}
	
	@Description("Login Page Url Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void loginPageUrlTest()
	{
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}
	
	@Description("Login Page Register Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void registerLinkExistTest()
	{
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	@Description("Login Page Forgot Password Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4,enabled = false)
	public void forgotPswdLinkExistTest()
	{
		Assert.assertTrue(loginPage.isForgotPswdLinkExist());
	}
	
	@Description("Do Login Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 5)
	public void doLoginTest()
	{
		loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
	}

}

package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By accountsPageSection = By.cssSelector("div#content h2");
	private By searchField = By.name("search");
	private By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	private By logoutLink = By.linkText("Logout");
	
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccountPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isLogOutLinkExist()
	{
		return eleUtil.doIsDisplayed(logoutLink);
	}
	
	public void doLogOut()
	{
		if(isLogOutLinkExist())
		{
			eleUtil.doClick(searchButton);
		}
	}
	
	public boolean isSearchFieldExist()
	{
		return eleUtil.doIsDisplayed(searchField);
	}
	
	public List<String> getAccountsPageSection()
	{
		return eleUtil.getElementsTextListWithWait(accountsPageSection, Constants.DEFAULT_TIME_OUT);
	}
	
	public SearchResultsPage doSearch(String productName)
	{
		System.out.println("Product Name : " + productName);
		
		eleUtil.doClear(searchField);
		eleUtil.doSendKeys(searchField, productName,Constants.DEFAULT_TIME_OUT);
		eleUtil.doClick(searchButton,Constants.DEFAULT_TIME_OUT);
		return new SearchResultsPage(driver);
	}
}

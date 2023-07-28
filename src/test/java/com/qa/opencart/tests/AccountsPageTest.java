package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;

public class AccountsPageTest extends BaseTest{

	@BeforeClass
	public void accSetUp()
	{
		accountsPage = loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void getAccountPageTitleTest()
	{
		String actTitle = accountsPage.getAccountPageTitle();
		System.out.println("Act title : " + actTitle);
		Assert.assertEquals(actTitle,Constants.ACCOUNT_PAGE_TITLE,Errors.ACCOUNT_PAGE_TITLE_NOT_FOUND_ERROR_MSG);
	}
	
	@Test(priority = 2)
	public void getSearchFieldExistTest()
	{
		Assert.assertTrue(accountsPage.isSearchFieldExist());
	}
	
	@Test(priority = 3)
	public void isLogOutLinkExistTest()
	{
		Assert.assertTrue(accountsPage.isLogOutLinkExist());
	}
	
	@Test(priority = 4)
	public void getAccountsSectionListTest()
	{
		List<String> accountSecTextList = accountsPage.getAccountsPageSection();
		Assert.assertEquals(accountSecTextList, Constants.accountSecList());
	}
	
	@DataProvider
	public Object[][] productData()
	{
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	
	@Test(priority = 5,dataProvider = "productData")
	public void doSearchTest(String productName)
	{
		searchResultsPage = accountsPage.doSearch(productName);
		Assert.assertTrue(searchResultsPage.getProductListCount()>0);

	}
	
	@DataProvider
	public Object[][] productSelectData()
	{
		return new Object[][] {
			{"macbook","MacBook"},
			{"iMac","iMac"},
			{"Samsung","Samsung SyncMaster 941BW"}
		};
	}
	
	@Test(priority=6,dataProvider = "productSelectData")
	public void selectProductTest(String productName,String mainProductName)
	{
		searchResultsPage = accountsPage.doSearch(productName);
		productInfoPage = searchResultsPage.selectProduct(mainProductName);
		Assert.assertEquals(productInfoPage.getProductHeader(),mainProductName);
	}
	
}

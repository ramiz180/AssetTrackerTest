package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AssetPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****** Startign TC_002_LoginTest *****");
		
		try
		{
		// Perform login		
		// Verify login success
		AssetPage assetPageObj=new AssetPage(driver);
		boolean targetPage=assetPageObj.isAccountLoggedMessageDisplayed();
		Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login failed");
		logger.info("****** TC_002_LoginTest case PASSED*****");
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.info(e+"****** TC_002_LoginTest case FAILED*****");
		}
		logger.info("****** Finished TC_002_LoginTest *****");
	}
	
}

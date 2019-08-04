package com.TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestUtil.TestUtil;

public class LoginPageTest extends TestBase {
	
	
	LoginPage loginpage;
	
	public LoginPageTest() {
		
		
		super();
	}
	
	@BeforeMethod
	
	public void SetUp() {
		logger.info("Opening Browser");
		initil();
		loginpage = new LoginPage();
		TestUtil.captureScreenShot(driver, "Login Page");
		
	}
	
	@Test(priority = 3)
	
	public void VerifyLoginPage() {
		logger.info("Verifying login");
		
		loginpage.VerifyLogin(prop.getProperty("UserName"), prop.getProperty("Password"));
		TestUtil.captureScreenShot(driver, "Login Page");
	}
	
	
	
	@Test(priority = 0)
	public void VerifyLogoofThePage() {
		logger.info("Verifying Logo of the Company");
		boolean logo = loginpage.verifyLogo();
		Assert.assertTrue(logo);
		
	}
	@Test(priority = 1)
	public void VerifyTitleofThePage() {
		logger.info("Verifying Title of Page");
		String title =loginpage.VerifyTitle();
		Assert.assertEquals(title, "Login - TechFios Test Application - Billing");
	}
	@Test(priority = 2)
	public void VerifyErrorMessageWithinvaliduspw() throws Exception {
		loginpage.ErrorMessage(prop.getProperty("invalidUser"), prop.getProperty("invalidPassword"));
		Thread.sleep(5000);
		boolean er= loginpage.VerifyError();
		Assert.assertTrue(er);
		System.out.println("The Error Message" +er);
	}
	@Test(priority = 4)
	public void VerifyHomePage() {
		loginpage.VerifyLogin(prop.getProperty("UserName"), prop.getProperty("Password"));
		boolean dashboard =loginpage.VerifyHomePage();
		Assert.assertTrue(dashboard);
		TestUtil.captureScreenShot(driver, "Homepage");
	
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}

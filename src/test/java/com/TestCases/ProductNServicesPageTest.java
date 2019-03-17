package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestPages.ProductNServicesPage;
import com.TestUtil.TestUtil;

public class ProductNServicesPageTest extends TestBase {
	LoginPage loginpage;
	ProductNServicesPage productNServicesPage;
	
	
	String SheetName = "Info";
	
public ProductNServicesPageTest() {
		
		
		super();
	}

@BeforeMethod

public void SetUp() {
	
	initil();
	productNServicesPage = new ProductNServicesPage(); 
	loginpage = new LoginPage();
	
	loginpage.VerifyLogin(prop.getProperty("UserName"), prop.getProperty("Password"));
	
}
@DataProvider

public Object[][] moon(){
	
	Object [][] data = TestUtil.getTestData(SheetName);
	
	return data;
	
	
}

@Test(dataProvider="moon")
public void CreateNewOrder(String Name,String SalesPrice, String ItemNumber, String Description) throws Exception {
	Thread.sleep(5000);
	productNServicesPage.ProductNServises();
	Thread.sleep(5000);
	productNServicesPage.NewService();
	Thread.sleep(5000);
	productNServicesPage.NewOrder(Name, SalesPrice, Description, ItemNumber);
	
	Thread.sleep(5000);
	
	boolean Message = productNServicesPage.ValidateSuccessMessage();
	
	Assert.assertTrue(Message);
}
	
@AfterMethod
public void TearDown() {
	driver.quit();
}
}

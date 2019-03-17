package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class ProductNServicesPage extends TestBase{
	
	
	@FindBy(xpath="//input[@id=\"name\"]")
	WebElement TypeName;
	
	@FindBy(xpath="//input[@id=\"sales_price\"]")
	WebElement salesprice;
	
	@FindBy(xpath="//input[@id=\"item_number\"]")
	WebElement itemnumber;
	
	@FindBy(xpath="//textarea[@class=\"form-control\"]")
	WebElement Description;
	@FindBy(xpath="//span[text()='Products & Services']")
	WebElement ProductNService;
	@FindBy(xpath="//a[text()='New Service']")
	WebElement NewService;
	
	@FindBy(xpath="//button[@id=\"submit\"]")
	WebElement Submit;
	@FindBy(xpath="//*[@class=\"alert alert-success fade in\"]")
	WebElement SuccessMessage;
	
	public ProductNServicesPage() {
		PageFactory.initElements(driver, this);


}
	
	public void ProductNServises() {
		
		ProductNService.click();
	}
	public void NewService() {
		NewService.click();
		
	}
	public boolean ValidateSuccessMessage() {
		return SuccessMessage.isDisplayed();
	}
	
	public void NewOrder(String name, String SalesPrice, String description, String itemNumber) {
		
		TypeName.sendKeys(name);
		salesprice.sendKeys(SalesPrice);
		itemnumber.sendKeys(itemNumber);
		Description.sendKeys(description);
		
		Submit.click();
		
		
	}
}

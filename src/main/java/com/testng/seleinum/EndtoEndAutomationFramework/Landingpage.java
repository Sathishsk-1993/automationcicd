package com.testng.seleinum.EndtoEndAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponents;

public class Landingpage extends Abstractcomponents{
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	 
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	 
	
	public String geterrormessage() {
		webelementstoappear(errormessage);
		return errormessage.getText();
		
	}
public void gotourl() {
	
	driver.get("https://rahulshettyacademy.com/client/");
}

public Productcatalogue logintoapplication(String userName, String passWord) {
	
	username.sendKeys(userName);
	password.sendKeys(passWord);
	submit.click();
	
	Productcatalogue Productcatalogue = new Productcatalogue(driver);
	return Productcatalogue;
	
	
	
}


}

package com.testng.seleinum.EndtoEndAutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponents;

public class confirmationpage extends Abstractcomponents{
	
	WebDriver driver;
	
	public confirmationpage (WebDriver driver) {
		super (driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement text;
	 
	
	public String getconfirmationmessage() {
	return text.getText();	
	}
	
}

package com.testng.seleinum.EndtoEndAutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponents;

public class paymentpage extends Abstractcomponents {
	


	WebDriver driver;
	
	public paymentpage (WebDriver driver) {
		super (driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css="div[class*='subtotal']")
	WebElement checkoutpage;
	
	@FindBy(css="section[class*='list-group'] button:last-of-type")
	WebElement getcountrylist;

	@FindBy(css=".actions a")
	WebElement navigatetoconfirmation;
	
	By waitgetcountrylist = By.cssSelector(".ta-results");
	
	public void getcountryname(String countryName) {
	
	Actions a = new Actions(driver);
  a.sendKeys(country ,countryName).build().perform();
  waitforelementtobeappear(waitgetcountrylist);
  getcountrylist.click();
   
	}
	public confirmationpage clickconfiramtionpage() {
		navigatetoconfirmation.click();
		return new confirmationpage(driver);

}
}
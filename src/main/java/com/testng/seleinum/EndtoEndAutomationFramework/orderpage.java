package com.testng.seleinum.EndtoEndAutomationFramework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponents;

public class orderpage extends Abstractcomponents {
	WebDriver driver;
	public orderpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List <WebElement> orders;
	
	public boolean getcartproducts(String productname) {
		
		boolean cartproducts = orders.stream().anyMatch(cartprod ->cartprod.getText().equalsIgnoreCase(productname));
		return cartproducts;	
	}


}
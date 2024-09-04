package com.testng.seleinum.EndtoEndAutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponents.Abstractcomponents;

public class checkoutpage extends Abstractcomponents  {
	
	
		WebDriver driver;
		
		public checkoutpage(WebDriver driver) {
			super (driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css=".cartSection h3")
		List <WebElement> cartproduct;
		
		@FindBy(css="div[class*='subtotal'] button")
		WebElement checkoutpage;
//		
//	
		
	
		By productsby = By.cssSelector(".cartSection h3");
		
		
		public List<WebElement> getcartproductwait() {
			waitforelementtobeappear(productsby);
			return cartproduct;
		}
		
				
		public boolean getcartproducts(String productname) {
			
			boolean cartproducts = cartproduct.stream().anyMatch(cartprod ->cartprod.getText().equalsIgnoreCase(productname));
			return cartproducts;	
		}
		
		public paymentpage clickcheckoutpage() {
			checkoutpage.click();
			return new paymentpage (driver);
			
		}


		

}

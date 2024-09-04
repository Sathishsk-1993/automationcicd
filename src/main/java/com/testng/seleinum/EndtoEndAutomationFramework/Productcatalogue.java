package com.testng.seleinum.EndtoEndAutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponents.Abstractcomponents;

public class Productcatalogue extends Abstractcomponents  {
	
	
		WebDriver driver;
		
		public Productcatalogue(WebDriver driver) {
			super (driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css=".mb-3")
		List <WebElement> products;
		
//		List<WebElement> cartproduct = driver.findElements(By.cssSelector(".cartSection h3"));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".cartSection h3")));
//		boolean cartproducts= cartproduct.stream().anyMatch(cartprod ->cartprod.getText().equalsIgnoreCase(desiredproductname));
		

		
		By toastmessage = By.id("toast-container");
		By productsby = By.cssSelector(".mb-3");
		By addtocart = By.cssSelector(".card-body button:last-of-type");
		
		public List<WebElement> getproducts() 
		{
			waitforelementtobeappear(productsby);
			return products;
				
		}
		
		public WebElement getproductname(String productname) {
			
			WebElement prod= getproducts() .stream().filter(product-> 
			product.getText().contains(productname)).findFirst().orElse(null);
			return prod;
		}
		
		
		public void addproducttocart(String productname) {
			
		WebElement prod  = getproductname( productname);
				prod.findElement(addtocart).click();
				waitforelementtobeappear(toastmessage);
			
		}


		

}

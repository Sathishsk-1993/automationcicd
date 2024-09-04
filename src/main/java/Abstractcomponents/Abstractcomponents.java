package Abstractcomponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testng.seleinum.EndtoEndAutomationFramework.checkoutpage;
import com.testng.seleinum.EndtoEndAutomationFramework.orderpage;

public class Abstractcomponents {
	
	WebDriver driver;
	
	public Abstractcomponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css= "button[routerlink*='cart']")
	WebElement getcartpage;
	
	@FindBy (css= "button[routerlink*='myorders']")
	WebElement orderheader;
	
	
	
	
	public checkoutpage getcartpage() {
		getcartpage.click();
		checkoutpage checkoutpage = new checkoutpage(driver);
		return checkoutpage;
	}
	
	
		public orderpage gotoorderpage() {
			orderheader.click();
			orderpage orderpage = new orderpage(driver);
			return  orderpage;
		
	}
	
	
	public void waitforelementtobeappear(By findby) {
	
	WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
	}
	

	public void webelementstoappear(WebElement findby) {
	
	WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findby));
	}
	

}

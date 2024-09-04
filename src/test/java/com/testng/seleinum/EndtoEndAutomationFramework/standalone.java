package com.testng.seleinum.EndtoEndAutomationFramework;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standalone {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		
		String desiredproductname ="ZARA COAT 3";
		
		driver.findElement(By.id("userEmail")).sendKeys("sathishsk291993@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sathishsk@007");
		driver.findElement(By.id("login")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		List <WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod= products.stream().filter(product-> product.getText().contains(desiredproductname)).findFirst().orElse(null);
		System.out.println(prod);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("toast-container"))));
		
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		List<WebElement> cartproduct = driver.findElements(By.cssSelector(".cartSection h3"));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".cartSection h3")));
		boolean cartproducts= cartproduct.stream().anyMatch(cartprod ->cartprod.getText().equalsIgnoreCase(desiredproductname));
		
        Assert.assertTrue(cartproducts); 
        
        driver.findElement(By.cssSelector("div[class*='subtotal'] button")).click();
        Actions a = new Actions(driver);
       a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")) ,"india").build().perform();
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
        driver.findElement(By.cssSelector("section[class*='list-group'] button:last-of-type")).click();
        driver.findElement(By.cssSelector(".actions a")).click();
        
        String text= driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));
		
		

	}

}

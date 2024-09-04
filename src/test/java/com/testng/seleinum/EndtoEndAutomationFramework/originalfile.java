package com.testng.seleinum.EndtoEndAutomationFramework;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class originalfile extends baseclass {
	String productname ="ZARA COAT 3"; 


@Test(dataProvider = "getdata",groups = {"purchaseorder"})
	public void submittest(HashMap <String,String> input) throws IOException, InterruptedException {
	
		//Landingpage landingpage = launchapplication();
//test
		
		Productcatalogue Productcatalogue = landingpage.logintoapplication(input.get("email"), input.get("password"));
		
		List<WebElement> products = Productcatalogue.getproducts();
		Productcatalogue.addproducttocart(input.get("productname"));
		Thread.sleep(3000);
		checkoutpage checkoutpage = Productcatalogue.getcartpage();
		
		boolean cartproducts = checkoutpage.getcartproducts(input.get("productname"));
		Assert.assertTrue(cartproducts); 
		paymentpage paymentpage = checkoutpage.clickcheckoutpage();
		
		//paymentpage paymentpage = new paymentpage(driver);
		paymentpage.getcountryname("india");
	
		confirmationpage confirmationpage = paymentpage.clickconfiramtionpage();
		
       String confirmmessage = confirmationpage.getconfirmationmessage();
        Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));
		
		

	}
@Test(dependsOnMethods = {"submittest"})

public void gotoorderpage() {
	
	Productcatalogue  Productcatalogue = landingpage.logintoapplication("sathishsk291993@gmail.com", "Sathishsk@007"); 
	orderpage orderpage = Productcatalogue.gotoorderpage();
	Assert.assertTrue(orderpage.getcartproducts(productname));
	}
	


//@DataProvider
//public Object[][] getdata() {
//	
//	
//	return new Object [] [] {{"sathishsk291993@gmail.com","Sathishsk@007","ZARA COAT 3"},
//		{"sathishsk291993@gmail.com","Sathishsk@007","ADIDAS ORIGINAL"}};
//}

@DataProvider
public Object[][] getdata() throws IOException  {
	
	List <HashMap<String,String>> data =  getjsondata(System.getProperty("user.dir")+"//src//test//java//testdata//productorder.json");
	
	
	return new Object [] [] {{data.get(0)},{data.get(1)}};
}


//HashMap <String,String> map = new HashMap<String,String>();
//map.put("email", "sathishsk291993@gmail.com");
//map.put("password","Sathishsk@007");
//map.put("productname", "ZARA COAT 3");
//
//
//HashMap <Object,Object> map1 = new HashMap<Object,Object>();
//map1.put("email", "sathishsk291993@gmail.com");
//map1.put("password","Sathishsk@007");
//map1.put("productname", "ADIDAS ORIGINAL");




}

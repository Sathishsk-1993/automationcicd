package com.testng.seleinum.EndtoEndAutomationFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.baseclass;

public class errormessage extends baseclass {
	
	
@Test(groups= {"fullrun"})
	public void errormessagetest() throws IOException, InterruptedException {
		
		
		String desiredproductname ="ZARA COAT 3"; 
		
		//Landingpage landingpage = launchapplication();
		
		Productcatalogue Productcatalogue = landingpage.logintoapplication("sathishsk291993@gmail.com", "Sathishsk@0007");
		landingpage.geterrormessage();
		Assert.assertEquals("Incorrect email or password.", landingpage.geterrormessage());
		
		
		

	}

}

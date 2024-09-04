package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testng.seleinum.EndtoEndAutomationFramework.Landingpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	
	public WebDriver driver;
	public Landingpage landingpage;
	public WebDriver initilizedriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\Resources\\global.properties");
		prop.load(file);
		String browsername = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		
		//String browsername = prop.getProperty("browser");
		
		if (browsername.contains("chrome")) {
			ChromeOptions Options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browsername.contains("headless")) {
			
			Options.addArguments("headless");
		}
			 driver = new ChromeDriver(Options);
			 driver.manage().window().setSize(new  Dimension(1440,990));
			 
		}
		
		else if  (browsername.equalsIgnoreCase("firefox")) {			
//			System.setProperty("webdriver.gecko.driver","C://Users//cgvaklt271//Downloads//geckodriver-v0.35.0-win-aarch64//geckodriver.exe");
//					 driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
		}
	//driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  return driver;

	}
	
	public List<HashMap<String, String>> getjsondata(String Filepath) throws IOException {
		
		String jsoncontent = FileUtils.readFileToString(new File(Filepath),
				StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference <List<HashMap<String,String>>>(){
		});
		
		return data;
	}
	
	public String getscreenshotfunction(String TestCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot src = (TakesScreenshot) driver;
		File source = src.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+TestCaseName +".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+TestCaseName +".png";
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public Landingpage launchapplication() throws IOException {
		driver =initilizedriver();
		landingpage = new Landingpage(driver);
		landingpage.gotourl();
		return landingpage;
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void Teardown() {
		
		driver.close();
	}
}


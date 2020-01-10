package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

public class Base {
	
	public static WebDriver driver = null;
	
	 private static ThreadLocal<WebDriver> WEB_DRIVER = new ThreadLocal<WebDriver>() {
		    @Override
		    public WebDriver initialValue() {
		      try {
		        return initialize();
		      } catch (Throwable e) {
		        throw new RuntimeException(e);
		      }
		    }
		  };
	
	
	
	public Base(){
		 PageFactory.initElements(driver, this);
	}
	
	@BeforeTest
	public static WebDriver initialize() throws IOException{
	
	Properties prop = new Properties();
    FileInputStream ip = new FileInputStream("/Users/bnandira/Documents/Raju/bh_embi_linx/config.properties");
	prop.load(ip);
	System.out.println(prop.getProperty("browser"));
	String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome")){
		
		System.setProperty("webdriver.chrome.driver","C:\\ProgramData\\Chrome_driver_78.0.3904.70\\chromedriver.exe");	
	    // Object is created for ChromeOptions and assigned to the driver
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver=new ChromeDriver(options);	
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	else if(browserName.equals("FF")){
		
	}
	else if(browserName.equals("IE")){
		
	}
	else {
		System.out.println("No browser name value has been passed");
	}
	
//	return driver;
	
//	 Launching the application
	String applURL=prop.getProperty("appUrl");
	driver.get(applURL);
	return driver;
	}
//	return driver;
}

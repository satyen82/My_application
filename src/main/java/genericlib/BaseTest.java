package genericlib;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest implements AutoConstant{
	
	
	
	public static WebDriver driver;
	
	
	@BeforeTest
	public void openapp()
	{
	
	WebDriverManager.chromedriver().setup();	
//	System.setProperty(drive, location);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration. ofSeconds(10));
	}

	
	@AfterTest
	public void closeapp()
	{
	driver.quit();
	}


}

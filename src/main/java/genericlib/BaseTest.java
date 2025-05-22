package genericlib;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


public class BaseTest implements AutoConstant{
	
	
	
	public static WebDriver driver;
	@BeforeSuite
	public void openapp()
	{
	System.setProperty(drive, location);
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

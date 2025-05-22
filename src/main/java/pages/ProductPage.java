package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import genericlib.BaseTest;

public class ProductPage extends BaseTest {

	@FindBy(xpath = "//h3[.='Brands']")
	private WebElement bran;
	
	@FindBy(xpath = "//label[contains(.,'Rayban')]")
	private WebElement ray;
	
	@FindBy(xpath = "(//*[.='Unisex Aviator  UV protected lens Sunglasses'])[1]")
	private WebElement uv;
	
	@FindBy(xpath = "//h4[contains(.,'Download the app')]")
	private WebElement down;

	String au, tit;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void prod() {
		bran.click(); 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(ray));
		ray.click();
//		Point y = down.getLocation();
//		Reporter.log("Loction is: " + y, true);
//		Actions a = new Actions(driver);
//		a.scrollByAmount(0, 1344).perform();
		uv.click();
		Set <String>ss=driver.getWindowHandles();
		
		for (String s1:ss)
		{
			driver.switchTo().window(s1);
		}

		tit = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertEquals(tit, "Buy RAYBAN Unisex Aviator UV protected lens Sunglasses | Shoppers Stop");
		Reporter.log("Title is: " + tit, true);
		s.assertAll();
	}

}

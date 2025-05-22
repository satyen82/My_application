package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
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

public class ProductDetailsPage extends BaseTest {

	@FindBy(xpath = "//p[.='Add to bag']")
	private WebElement bag;
	
	@FindBy(xpath = "(//p[.='View Bag'])[last()]")
	private WebElement vbag;
	
	@FindBy(xpath = "//p[.='PLACE ORDER']")
	private WebElement ord;
	
	@FindBy(xpath = "//*[@alt='remove product']/../../../*/*[2]")
	private WebElement rem;
	
	

	String prod, tit;

	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void prodDetails() {
		bag.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(vbag)).click();
		wait.until(ExpectedConditions.visibilityOf(ord));
		tit = driver.getCurrentUrl();
		prod=rem.getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(tit, "https://www.shoppersstop.com/cart/bag");
		s.assertEquals(prod,"Unisex Aviator UV protected lens Sunglasses");
		Reporter.log("URL is: " + tit, true);
		Reporter.log("Product is: " + prod, true);
		s.assertAll();
	}

}

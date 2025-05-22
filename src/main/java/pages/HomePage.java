package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import genericlib.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(partialLinkText = "MEN")
	private WebElement me;

	@FindBy(xpath = "//*[.='Aviators']")
	private WebElement av;

	@FindBy(xpath = "//h1[.='Aviators']")
	private WebElement avhead;

	@FindBy(xpath = "//p[.='Login']")
	private WebElement log;
	
	@FindBy(xpath = "//*[@alt='cross']")
	private WebElement cls;
	

	String tit;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void homie() throws InterruptedException {
		
		driver.get("https://www.shoppersstop.com/");
		Actions a = new Actions(driver);
		a.moveToElement(me).perform(); 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(av));
		av.click();
		wait.until(ExpectedConditions.visibilityOf(avhead));
		a.moveToElement(avhead).perform(); 
		tit = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertEquals(tit, "Buy Aviator Sunglasses For Men Online & Get Up To 50% Off");
		Reporter.log("Title is: " + tit, true);
		s.assertAll();
	}

}

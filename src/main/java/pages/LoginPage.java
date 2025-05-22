package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import genericlib.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(id = "username")
	private WebElement sign;

	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(id = "submit")
	private WebElement sub;

	@FindBy(linkText = "Log out")
	private WebElement log;

	String au, tit;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String un, String pwd){
		driver.get("https://practicetestautomation.com/practice-test-login/");	
		sign.sendKeys(un);
		pass.sendKeys(pwd);
		sub.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(log));
		au = log.getText();
		tit = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertEquals(au, "Log out");
		s.assertEquals(tit, "Logged In Successfully | Practice Test Automation");
		Reporter.log("Title is: " + tit, true);
		s.assertAll();
	}

}

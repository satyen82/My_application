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

public class HeroPage extends BaseTest {

	@FindBy(xpath = "//button[.='Remove']")
	private WebElement rm;

	@FindBy(xpath = "//button[.='Add']")
	private WebElement add;

	@FindBy(id = "message")
	private WebElement gone;

	@FindBy(id = "checkbox")
	private WebElement cbox;


	public HeroPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void homie() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		  rm.click(); WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10)); 
		  wait.until(ExpectedConditions.invisibilityOf(cbox));
		  String gn =gone.getText(); 
		  SoftAssert s = new SoftAssert();
		  s.assertEquals(gn, "It's gone!"); Reporter.log(gn,true);
		  
		  add.click(); 
		  wait.until(ExpectedConditions.visibilityOf(cbox));
		  cbox.click();
		  String bk =gone.getText();
		  s.assertEquals(bk, "It's back!");
		  Reporter.log(bk,true); 
		  s.assertAll();
		 

	}

}

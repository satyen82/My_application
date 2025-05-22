package pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
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

public class CartPage extends BaseTest {

	@FindBy(xpath = "//p[.='PLACE ORDER']")
	private WebElement ord;
	
	@FindBy(id = "Enter your phone or email ID")
	private WebElement log;
	
	@FindBy(xpath = "//p[.='PROCEED']")
	private WebElement go;
	
	@FindBy(xpath = "(//*[contains(.,'OTP')])[last()]")
	private WebElement otp;
	
	String tit;

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void cart(String email) {
		ord.click(); 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(log)).sendKeys(email);
		go.click();
		wait.until(ExpectedConditions.visibilityOf(otp));
		Reporter.log(otp.getText(), true);
		
	}
	
	public Map<String, Integer> createAndReturnMap() {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("one", 1);
        myMap.put("two", 2);
        myMap.put("three", 3);
        return myMap;
    }

	public void map ()  {
        Map<String, Integer> returnedMap = createAndReturnMap();
        System.out.println(returnedMap); // Output: {one=1, two=2, three=3}
    }

}

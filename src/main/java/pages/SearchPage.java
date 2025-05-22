package pages;




import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import genericlib.BaseTest;

public class SearchPage extends BaseTest {

	@FindBy(name = "q")
	private WebElement src;
	
	@FindBy(xpath = "//*[contains(@role,'list')]//*[contains(@class,'sbct')]")
	private WebElement list1;

	@FindBys(@FindBy(xpath = "//*[contains(@role,'list')]//*[contains(@class,'sbct')]"))
	private List <WebElement> list;
	
	


	String tit;

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void src(String un) throws InterruptedException{
		driver.get("https://www.google.com/");
		src.sendKeys(un);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
		Reporter.log("List size is: "+list.size(), true);
		for(WebElement a:list)
		{
			Reporter.log(a.getText(), true);
		}
		
		tit = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertEquals(tit, "Google");
		Reporter.log("Title is: " + tit, true);
		s.assertAll();
	}

}

package scripts;




import org.testng.annotations.Test;
import org.testng.annotations.Test;
import genericlib.BaseTest;
import pages.HomePage;
import pages.LoginPage;


public class Home extends BaseTest{
	
	
@Test
	public static void home() throws InterruptedException { 	
	HomePage lp = new HomePage (driver);
	lp.homie();
	}

}

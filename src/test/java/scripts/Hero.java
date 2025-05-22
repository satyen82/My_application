package scripts;




import org.testng.annotations.Test;
import org.testng.annotations.Test;
import genericlib.BaseTest;
import pages.HeroPage;
import pages.HomePage;
import pages.LoginPage;


public class Hero extends BaseTest{
	
	
@Test
	public static void home() throws InterruptedException { 	
	HeroPage lp = new HeroPage (driver);
	lp.homie();
	}

}

package scripts;




import org.testng.annotations.Test;
import org.testng.annotations.Test;
import genericlib.BaseTest;
import pages.LoginPage;


public class Login extends BaseTest{
	
	
@Test
	public static void search() { 	
	LoginPage lp = new LoginPage (driver);
	lp.login("student","Password123");
	}

}

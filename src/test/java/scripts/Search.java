package scripts;


import org.testng.annotations.Test;
import genericlib.BaseTest;
import pages.SearchPage;


public class Search extends BaseTest{
	
	
@Test
	public static void prod() throws InterruptedException { 	
	SearchPage lp = new SearchPage (driver);
	lp.src("selenium");
	}

}

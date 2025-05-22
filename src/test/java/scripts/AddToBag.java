package scripts;




import org.testng.annotations.Test;
import org.testng.annotations.Test;
import genericlib.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductPage;


public class AddToBag extends BaseTest{
	
	
@Test
	public static void addToBag() throws InterruptedException { 	
	HomePage hp = new HomePage (driver);
	ProductPage lp = new ProductPage (driver);
	ProductDetailsPage dt = new ProductDetailsPage (driver);
	CartPage lc = new CartPage (driver);
	hp.homie();
	lp.prod();
	dt.prodDetails();
	lc.cart("abc@gmail.com");
	
	}

}

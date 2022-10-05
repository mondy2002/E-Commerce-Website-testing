package Tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import Pages.MobilePage;

public class MobilePageTest extends TestBase{
	MobilePage mobilep;
@Test
public void verify_that_tests_are_sorted() throws IOException
{
	mobilep =new MobilePage(driver);

	mobilep.sorted_mobiles();
	
	}
@Test
public void verify_sonyPrices_arethe_same() throws IOException
{
	mobilep =new MobilePage(driver);

	mobilep.sony_certain_price();
	}
@Test
public void verify_elements_limit() throws IOException
{
	mobilep =new MobilePage(driver);

	mobilep.order_many_items();
	}
@Test
public void verify_2products_compare() throws IOException, InterruptedException
{
	mobilep =new MobilePage(driver);

	mobilep.compare_2Products();
}

}

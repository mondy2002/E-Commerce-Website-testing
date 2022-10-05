package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.HomePage;
public class HomePageTest extends TestBase{
	
	

@Test
public void home_title_exists()
{
	HomePage homepage=new HomePage(driver);

	homepage.homepagetitle();
}
@Test
public void home_advanced_searh() throws InterruptedException
{
	HomePage homepage=new HomePage(driver);

	homepage.search_filter();
}

}

package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static  WebDriver driver ;

@BeforeTest
public void setup () 
{
	
	System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
	   
	  driver =new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://live.techpanda.org/index.php/");
	// driver.get("http://live.techpanda.org/index.php/backendlogin/index/index/key/422e1ed51e3ebffd321b4940991c2e44/");
	 driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
	}
@AfterTest
public void teardown ()
{
     driver.quit();	
}
}

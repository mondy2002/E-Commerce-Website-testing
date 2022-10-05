package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import Pages.MobilePage;
import Pages.MyAccountPage;

public class MyAccountTest extends TestBase {
MyAccountPage account;
@Test
public void share_list_with_email() throws IOException, InterruptedException
{
	
    account=new MyAccountPage(driver);
    account.share_wishlist();
	
}
@Test
public void verify_that_order_is_placed() throws InterruptedException 
    {
    	
        account=new MyAccountPage(driver);
        account.verify_purchase();
    	
    	
    	}
	
}

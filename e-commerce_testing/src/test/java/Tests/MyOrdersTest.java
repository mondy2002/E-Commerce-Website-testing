package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.MyAccountPage;
import Pages.MyOrdersPage;

public class MyOrdersTest  extends TestBase {
	MyOrdersPage order;
	@Test
	public void verify_that_orderpdf_is_saved() throws InterruptedException 
	    {
	    	
	        order=new MyOrdersPage(driver);
	        order.login();
	        order.verif_order_pdf();
	    	
	    	
	    	}
	@Test
	public void verify_that_order_isReplayed() throws InterruptedException 
	    {
	    	
	        order=new MyOrdersPage(driver);
	        order.login();
	        order.verify_reorder();
	    	
	    	
	    	}
	
	@Test
	public void verify_that_coupon_applied() throws InterruptedException, IOException 
	    {
	    	
	        order=new MyOrdersPage(driver);
	        
	        order.verify_discount();
	    	
	    	
	    	}	
		
}

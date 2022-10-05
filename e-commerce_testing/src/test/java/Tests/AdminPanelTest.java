package Tests;

import java.io.IOException;


import org.apache.commons.mail.EmailException;
import org.testng.annotations.Test;
import Pages.AdminPanelPage;
import Pages.MyOrdersPage;

public class AdminPanelTest extends TestBase {

	AdminPanelPage admin;
	//note that you have to change the link before you run this test
	@Test
	public void verify_that_excel_works() throws InterruptedException, IOException, EmailException 
	    {
	    	
	        admin=new AdminPanelPage(driver);
	        
	        admin.excel_test();
	    	
	    	
	    	}
	
	@Test
	public void verify_that_review_approved() throws InterruptedException, IOException, EmailException 
	    {
	    	
	        admin=new AdminPanelPage(driver);
	        
	        admin.review_approved();
	    	
	    	
	    	}
	
	@Test
	public void verify_that_invoice_isSorted() throws InterruptedException, IOException, EmailException 
	    {
	    	
	        admin=new AdminPanelPage(driver);
	        
	        admin.verify_sorting();
	    	
	    	
	    	}

}

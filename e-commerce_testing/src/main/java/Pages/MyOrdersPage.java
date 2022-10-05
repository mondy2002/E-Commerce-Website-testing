package Pages;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class MyOrdersPage extends MyAccountPage {
	public void login()
	{
		account_btn.click();
		myaccount_btn.click();
        log_email.sendKeys("fff@yahoo.com");
         log_pass.sendKeys("1234567");
         log_button.click();
	}

	public MyOrdersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[contains(text(),'My Orders')]")
	WebElement my_orders;
	@FindBy(xpath="//a[contains(text(),'View Order')]")
	WebElement view_order;
	@FindBy(css="body.sales-order-view.customer-account:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col2-left-layout div.main div.col-main:nth-child(2) div.my-account div.page-title.title-buttons:nth-child(1) > h1:nth-child(1)")
	WebElement order_status;
	@FindBy(xpath="//a[@class='link-print']")
	WebElement print_order;

	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tfoot[1]/tr[1]/td[2]/strong[1]/span[1]")
	WebElement grandtotal;
	@FindBy(xpath="//*[@class='input-text qty']")
	WebElement QTY;
	@FindBy(xpath="//*[@class='button btn-update']")
	WebElement update;
	@FindBy(xpath = "//a[contains(text(),'Reorder')]")
	WebElement reorder;
	
	
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement mobile;
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[3]/div[1]/div[3]/button[1]")
	WebElement iphone_to_cart;
	@FindBy(xpath = "//input[@id='coupon_code']")
	WebElement coupon;
	@FindBy(xpath = "//*[@title='Apply']")
	WebElement apply;
	
	public void verif_order_pdf()
	{
		
         my_orders.click();
         view_order.click();
         try 
         {
 	    	Assert.assertEquals(order_status.getText(),"ORDER "+order_num+"- PENDING");

         }catch(Exception e)
         {
        	 e.printStackTrace();
         }
         print_order.click();
         
  
         
	}
	
	public void verify_reorder() throws InterruptedException
	{
		for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
		reorder.click();
        Thread.sleep(4000);

        double grand1 = Double.parseDouble( grandtotal.getText().substring(1) .replaceAll(",", ""));
         String newamount="10";
			double newam=Double.parseDouble(newamount);
            Thread.sleep(4000);

			QTY.clear();
			QTY.sendKeys(newamount);
			update.click();
	        double grand2 = Double.parseDouble( grandtotal.getText().substring(1).replaceAll(",", "") );

			try 
	         {
	 	    	Assert.assertEquals((grand1*newam)+(5*newam),grand2);
                System.out.println("the grandtotal is updated successfully");
	         }catch(Exception e)
	         {
	        	 System.out.println("the grandtotal isnot updated");
	        	 e.printStackTrace();
	         }
             proceed_checkout.click();
             contin.click();
             Thread.sleep(4000);

             ship_validation.click();
             
             Thread.sleep(4000);
             check.click();
             confirm_pay.click();
             Thread.sleep(4000);
             place_order.click();
             Thread.sleep(4000);
			String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();	

            System.out.println("the order number is"+orderNum);
	}
	
	
	public void verify_discount() throws IOException
	{
         mobile.click();
         iphone_to_cart.click();
         coupon.sendKeys("GURU50");
         double before_price = Double.parseDouble( grandtotal.getText().substring(1) .replaceAll(",", ""));
          System.out.println("before price is checked ");
         apply.click();
		    String vDiscDisp = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText().trim();
		    System.out.println(vDiscDisp);
		    String vDiscountedAmtDisplayed = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText().trim();
		    System.out.println(vDiscountedAmtDisplayed);

         double after_price = Double.parseDouble( grandtotal.getText().substring(1) .replaceAll(",", ""));
         System.out.println("after price is checked ");
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     	String png = ("C:\\Users\\Mass\\eclipse-workspace\\e-commerce_testing\\ScreenShots\\coupon_price 4 .png");
     	FileUtils.copyFile(scrFile, new File(png));
         if (after_price==(before_price*.05))
         {
             System.out.println("coupon is working ");

         }else
         {
             System.out.println("coupon is not working ");

         }
         
         

	}
}

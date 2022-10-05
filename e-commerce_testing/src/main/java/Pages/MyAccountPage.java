package Pages;

import java.util.concurrent.CyclicBarrier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@class='skip-link skip-account']")
	WebElement account_btn;
	
	@FindBy(xpath="//*[@title='My Account']")
	WebElement myaccount_btn;
	@FindBy(xpath="//*[@title='Create an Account']")
	WebElement create_acc;
	
	@FindBy(xpath="//*[@id='firstname']")
	WebElement first_name;
	@FindBy(xpath="//*[@id='middlename']")
	WebElement middle_name;
	@FindBy(xpath="//*[@id='lastname']")
	WebElement last_name;
	@FindBy(xpath="//*[@id='email_address']")
	WebElement email;
	@FindBy(xpath="//*[@id='password']")
	WebElement password;
	@FindBy(xpath="//*[@id='confirmation']")
	WebElement confirm_pass;
	@FindBy(xpath="//button[@title='Register']")
	WebElement register;
	@FindBy(xpath="//*[@title='Sign Up for Newsletter']")
	WebElement newsletter;
	@FindBy(xpath="//*[@class='success-msg']")
	WebElement success_reg;
	@FindBy(xpath="//a[contains(text(),'TV')]")
	WebElement tv;
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[3]/ul[1]/li[1]/a[1]")
	WebElement add_wish;
	@FindBy(xpath="//*[@title='Share Wishlist']")
	WebElement share_wish;
	@FindBy(xpath="//*[@id='email_address']")
	WebElement share_email;
	@FindBy(xpath="//*[@id='message']")
	WebElement share_msg;
	
	//verify purchase starts from here 
	
	@FindBy(xpath="//*[@id='email']")
	WebElement log_email;
	@FindBy(xpath="//*[@id='pass']")
	WebElement log_pass;
	@FindBy(xpath="//*[@id='send2']")
	WebElement log_button;
	@FindBy(css = "body.customer-account-index.customer-account:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col2-left-layout div.main div.col-left.sidebar.col-left-first:nth-child(1) div.block.block-account div.block-content ul:nth-child(1) li:nth-child(8) > a:nth-child(1)")
	WebElement mywish_link;
	@FindBy(xpath="//*[@title='Add to Cart']")
	WebElement Add_to_Cart;	
	@FindBy(xpath="//*[@title='Proceed to Checkout']")
	WebElement proceed_checkout;

	
	@FindBy(xpath="//*[@id='billing:street1']")
	WebElement address;	
	@FindBy(xpath="//*[@title='City']")
	WebElement city;	
	@FindBy(xpath="//*[@title='Telephone']")
	WebElement telephone;
	@FindBy(xpath="//*[@title='Zip']")
	WebElement ZipCode;
	@FindBy(xpath="//*[@title='Continue']")
	WebElement contin;
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[1]/ol[1]/li[4]/div[2]/div[2]/button[1]")
	WebElement confirm_pay;
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[1]/ol[1]/li[3]/div[2]/form[1]/div[1]/dl[1]/dd[1]/ul[1]/li[1]/label[1]")
	WebElement ship_cost;
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[1]/ol[1]/li[3]/div[2]/form[1]/div[3]/button[1]")
	WebElement ship_validation;
	@FindBy(xpath="//*[@id='p_method_checkmo']")
	WebElement check;
	@FindBy(xpath="//*[@id='product-price-4']")
	WebElement product_price;
	@FindBy(css = "body.checkout-onepage-index:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col2-right-layout div.main div.col-main ol.opc.opc-firststep-billing:nth-child(5) li.section.allow.active:nth-child(5) div.step.a-item div.order-review table.data-table.linearize-table.checkout-review-table tfoot:nth-child(3) tr.last:nth-child(3) td.a-right.last:nth-child(2) strong:nth-child(1) > span.price")
	WebElement net_price;
	
	@FindBy(xpath="//*[@title='Place Order']")
	WebElement place_order;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]")
	WebElement order_confirm;

	@FindBy(css = "body.checkout-onepage-index:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col2-right-layout div.main div.col-main ol.opc.opc-firststep-billing:nth-child(5) li.section.allow.active:nth-child(5) div.step.a-item div.order-review table.data-table.linearize-table.checkout-review-table tfoot:nth-child(3) tr.last:nth-child(3) td.a-right.last:nth-child(2) strong:nth-child(1) > span.price")
	WebElement order_num;
	
	
	public void share_wishlist() throws InterruptedException
	{
		account_btn.click();
		myaccount_btn.click();
		create_acc.click();
		first_name.sendKeys("ahmad");
		middle_name.sendKeys("ahmad");
		last_name.sendKeys("mondy");
		email.sendKeys("dxdy@gmail.com");
		password.sendKeys("1234567");
		confirm_pass.sendKeys("1234567");
	
		newsletter.click();
		try {
		register.click();
		}
		catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		Thread.sleep(4000);
		try {
	    	Assert.assertEquals(success_reg.getText(), "Thank you for registering with Main Website Store.");
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		tv.click();
        add_wish.click();
        share_wish.click();
        share_email.sendKeys("mody@gmail.com");
        share_msg.sendKeys("hello");
        share_wish.click();
        try {
	    	Assert.assertEquals(success_reg.getText(), "Your Wishlist has been shared.");
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }

	}
	public void verify_purchase () throws InterruptedException
	{
		account_btn.click();
		myaccount_btn.click();
        log_email.sendKeys("fff@yahoo.com");
         log_pass.sendKeys("1234567");
         log_button.click();
         mywish_link.click();
         double newone = Double.parseDouble( product_price.getText().substring(1) );
         //double product=Integer.parseInt(product_price.getText().replaceAll("$", ""));

         Add_to_Cart.click();
         proceed_checkout.click();
         Thread.sleep(2000);

         address.clear();
         address.sendKeys("abc");
         city.clear();
         city.sendKeys("New York");
         Select m= new Select(driver.findElement(By.xpath("//select[@id='billing:region_id']")));
         m.selectByVisibleText("New York");
         telephone.clear();
         telephone.sendKeys("12345678");
         ZipCode.clear();
         ZipCode.sendKeys("542896");
         Thread.sleep(6000);
         contin.click();
         Thread.sleep(6000);

         try 
         {
 	    	Assert.assertEquals(ship_cost.getText(), "Fixed $5.00");

         }catch(Exception e)
         {
        	 e.printStackTrace();
         }
         Thread.sleep(6000);

         ship_validation.click();
         Thread.sleep(6000);

         check.click();
         confirm_pay.click();
         Thread.sleep(6000);

         double newtwo = Double.parseDouble( net_price.getText().substring(1) );

         //double final_price=Integer.parseInt(net_price.getText().replaceAll("$", ""));
         try 
         {
 	    	Assert.assertEquals(newone+5,newtwo );

         }catch(Exception e)
         {
        	 e.printStackTrace();
         }
         

         place_order.click();
         Thread.sleep(6000);
 	    String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();	

         try 
         {
 	    	Assert.assertEquals(order_confirm.getText(),"Your order # is: "+ orderNum);

         }catch(Exception e)
         {
        	 e.printStackTrace();
         }
         System.out.println(order_num);
	}

}

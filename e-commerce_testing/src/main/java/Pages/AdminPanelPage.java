package Pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

import javax.mail.Session;

public class AdminPanelPage extends PageBase{

	public AdminPanelPage(WebDriver driver) {
	       super(driver);
	}
	@FindBy(xpath="//*[ @id='username' ]")
	WebElement user;
	@FindBy(xpath="//*[ @id='login' ]")
	WebElement password;
	@FindBy(xpath="//*[ @title='Login' ]")
	WebElement login;
	@FindBy(xpath="//*[ @title='close' ]")
	WebElement close;
	@FindBy(css = "body.adminhtml-customer-index:nth-child(2) div.wrapper:nth-child(1) div.header:nth-child(2) div.nav-bar ul:nth-child(1) li.parent.level0:nth-child(1) a:nth-child(1) > span:nth-child(1)")
	WebElement Sales;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]\r\n")
	WebElement orders;
	@FindBy(xpath="//*[ @title='Export' ]")
	WebElement export;
	@FindBy(xpath="//select[@id='sales_order_grid_filter_status']")
	WebElement status;
	@FindBy(xpath="//*[@title='Search' ]")
	WebElement search;
	@FindBy(xpath="//*[ @id='sales_order_grid_massaction-select' ]")
	WebElement actions;
	@FindBy(xpath="//*[ @title='Submit' ]")
	WebElement submit;
	@FindBy(css ="body.adminhtml-sales-order-index:nth-child(2) div.wrapper:nth")
	WebElement errormsg;
	
	// review approved
	
	@FindBy(xpath="//*[ @id='Quality 1_1' ]")
	WebElement stars;
	@FindBy(xpath="//*[ @name='detail' ]")
	WebElement review;
	@FindBy(xpath="//*[ @name='title' ]")
	WebElement summary;
	@FindBy(xpath="//*[ @name='nickname' ]")
	WebElement nick;
	@FindBy(xpath="//button[ @title='Submit Review' ]")
	WebElement submit_review;
	@FindBy(xpath="//span[contains(text(),'Catalog')]")
	WebElement catalog;
	@FindBy(xpath="//span[contains(text(),'Reviews and Ratings')]")
	WebElement review_rating;
	@FindBy(xpath="//span[contains(text(),'Customer Reviews')]")
	WebElement Customer_Reviews;
	@FindBy(xpath="//span[contains(text(),'Pending Reviews')]")
	WebElement Pending_Reviews;
	@FindBy(xpath="//tbody/tr[1]/td[10]/a[1]")
	WebElement edit;
	@FindBy(xpath="//*[@id='status_id']")
	WebElement status_id;
	@FindBy(xpath="//button[@id='save_button']")
	WebElement save_button;
	@FindBy(css = "body.review-product-list:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col2-right-layout div.main div.col-main div.product-view:nth-child(3) div.box-collateral.box-reviews dl:nth-child(2) dt:nth-child(1) > a:nth-child(1)")
	WebElement rev_link;
	// invoice
	@FindBy(xpath="//*[contains(text(),'Invoices')]")
	WebElement invoices_btn;
	@FindBy(xpath="//*[@class='sort-title']")
	WebElement sort_btn;
	
	public void excel_test() throws EmailException
	{
		driver.get("http://live.techpanda.org/index.php/backendlogin/index/index/key/422e1ed51e3ebffd321b4940991c2e44/");
		user.sendKeys("user01");
		password.sendKeys("guru99com");
		login.click();
		close.click();
		
		Actions action=new Actions(driver);
		action.moveToElement(Sales).build().perform();
		orders.click();
		export.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		
		File f = new File("C:\\Users\\Mass\\Downloads\\orders.csv");

		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("mohamad55elnagar@gmail.com", "Mondy170.#"));
			email.setSSLOnConnect(true);
			email.setFrom("mohamad55elnagar@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo("mohamad55elnagar@gmail.com");
			email.send();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null){
				System.out.println(line);
				line = br.readLine();
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void review_approved() throws IOException, InterruptedException
	{
		driver.get("http://live.techpanda.org/index.php/review/product/list/id/1/");
		
		String myrev= "loved it";
		String title= "revieew";
		String NickName= "moooo";
		
		stars.click();
		review.sendKeys(myrev);
		summary.sendKeys(title);
	    nick.sendKeys(NickName);
        submit_review.click();
		driver.get("http://live.techpanda.org/index.php/backendlogin/index/index/key/422e1ed51e3ebffd321b4940991c2e44/");
		user.sendKeys("user01");
		password.sendKeys("guru99com");
		login.click();
		close.click();
		Actions action = new Actions (driver);
		 action.moveToElement(catalog).build().perform();
		 action.moveToElement(review_rating).build().perform();
		 action.moveToElement(Customer_Reviews).build().perform();
		 action.moveToElement(Pending_Reviews).build().perform();

		 Pending_Reviews.click();
		 Thread.sleep(5000);
		edit.click();
		Select ss= new Select (status_id);
		ss.selectByIndex(0);
		driver.get("http://live.techpanda.org/index.php/review/product/list/id/1/");
        try 
        {
        	Assert.assertEquals(rev_link.getText().toLowerCase(),title);
        	System.out.println("the review is saved");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    	String PNG = ("C:\\Users\\Mass\\eclipse-workspace\\e-commerce_testing\\ScreenShots\\review_is_saved .png");
    	FileUtils.copyFile(scrFile2, new File(PNG));
		
	}

public void verify_sorting () throws IOException, InterruptedException
{
	driver.get("http://live.techpanda.org/index.php/backendlogin/index/index/key/422e1ed51e3ebffd321b4940991c2e44/");
	user.sendKeys("user01");
	password.sendKeys("guru99com");
	login.click();
	close.click();
	Actions action=new Actions(driver);
	action.moveToElement(Sales).build().perform();
	invoices_btn.click();
	
	File scrFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	String PNG = ("C:\\Users\\Mass\\eclipse-workspace\\e-commerce_testing\\ScreenShots\\asc_invoice .png");
	FileUtils.copyFile(scrFile3, new File(PNG));
	 sort_btn.click();
	 Thread.sleep(2000);
	File scrFile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String PNGG = ("C:\\Users\\Mass\\eclipse-workspace\\e-commerce_testing\\ScreenShots\\desc_invoice .png");
	FileUtils.copyFile(scrFile4, new File(PNGG));
	 Thread.sleep(2000);

}





}



	
	


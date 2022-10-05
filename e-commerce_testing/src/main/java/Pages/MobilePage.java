package Pages;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class MobilePage extends PageBase{
	public int scc = 0;
	
	public  MobilePage (WebDriver driver)
	{
		
       super(driver);
	}
	
	
	
	
	@FindBy(linkText = "MOBILE")
	WebElement mobile;
	@FindBy(xpath="//*[ @title='Sort By' ]")
	WebElement sortby;
	@FindBy(xpath="//*[ @title='Sony Xperia' ]")
	WebElement sony_card;
	
	@FindBy(css ="#product-price-1 > span.price")
	WebElement sony_outer_p;
	@FindBy(css ="span.price")
	WebElement sony_inner_p;
	
	
	@FindBy(xpath="//*[ @title='Add to Cart' ]")
	WebElement AddToCart;
	@FindBy(xpath="//*[ @title='Qty' ]")
	WebElement Qty;
	@FindBy(xpath="//*[ @title='Update' ]")
	WebElement update;
	@FindBy(xpath="//*[ @class='item-msg error' ]")
	WebElement error_msg;
	
	@FindBy(xpath="//*[ @title='Empty Cart' ]")
	WebElement empty_cart;
	
	@FindBy(xpath="//*[ @class='page-title' ]")
	WebElement empty_cart_title;
	
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[3]/ul[1]/li[2]/a[1]")
	WebElement Sony_compare;
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[2]/div[1]/div[3]/ul[1]/li[2]/a[1]")
	WebElement iphone_compare;
	@FindBy(xpath="//*[ @title='Compare' ]")
	WebElement compare;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div[1]/h1")
	WebElement compare_pagetitle;
	
	@FindBy(xpath="//h2/a[@title='Sony Xperia']")
	WebElement sony_co;
	@FindBy(xpath="//h2/a[@title='IPhone']")
	WebElement iphone_co;
	@FindBy(xpath="//h2/a[@title='Sony Xperia']")
	WebElement mainpanel1;
	@FindBy(xpath="//h2/a[@title='IPhone']")
	WebElement mainpanel2;
	
	@FindBy(xpath="//button[@title='Close Window']")
	WebElement close_popup;
	
	
	
	
	
public void sorted_mobiles() throws IOException
{
mobile.click();	
Select sorting =new Select (sortby);
sorting.selectByIndex(1);
scc = (scc+1);
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String png = ("C:\\Users\\Mass\\eclipse-workspace\\e-commerce_testing\\ScreenShots\\sorted mobiles in " + scc + ".png");
FileUtils.copyFile(scrFile, new File(png));
}
public void sony_certain_price() throws IOException
{
	mobile.click();	
	String sony1=sony_outer_p.getText();
	sony_card.click();
	String sony2=sony_inner_p.getText();
	Assert.assertEquals(sony1, sony2);
	scc = (scc+1);
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String png = ("C:\\Users\\Mass\\eclipse-workspace\\e-commerce_testing\\ScreenShots\\sony_price " + scc + ".png");
	FileUtils.copyFile(scrFile, new File(png));
}
public void order_many_items() throws IOException
{
	mobile.click();
	AddToCart.click();
	Qty.clear();
	Qty.sendKeys("1000");
	update.click();
	scc = (scc+1);
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String png = ("C:\\Users\\Mass\\eclipse-workspace\\e-commerce_testing\\ScreenShots\\sony_error_message " + scc + ".png");
	FileUtils.copyFile(scrFile, new File(png));
	Assert.assertEquals(error_msg.getText(), "The requested quantitiy for 'Sony Xperia' is not available");

	empty_cart.click();
	Assert.assertEquals(empty_cart_title.getText(), "SHOPPING CART IS EMPTY");
	scc = (scc+1);
	File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	String PNG = ("C:\\Users\\Mass\\eclipse-workspace\\e-commerce_testing\\ScreenShots\\empty_cart_title " + scc + ".png");
	FileUtils.copyFile(scrFile2, new File(PNG));
}
public void  compare_2Products () throws InterruptedException
{
	mobile.click();
	Sony_compare.click();
    iphone_compare.click();
    System.out.println("mainpanel1="+mainpanel1.getText());
    System.out.println("mainpanel2="+mainpanel2.getText());
    compare.click();
    for (String handle : driver.getWindowHandles()) {
    	driver.switchTo().window(handle);
    	}


    
    try {
    	Assert.assertEquals(compare_pagetitle.getText(), "COMPARE PRODUCTS");
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
    try {
    	Assert.assertEquals(sony_co.getText(), mainpanel1.getText());
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
    try {
    	Assert.assertEquals(iphone_co.getText(), mainpanel2.getText());
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
	
    Thread.sleep( 5000);
    close_popup.click();
    Thread.sleep( 5000);
    for (String handle : driver.getWindowHandles()) {
    	driver.switchTo().window(handle);
    	}
}


}

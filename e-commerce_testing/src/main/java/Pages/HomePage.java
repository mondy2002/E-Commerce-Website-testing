package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
	public  HomePage (WebDriver driver)
	{
		
       super(driver);
	}
	
	@FindBy(xpath="//*[ contains (text() , 'This is demo site for') ]")
	WebElement homepagetitle;
	
	@FindBy(xpath="//*[ @title='Advanced Search']")
	WebElement advanced_search;
	@FindBy(xpath="//input[ @id='price']")
	WebElement init_price;
	@FindBy(xpath="//input[ @id='price_to']")
	WebElement dest_price;
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/button[1]\r\n")
	WebElement search;
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/ul[1]/li[1]/div[1]/h2[1]")
	WebElement first_prod_name;
	@FindBy(css = "body.catalogsearch-advanced-result:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col2-right-layout div.main div.col-main div.category-products ul.products-grid.products-grid--max-4-col.first.last.odd:nth-child(2) li.item.last:nth-child(1) div.product-info div.price-box span.regular-price > span.price")
	WebElement first_prod_price;

	public void  homepagetitle ()
	{

        Assert.assertTrue(homepagetitle.isDisplayed());
	}
	
public void search_filter() throws InterruptedException
{
	driver.get("http://live.techpanda.org/index.php/");
	advanced_search.click();
	init_price.sendKeys("0");
	dest_price.sendKeys("150");
	
	search.click();
	
	System.out.println(first_prod_name.getText());
    double price= Double.parseDouble(first_prod_price.getText().substring(1));
    if (price>=0&&price<150)
    {
	System.out.println(first_prod_price.getText());
    }
    else
    {
    	System.out.println("the search filter is not working");
    }
    driver.navigate().back();
    init_price.clear();
	init_price.sendKeys("151");
	dest_price.clear();
	dest_price.sendKeys("1000");
	search.click();
	System.out.println(first_prod_name.getText());
	if (price>=0&&price<150)
    {
	System.out.println(first_prod_price.getText());
    }
    else
    {
    	System.out.println("the search filter is not working");
    }

}
}

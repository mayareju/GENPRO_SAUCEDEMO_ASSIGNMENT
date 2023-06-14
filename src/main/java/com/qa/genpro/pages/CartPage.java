package com.qa.genpro.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//span[text()='4']")
	private WebElement text3;	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkout;
	@FindBy(xpath="(//div[@class='inventory_item_price'])[1]")
	List<WebElement> lPrice;
	
	@FindBy(xpath="(//button[@class='btn btn_secondary btn_small cart_button'])[1]")
	private WebElement remove;
	
	@FindBy(xpath="//span[text()='Checkout: Your Information']")
	private WebElement text4;
	
	public void removeOption() throws InterruptedException {
		int length = lPrice.size();
		for(int i = 0; i<length; i++) {
			 
			String x = lPrice.get(i).getText().replace("$", "");
			 
			float y = Float.parseFloat(x);
			
			for(int j=0;j<length+1;j++) {
				
            if(y<15) {
            	
            	Thread.sleep(1000);
            remove.click();
            	Thread.sleep(1000);
              
            }
            
		}
		}
		
	}
	
	public boolean text3() {
		boolean text=text3.isDisplayed();
		return text;
	}
	
	public boolean text4() {
		boolean text=text4.isDisplayed();
		return text;
	}
	

	public void checkOut() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	checkout.click();
	
}

}

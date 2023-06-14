package com.qa.genpro.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

	WebDriver driver;
	
	public AddressPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}

	
	@FindBy(id="first-name")
	private WebElement fstname;
	
	@FindBy(id="last-name")
	private WebElement lstname;
	
	@FindBy(id="postal-code")
	private WebElement pcode;
	
	@FindBy(id="continue")
	private WebElement cont;
	
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	private WebElement checkouttext;
	
	@FindBy(xpath="//span[text()='Checkout: Complete!']")
	private WebElement checkoutcomplete;
	
	@FindBy(id="finish")
	private WebElement finish;
	
	public boolean checkouttext() {
		boolean text=checkouttext.isDisplayed();
		return text;
	}
	
	public boolean checkoutcomplete() {
		boolean text=checkoutcomplete.isDisplayed();
		return text;
	}
	
	public void setfirstName(String fname) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		fstname.sendKeys(fname);
		
	}	
	
	public void setlastName(String lname) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lstname.sendKeys(lname);
		
	}
	
	public void setPostcode(String pstcode) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		pcode.sendKeys(pstcode);
		
	}
	
	public void clickCont() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cont.click();
		
	}	
public void clickFinish() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		finish.click();
}
}

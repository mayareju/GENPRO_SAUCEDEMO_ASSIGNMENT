package com.qa.genpro.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="back-to-products")
	private WebElement backhome;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement dash;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logout;
	
	public void clickBackHome() {
		backhome.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void clicklogout() {
		dash.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logout.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
}

package com.qa.genpro.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;

	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(id="login-button")
	private WebElement login;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement dash;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logout;
	
	@FindBy(xpath = "//span[@class ='title']")
	private WebElement Title;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement error;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void setUsername(String strUserName) {
		username.clear();
	username.sendKeys(strUserName);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void setPassword(String strPassword) {
		pass.clear();
		pass.sendKeys(strPassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	public void clicklogin() {
		login.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

	public void clicklogout() {
		dash.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logout.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	
	public String gettext() {
	String Text =Title.getText();
	return Text;
	}
	
	public String getError() {
		String Text =error.getText();
		return Text;
		}
	
	public boolean isnamepresent() {
		boolean ispresent = Title.isDisplayed();
		return ispresent;
		}
	
	
	public boolean enableLoginButton() {
		boolean button=login.isEnabled();
		return button;
	}
	public void Implicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}

package com.qa.genpro.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.genpro.pages.LoginPage;
import com.qa.genpro.utilities.ExcelUtility;



public class TestClass extends TestBase {
	
	LoginPage objlogin;

@Test(priority=1,description="Login with invalid Username and valid Password")
	
	public void loginPageverification1 () throws IOException, Exception {
		
		objlogin = new LoginPage(driver);
		String username=ExcelUtility.getCellData(4,0,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
		String password= ExcelUtility.getCellData(0,1,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
		objlogin.setUsername(username);
		objlogin.setPassword(password);
		objlogin.clicklogin();
		String error=objlogin.getError();
		Assert.assertEquals(error,"Epic sadface: Username and password do not match any user in this service");
		
}
@Test(priority=2,description="Login with valid Username and invalid Password")

public void loginPageverification2 () throws IOException, Exception {
	
	objlogin = new LoginPage(driver);
	String username=ExcelUtility.getCellData(0,0,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	String password= ExcelUtility.getCellData(1,1,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	objlogin.setUsername(username);
	objlogin.setPassword(password);
	objlogin.clicklogin();
	String error=objlogin.getError();
	Assert.assertEquals(error,"Epic sadface: Username and password do not match any user in this service");
	
}
@Test(priority=3,description="Login with invalid Username and invalid Password")

public void loginPageverification3 () throws IOException, Exception {
	
	objlogin = new LoginPage(driver);
	String username=ExcelUtility.getCellData(5,0,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	String password= ExcelUtility.getCellData(0,1,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	objlogin.setUsername(username);
	objlogin.setPassword(password);
	objlogin.clicklogin();
	String error=objlogin.getError();
	Assert.assertEquals(error,"Epic sadface: Username and password do not match any user in this service");
	
}
@Test(priority=4,description="Login with valid Username1 and valid Password")

public void loginPageverification4 () throws IOException, Exception {
	
	objlogin = new LoginPage(driver);
	String username=ExcelUtility.getCellData(0,0,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	String password= ExcelUtility.getCellData(0,1,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	objlogin.setUsername(username);
	objlogin.setPassword(password);
	objlogin.clicklogin();
	
	String error=objlogin.gettext();
	Assert.assertEquals(error,"Products");
	
	objlogin.clicklogout();
	boolean loginbutton=objlogin.enableLoginButton();
	Assert.assertTrue(loginbutton);
	objlogin.Implicitwait();
	
}
@Test(priority=5,description="Login with valid Username2 and valid Password")

public void loginPageverification5 () throws IOException, Exception {
	
	objlogin = new LoginPage(driver);
	String username=ExcelUtility.getCellData(3,0,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	String password= ExcelUtility.getCellData(0,1,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	objlogin.setUsername(username);
	objlogin.setPassword(password);
	objlogin.clicklogin();
	
	String error=objlogin.gettext();
	Assert.assertEquals(error,"Products");
	objlogin.Implicitwait();
	objlogin.clicklogout();
	objlogin.Implicitwait();
	boolean loginbutton=objlogin.enableLoginButton();
	Assert.assertTrue(loginbutton);
	
}
@Test(priority=6,description="Login with valid Username3 and valid Password")

public void loginPageverification6 () throws IOException, Exception {
	
	objlogin = new LoginPage(driver);
	String username=ExcelUtility.getCellData(2,0,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	String password= ExcelUtility.getCellData(0,1,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	objlogin.setUsername(username);
	objlogin.setPassword(password);
	objlogin.clicklogin();
	
	String error=objlogin.gettext();
	Assert.assertEquals(error,"Products");
	objlogin.Implicitwait();
	objlogin.clicklogout();
	objlogin.Implicitwait();
	boolean loginbutton=objlogin.enableLoginButton();
	Assert.assertTrue(loginbutton);
	
}
@Test(priority=7,description="Login with valid Username4 and valid Password")

public void loginPageverification7 () throws IOException, Exception {
	
	objlogin = new LoginPage(driver);
	String username=ExcelUtility.getCellData(1,0,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	String password= ExcelUtility.getCellData(0,1,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
	objlogin.setUsername(username);
	objlogin.setPassword(password);
	objlogin.clicklogin();
	
	String error=objlogin.gettext();
	Assert.assertEquals(error,"Products");
	objlogin.Implicitwait();
	objlogin.clicklogout();
	objlogin.Implicitwait();
	boolean loginbutton=objlogin.enableLoginButton();
	Assert.assertTrue(loginbutton);
	
}
}
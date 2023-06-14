package com.qa.genpro.testscripts;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.genpro.pages.AddressPage;
import com.qa.genpro.pages.CartPage;
import com.qa.genpro.pages.LoginPage;
import com.qa.genpro.pages.LogoutPage;
import com.qa.genpro.pages.ProductPage;
import com.qa.genpro.utilities.ExcelUtility;

public class TestClass1 extends TestBase {
	
	ProductPage objpdt;
	LoginPage objlogin;
	CartPage objcart;
	AddressPage objaddress;
	LogoutPage objlogout;
	
@Test(priority=8,description="Sort price from low to high")
	
	public void sortPageverification () throws IOException, Exception {
		objlogin = new LoginPage(driver);
		objpdt = new ProductPage(driver);
		String username=ExcelUtility.getCellData(0,0,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
		String password= ExcelUtility.getCellData(0,1,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",0);
		objlogin.setUsername(username);
		objlogin.setPassword(password);
		objlogin.clicklogin();
		Thread.sleep(3000);
		objpdt.beforeSort();
		Thread.sleep(3000);
		objpdt.afterSort();
		List<Double> beforefilterpricelist=objpdt.beforeSort();
		List<Double> afterfilterpricelist=objpdt.afterSort();
		Assert.assertEquals(beforefilterpricelist, afterfilterpricelist);
}
@Test(priority=9,description="Add all items to cart")

public void allItemscartPageverification () throws IOException, Exception {
	
	objpdt = new ProductPage(driver);
	objpdt.addtocart();
	String num=objpdt.cartNum();
	Assert.assertEquals(num,"6");
	
	objpdt.cart();
	boolean carttext=objpdt.cartpageassert();
	Assert.assertTrue(carttext);
}
@Test(priority=10,description="Verify customer can remove items that have a price lessthan $15")
public void removeItemscartPageverification () throws IOException, Exception {
	objcart=new CartPage(driver);
	Thread.sleep(2000);
	objcart.removeOption();
	Thread.sleep(2000);
	boolean cartnum=objcart.text3();
	Assert.assertTrue(cartnum);
	objcart.checkOut();
	boolean text=objcart.text4();
	Assert.assertTrue(text);
	
}
@Test(priority=11,description="Verify customer can enter details")
public void enterdetailsPageverification () throws IOException, Exception {
	objaddress = new AddressPage(driver);
	String firstname = ExcelUtility.getCellData(0,0,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",1);
	String lastname = ExcelUtility.getCellData(0,1,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",1);
	String postcode = ExcelUtility.getNumericData(0,2,System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx",1);
	objaddress.setfirstName(firstname);
	objaddress.setlastName(lastname);
	objaddress.setPostcode(postcode);
	objaddress.clickCont();
	boolean checkoverviewtext = objaddress.checkouttext();
	Assert.assertTrue(checkoverviewtext);
	objaddress.clickFinish();
	boolean checkoutcompletetext=objaddress.checkoutcomplete();
	Assert.assertTrue(checkoutcompletetext);
}
@Test(priority=12,description="Verify customer can logout sucessfully")
public void logoutPageverification () throws IOException, Exception {
	objlogout=new LogoutPage(driver);
	objlogin=new LoginPage(driver);
	objlogout.clickBackHome();
	String products=objlogin.gettext();
	Assert.assertEquals(products, "Products");
	objlogout.clicklogout();
	boolean loginbutton=objlogin.enableLoginButton();
	Assert.assertTrue(loginbutton);
}
}

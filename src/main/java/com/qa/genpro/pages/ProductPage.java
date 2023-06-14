package com.qa.genpro.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement select;
	
	@FindBy(xpath="//option[@value='lohi']")
	private WebElement option;
	
	@FindBy(xpath="//div[@class='inventory_list']")
	private WebElement products;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	List<WebElement> prices;
	
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	List<WebElement> items;
	
	@FindBy(xpath="//span[text()='Price (low to high)']")
	private WebElement text1;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement cartnum;
	
	@FindBy(xpath="//span[text()='Your Cart']")
	private WebElement cartpage;
	
	public void addtocart() {
		List<WebElement> addcart=items;
		for(WebElement p : addcart) {
			p.click();
		}
	}
	
	public boolean cartpageassert() {
		boolean cart=cartpage.getText().contains("Your Cart");
		return cart;
	}
		
	
	public List<Double> beforeSort() {
	List<WebElement> beforefilterprice=prices;
	List<Double> beforefilterpricelist = new ArrayList<Double>();
	for(WebElement p : beforefilterprice) {
		beforefilterpricelist.add(Double.valueOf(p.getText().replace("$", "")));
	}
	Select dropdown = new Select(select);
	dropdown.selectByVisibleText("Price (low to high)");
	Collections.sort(beforefilterpricelist);
	return beforefilterpricelist;
	}
	public List<Double> afterSort() {
	List<WebElement> afterfilterprice=prices;
	List<Double> afterfilterpricelist = new ArrayList<Double>();
	for(WebElement p : afterfilterprice) {
		afterfilterpricelist.add(Double.valueOf(p.getText().replace("$", "")));
	}
	return afterfilterpricelist;
	
	}

	public String cartNum() {
	String num=cartnum.getText();
	
	return num;
	}


	public void cart() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	cartnum.click();
	
	}
	}



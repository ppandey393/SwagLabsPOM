package com.SwagLabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators
	private By detail = By.xpath("//div[@class='inventory_item_name']");
	private By removebtn = By.xpath("//button[text()='Remove']");
	private By contbtn = By.id("continue-shopping");
	private By chkbtn = By.id("checkout");
	private By cartQn = By.xpath("//div[@class='cart_quantity']");
	
	private By fname = By.id("first-name");
	private By lname = By.id("last-name");
	private By zip = By.id("postal-code");
	private By contn = By.id("continue");
	
	private By pdetail = By.xpath("//div[@class='cart_item']");
	private By bill = By.xpath("//div[@class='summary_info']");
	private By finish = By.id("finish");
	private By tnk = By.xpath("//h2[@class='complete-header']");
	
	//methods
	public void itemDetail()
	{
		String itemadded = driver.findElement(detail).getText();
		System.out.println("Item in cart is: "+itemadded);		
	}
	
	public void remove()
	{
		int itemsize = driver.findElements(cartQn).size();
		if(itemsize==1)
		{
			driver.findElement(removebtn).click();
		}
		System.out.println("Product is removed and cart is empty");
	}
	
	public void continueShop()
	{
		driver.findElement(contbtn).click();
		System.out.println("Inventory page loaded");
	}
	
	public void checkout()
	{
		driver.findElement(chkbtn).click();
		System.out.println("Checkout: Your Information page opens");
		
		System.out.println("*****Enter the user's details*****");
		driver.findElement(fname).sendKeys("John");
		driver.findElement(lname).sendKeys("Carter");
		driver.findElement(zip).sendKeys("200512");
		driver.findElement(contn).click();
	}
	
	public void paymentPage()
	{
		System.out.println("Check the bill details:");
		List<WebElement> itemdetail = driver.findElements(pdetail);
		for(WebElement i:itemdetail)
		{
			System.out.println(i.getText());
		}
		
		List<WebElement> billdetail = driver.findElements(bill);
		for(WebElement y:billdetail)
		{
			System.out.println(y.getText());
		}
	  }
	
	public void purchaseOver()
	{
		driver.findElement(finish).click();
		String actmsg = driver.findElement(tnk).getText();
		String expmsg = "Thank you for your order!";
		if(actmsg.equals(expmsg))
			System.out.println("Purchase is finished!");
		else
			System.out.println("Purchase is not finished");
	}
}

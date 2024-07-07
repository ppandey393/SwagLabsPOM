package com.SwagLabs.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InventoryPage {
	
	private WebDriver driver;
	
	public InventoryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	private By priceSort = By.xpath("//select[@class='product_sort_container']");
	private By pcount = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name ']");
	private By addBtn = By.id("add-to-cart");
	private By cart = By.xpath("//a[@class='shopping_cart_link']");
	
	//Methods
	public void SortItems()
	{
		WebElement dropdown = driver.findElement(priceSort);
		Select filter = new Select(dropdown);
		filter.selectByVisibleText("Price (low to high)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Items sorted by price");
	}
	public void productDisplay()
	{
		List<WebElement> list = driver.findElements(pcount);
		System.out.println("Product Details are:");
		for(WebElement i:list)
		{
			System.out.println(i.getText());
		}
	}
	
	public void productCount()
	{
		int itemCount = driver.findElements(pcount).size();
		Assert.assertEquals(itemCount,6, "Test Fail: Total product count not matched!");
		System.out.println("Test TotalItems Pass: Total product count matched as: "+itemCount);
	}
	
	public void addProductToCart(String prodName)
	{
		List<WebElement> list = driver.findElements(pcount);
		for(WebElement i:list)
		{
			if(i.getText().contains(prodName))
			{
				i.click();
				break;
			}
		}
		System.out.println("Product selected is: "+prodName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(addBtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Product added to cart!");
	}
	
	public void cartcheck()
	{
		driver.findElement(cart).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User landed to cart page successfully!");
	}
}

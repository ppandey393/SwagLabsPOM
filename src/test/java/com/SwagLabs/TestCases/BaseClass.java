package com.SwagLabs.TestCases;

import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SwagLabs.Pages.*;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage ip;
	public CartPage cp;
	
	@BeforeTest
	public void setUp()
	{
		//initialization
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		lp=new LoginPage(driver);  //initializing LoginPage object and passing driver
		ip=new InventoryPage(driver); //initializing InventoryPage object and passing driver
		cp=new CartPage(driver);
		
	}
	
//	@BeforeClass
//	public void pageSetup()
//	{
//		lp.verifyUrl();
//		lp.verifyTitle();
//		lp.verifyLogin("standard_user", "secret_sauce");
//		ip.TotalItems();
//		ip.productList();
//		ip.SortItems();
//		ip.itemSelect("Test.allTheThings() T-Shirt (Red)");
//		ip.cartcheck();
//	}
//	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}

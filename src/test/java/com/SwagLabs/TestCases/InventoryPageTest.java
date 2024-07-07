package com.SwagLabs.TestCases;

import org.testng.annotations.*;

public class InventoryPageTest extends BaseClass{
	
	@BeforeClass
	public void pageSetup()
	{
		lp.verifyLogin("standard_user", "secret_sauce");
	}
	
	@Test(priority=1)
	public void verifySortItems()
	{
		ip.SortItems();
	}
	
	@Test(priority=2)
	public void verifyproductDisplay() {
		ip.productDisplay();
	}
  
	@Test(priority=3)
	public void verifyproductCount()
	{
	  ip.productCount();
	}
  
	@Test(priority=4)
	public void verifyaddProductToCart()
	{
	  ip.addProductToCart("Test.allTheThings() T-Shirt (Red)");
	}
	
	@Test(priority=5)
	public void verifyCartcheck()
	{
		ip.cartcheck();
	}
}

package com.SwagLabs.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartPageTest  extends BaseClass{
	
	@BeforeClass
	public void pageSetup()
	{
		lp.verifyLogin("standard_user", "secret_sauce");
		ip.addProductToCart("Sauce Labs Onesie");
		ip.cartcheck();
	}
	
	@Test(priority=1)
	public void verifyIemDetail()
	{
		cp.itemDetail();
	}
	
	@Test(priority=2)
	public void verifyRemove()
	{
		cp.remove();
	}
	
	@Test(priority=3)
	public void verifyContinueShop()
	{
		cp.continueShop();
		ip.addProductToCart("Sauce Labs Bike Light");
		ip.cartcheck();
	}
	
	@Test(priority=4)
	public void verifyCheckout()
	{
		cp.checkout();
	}
	
	@Test(priority=5)
	public void verifyPaymentPage()
	{
		cp.paymentPage();
	}
	
	@Test(priority=6)
	public void verifyPurchaseOver()
	{
		cp.purchaseOver();
	}
}

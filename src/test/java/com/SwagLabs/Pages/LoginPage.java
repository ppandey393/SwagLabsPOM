package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	
	//Encapsulation = private data + public methods and functions
	
	private WebDriver driver;
	
	//Initialize driver using constructor
	public LoginPage(WebDriver driver)  //from base class
	{
		this.driver=driver;
	}
	
	//Locators
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginbutton = By.id("login-button");
		
	//Methods and Actions
	public void verifyUrl()
	{
		String title_url = driver.getCurrentUrl();
		Assert.assertTrue(title_url.contains("demo"),"Test Fail: Title URL mismatched!");
		System.out.println("Test Pass: Title URL matched and displayed as: "+title_url);
	}
	
	public void verifyTitle()
	{
		String title_name = driver.getTitle();
		Assert.assertTrue(title_name.contains("Swag Labs"),"Test Fail: Title Name mismatched!");
		System.out.println("Test Pass: Title Name matched and displayed as: "+title_name);
	}
	
	public void verifyLogin(String un, String pws)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pws);
		driver.findElement(loginbutton).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Test Fail: Login failed!");
		System.out.println("Test Pass: Login is successful!");
	}

}

package com.SwagLabs.TestCases;

import org.testng.annotations.*;

public class LoginPageTest extends BaseClass{
	
	@Test (priority=1)
  	public void urlCheck() {
		lp.verifyUrl();
	}
	
	@Test (priority=2)
	public void titleCheck() {
		lp.verifyTitle();
	}
  
	@Test (priority=3)
	public void loginfnCheck() {
		lp.verifyLogin("standard_user", "secret_sauce");
	 }
}

package com.inetbanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.PageObjects.LoginPage;
import com.inetbanking.testCases.BaseClass;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void LoginTest() throws IOException 
	{
	
		
		logger.info("Opened the URL");
		
		LoginPage  lp = new LoginPage(driver);

			lp.setUserName(username);
		logger.info("Enterd the UserName");
		
		lp.setPassword(password);
		logger.info("Enterd the Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
		
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		
		else
			{
			
			captureScreen(driver, "Logintest");
				Assert.assertTrue(false);
				logger.info("Login Test Failed");
			}
		}
				
		
	}
	
	





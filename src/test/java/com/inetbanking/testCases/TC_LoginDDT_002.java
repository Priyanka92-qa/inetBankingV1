package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.PageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Entered the username");
		lp.setPassword(pwd);
		logger.info("Entered the password");
		lp.clickSubmit();
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
		  driver.switchTo().alert().accept();//close alret
		  driver.switchTo().defaultContent();
		  Assert.assertTrue(false);
		  logger.info("Login test Failed");
		  
		  
		  
		}
		else
		{
		 lp.clickLogout();
		 Thread.sleep(3000);
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(true);
		 logger.info("Login Test Passed");
		}
		
	}
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
		}
		   catch(NoAlertPresentException e)
		{
		   return false;
		}
		
			
		}
	
	
	@DataProvider(name="LoginData")
	String[][]getData() throws IOException
	{
		String path =System.clearProperty("user.dir")+ "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum =XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for(int i=0;i<=rownum;i++) {
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path,"Sheet1", i, j);
			}
		}
		return logindata;
		
			
			
		}
		
		
	}
	



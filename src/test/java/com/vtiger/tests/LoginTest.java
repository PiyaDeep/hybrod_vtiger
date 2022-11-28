package com.vtiger.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;


import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;


public class LoginTest extends BaseTest {
	
	@Test(groups= {"smoke","Regression"})
	public void TC01_Invalidlogin()
	{
		System.out.println("driver see"+driver);
		String TCName = "TC01_Invalidlogin";
		logger=extent.createTest(TCName);
		LoginPage lp=new LoginPage(driver,logger);
		//lp.login("admin", "admin2");
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
        // lp.Sterrormsg();
         extent.flush();        
		
	}
	@Test(groups= {"smoke","Regression"})
	public void TC02_validlogin()
	{	
		String TCName = "TC02_validlogin";
		logger=extent.createTest(TCName);

		LoginPage lp=new LoginPage(driver,logger);
		//lp.login("admin", "admin");
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
        HomePage hp=new HomePage(driver,logger);
		//hp.clicklogout();
		extent.flush();
		
	}

}

package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import com.vtiger.common.CommonFunction;

public class LoginPage {
	 private WebDriver driver;
	private  CommonFunction cf;
	ExtentTest logger;
	//constructor to use initialization
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		cf=new CommonFunction(driver,logger);
		
	}
	// pagefactory webelement locators
	@FindBy(name="user_name")
	WebElement tb_username;
	@FindBy(name="user_password")
	WebElement tb_password;
	@FindBy(name="Login")
	WebElement btn_login;
	@FindBy(xpath="//td[contains(text(),'You must specify a valid username and password.')]")
	WebElement txt_errormsg;
	
	public void Sterrormsg()
	{
		//return txt_errormsg.isDisplayed();
		cf.IsElementDisplay(txt_errormsg,"Error Message validate");
		
		
	}

	public void login(String urerid,String pwd)//main funcation
	{
		StUsername(urerid);
		StUserpwd(pwd);
		clicklogin();
		
	}
	public void StUsername(String userid)
	{
		//tb_username.clear();
		//tb_username.sendKeys(userid);
		cf.EnterValue(tb_username, userid,userid+"Enter succesfully in user field");
		
	}
	public void StUserpwd(String pwd)
	{
		//tb_password.clear();
		//tb_password.sendKeys(pwd);
		cf.EnterValue(tb_password, pwd,pwd+"Enter succefully in password field");
		
	}
	public void clicklogin()
	{
		
		//btn_login.click();
		cf.ClickElement(btn_login,"Login Button click ");
		
	}

	
}

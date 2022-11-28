package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import com.vtiger.common.CommonFunction;

public class HeaderPage {
	public WebDriver driver;
	public CommonFunction cf;
	ExtentTest logger;

	
	//constructor to use initialization
	public HeaderPage(WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		cf=new CommonFunction(driver,logger);

		
	}
	// pagefactory webelement locators
	@FindBy(linkText="Home")
	WebElement lnk_Home;
	@FindBy(linkText="Leads")
	WebElement lnk_Leads;
	@FindBy(linkText="New Account")
	WebElement lnk_NewAccounts;
	@FindBy(linkText="New Lead")
	WebElement lnk_Newlead;
	@FindBy(linkText="New Potential")
	WebElement lnk_NewPotential;
	
	@FindBy(linkText="Activities")
	WebElement lnk_Activities;
	@FindBy(id="showSubMenu")
	WebElement btn_showmenu;
	@FindBy(linkText="New Task")
	WebElement lnk_ntask;
     @FindBy(linkText="Logout")
	WebElement lnk_Logout;
	
	
	public void clickmouseovermenu() {
	cf.MouseOverMenu(btn_showmenu, "Showmenu Button click");
     cf.MouseOverMenu2(lnk_ntask, "New Task Link  click");	
    }
	public void verifyLogout()
	{
	cf.IsElementDisplay(lnk_Logout,"Logout link display  succesfully ");
	}
	public void clicklogout()
	{
		cf.ClickElement(lnk_Logout,"Logout link click  succesfully");
	}
	public void clickNewLead()
	   {
			cf.ClickElement(lnk_Newlead,"NewLead  link clicked successfully");
		  
		 
	   }
	public void clickNewPotential()
	   {
			cf.ClickElement(lnk_NewPotential,"NewPotential  link clicked successfully");
		  
		 
	   }
	public void clickaccount()
	   {
			cf.ClickElement(lnk_NewAccounts,"Account  link clicked successfully");
		  
		 
	   }
	

}

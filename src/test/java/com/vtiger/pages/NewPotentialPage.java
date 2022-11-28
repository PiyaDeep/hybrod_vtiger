package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class NewPotentialPage extends HeaderPage{
	public NewPotentialPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//td[text()='Potential Name:']")
	WebElement tex_potentialname1;
	@FindBy(name="account_name")
	WebElement tex_accname;
	@FindBy(xpath="//select[@name='opportunity_type']")
	WebElement drp_opportinity;
	
	@FindBy(xpath="//select[@name='leadsource']")
	WebElement drp_lsource;
	
	@FindBy(name="description")
	WebElement txt_description;
	@FindBy(xpath="//*[@id='jscal_field_closingdate']")
	WebElement dtp_date;
	@FindBy(name="sales_stage")
	WebElement drp_salessatge;
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn_save;
	@FindBy(xpath="//input[@name='btn1']")
	WebElement btn_change;
	@FindBy(name="potentialname")
	WebElement tex_potentialname;
	@FindBy(xpath="//a[contains(text(),'vtiger')]")
	WebElement lnk_change;;
	public void AccountSavePotetial(String ptltname,String oprtunty,String source,String descptn,String stage1)//main funcation
	{   setpotentialname(ptltname);
	setaccname();
	setoprtunity(oprtunty);
		
	setsource(source);
	setdescription(descptn);
	//setdate(dte);
	setstage(stage1);
	clicksavepotential();
		
		
	}
	
	public void setpotentialname(String ptltname)
	{
		
		cf.EnterValue(tex_potentialname, ptltname, ptltname+"Enter Potential Name  field");
		
	}
	public void setaccname()
	{
		cf.ClickElement(btn_change, "chnge button click");

		cf.Getwindowhandle(lnk_change,  "Enter Account Name  field");
		
	}
	public void setoprtunity(String oprtunty)
	{
		
		cf.SelectDropdownValue(drp_opportinity, oprtunty, oprtunty+"select Account Name  field");
		
	}
	public void setsource(String source)
	{
		
		cf.SelectDropdownValue(drp_lsource, source, source+"select Source  field");
		
	}
	public void setdescription(String descptn)
	{
		
		cf.EnterValue(txt_description, descptn, descptn+"Enter Description  field");
		
	}
	/*public void setdate(String dte)
	{
		
		cf.EnterValue(dtp_date, dte, dte+"Select Date  field");
		
	}*/
	public void setstage(String stage1)
	{
		
		cf.SelectDropdownValue(drp_salessatge, stage1, stage1+"select stage   field");
		
	}
	public void clicksavepotential()
	{
		
		cf.ClickElement(btn_save, "Potential data save succefully");
		
	}
	public void varifiedpotentialsave()
	{
		//return txt_errormsg.isDisplayed();
		cf.IsElementDisplay(tex_potentialname1,"Potential Name validate");
		
		
	}
}

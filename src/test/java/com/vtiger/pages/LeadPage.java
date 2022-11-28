package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;


public class LeadPage extends HeaderPage{
	public LeadPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
		// pagefactory webelement locators
		@FindBy(name="salutationtype")
		WebElement tb_salutationtype;
		@FindBy(name="firstname")
		WebElement tb_fname;
		@FindBy(name="lastname")
		WebElement tb_lname;
		@FindBy(name="company")
		WebElement tb_cmp;
		@FindBy(name="button")
		   WebElement btn_button;
		@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
		 WebElement btn_cancelbutton;
		@FindBy(xpath="//td[text()='First Name:'  ]")
		WebElement tex_fname;
		public void setsalutation(String saluty)
		{
			cf.SelectDropdownValue(tb_salutationtype, saluty, "Select drop down value");
			//Select drop = new Select(tb_salutationtype);
		 //  drop.selectByIndex(1); 
			
		}
		
		public void NewLaedSave(String leadfname,String leadlname,String leadlcmp,String saluty )//main funcation
		{
			setLeadfname(leadfname);
			setLeadlname(leadlname);
			setLeadcmp(leadlcmp);
			setsalutation(saluty);
			Clicksave();
			
			
		}
		public void NewLaedCancel(String leadfname,String leadlname,String leadlcmp,String saluty )//main funcation
		{
			setLeadfname(leadfname);
			setLeadlname(leadlname);
			setLeadcmp(leadlcmp);
			setsalutation(saluty);
			ClickCancel();
			
			
		}
		public void Mandatorycompanyname(String leadfname,String leadlname,String saluty )//main funcation
		{
			setLeadfname(leadfname);
			setLeadlname(leadlname);
			setsalutation(saluty);
			Clicksave();
			Alertfnamesave();
			
			
		}
		public void Mandatorylname(String leadfname,String saluty )//main funcation
		{
			setLeadfname(leadfname);
			
			setsalutation(saluty);
			Clicksave();
			Alertfnamesave();
			
			
		}
		public void setLeadfname(String leadfname)
		{
			
			cf.EnterValue(tb_fname, leadfname,leadfname+"Enter Lead First Name   field");
			
		}
		public void setLeadlname(String leadlname)
		{
			cf.EnterValue(tb_lname, leadlname,leadlname+"Enter Lead Last Nmae  field");
			
		}
		public void setLeadcmp(String leadlcmp)
		{
			
			cf.EnterValue(tb_cmp, leadlcmp,leadlcmp+"Enter Lead Company  field");
			
		}
		public void Clicksave()
		{
			cf.ClickElement(btn_button, "Click to save button");
		}
		public void ClickCancel()
		{
			cf.ClickElement(btn_cancelbutton, "Click to Cancel button");
		}
		public void Alertfnamesave()
		{
			cf.acceptAlert(driver, "Accept alert");
		}
		public void varifiedLeadtext()
		{
			//return txt_errormsg.isDisplayed();
			cf.IsElementDisplay(tex_fname,"Lead homepage   validate");
			
			
		}

		

}

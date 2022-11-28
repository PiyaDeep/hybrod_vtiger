package com.vtiger.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class ActivityPage extends HeaderPage {
	public ActivityPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@name='subject']")
	WebElement tb_subject;
	
	@FindBy(name="date_start")
	WebElement date;
	
	@FindBy(name="time_start")
	WebElement time;
	
	@FindBy(name="parent_type")
	WebElement drp_parent;
	@FindBy(name="parent_name")
	WebElement txt_parentname;
	@FindBy(xpath="//input[@title='Change [Alt+G]']")
	WebElement btn_change;
	@FindBy(name="sendnotification")
	WebElement chk_sendnotifictn;
	@FindBy(name="description")
	WebElement txt_description;
	@FindBy(xpath="//input[@value='T']")
	WebElement btn_user;
	@FindBy(name="due_date")
	WebElement date_due;
	@FindBy(linkText="vtigerCRM Inc")
	WebElement lnt_vtiger;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement btn_save;
	
	public void activitiesSave(String sub,String subdate,String ptype,String dsc,String duedate  )//main funcation
	{
		setsubjectname(sub);
		setdate(subdate);
		setparenttype(ptype);
		setparentname();
		setnfn();
		setdescription(dsc);
		setdudate( duedate);
	
		checkuser();
		clicksaveactivities();
	
	}
	public void setsubjectname(String sub)
	{
		cf.EnterValue(tb_subject, sub, "Subject Enter fieled");
		
		
	}
	public void setdate(String subdate)
	{
		cf.EnterValue(date, subdate, "Date Enter fieled");
		
	}
	public void setdudate(String duedate)
	{
		cf.EnterValue(date_due, duedate, " Duu Date Enter fieled ");
		
	}
	public void setparenttype(String ptype)
	{
		
		cf.SelectDropdownValue(drp_parent, ptype, "Select parent type filed");
		
	}
	public void setparentname()
	{
		cf.ClickElement(btn_change, "chnge button click");
		
        cf.Getwindowhandle(lnt_vtiger,  "click on link");
	}
	public void setnfn()
	{
		cf.ClickElement(chk_sendnotifictn, "notification checked");
	}
	public void setdescription(String dsc)
	{
		cf.EnterValue(txt_description, dsc, "Enter Description field");
	}
	public void checkuser()
	{
	cf.ClickElement(btn_user, "select  user button");
	}
	public void clicksaveactivities() {
	}
	{
		cf.ClickElement(btn_save, "Activities Save Succesfully");
	}

}
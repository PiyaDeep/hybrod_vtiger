package com.vtiger.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.vtiger.pages.AccountPage;
import com.vtiger.pages.ActivityPage;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import com.vtiger.pages.LeadPage;
import com.vtiger.pages.NewPotentialPage;

public class E2E_Test extends BaseTest {
	
	@Test(groups= {"sanity","Regression"})
	public void TC03_CreatNewLead()
	{
		String TCName = "TC03_CreatNewLead";
		logger=extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
	    // lp.Sterrormsg();
		LeadPage newlead=new LeadPage(driver,logger);
		newlead.clickNewLead();
		newlead.NewLaedSave(TestData.get(TCName).get("FirstName"), TestData.get(TCName).get("LastName"), TestData.get(TCName).get("Company"),TestData.get(TCName).get("sal"));
		LeadPage Lead=new LeadPage(driver,logger);
		Lead.varifiedLeadtext();
        extent.flush(); 
	}
	@Test(groups= {"sanity","Regression"})
	public void TC04_CancelNewLead()
	{
		String TCName = "TC04_CancelNewLead";
		logger=extent.createTest(TCName);
		//LoginPage lp = new LoginPage(driver,logger);
		//lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
	    // lp.Sterrormsg();
		LeadPage newlead=new LeadPage(driver,logger);
		newlead.clickNewLead();
		newlead.NewLaedCancel(TestData.get(TCName).get("FirstName"), TestData.get(TCName).get("LastName"), TestData.get(TCName).get("Company"),TestData.get(TCName).get("sal"));
		LeadPage lpp=new LeadPage(driver,logger);
		lpp.varifiedLeadtext();
        extent.flush(); 
	}
	@Test(groups= {"sanity","Regression"})
	public void TC05_CreatNewLead_MAndatory_alertfield()
	{
		String TCName = "TC05_CreatNewLead_MAndatory_alertfield";
		logger=extent.createTest(TCName);
		//LoginPage lp = new LoginPage(driver,logger);
		//lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
	    // lp.Sterrormsg();
		LeadPage newlead=new LeadPage(driver,logger);
		newlead.clickNewLead();
		newlead.Mandatorylname(TestData.get(TCName).get("FirstName"), TestData.get(TCName).get("sal"));
		//newlead.Clicksave();
		//newlead.Alertfnamesave();
		//fname
		newlead.Mandatorycompanyname(TestData.get(TCName).get("FirstName"), TestData.get(TCName).get("LastName"), TestData.get(TCName).get("sal"));
		//newlead.Clicksave();
		//newlead.Alertfnamesave();
		newlead.NewLaedSave(TestData.get(TCName).get("FirstName"), TestData.get(TCName).get("LastName"), TestData.get(TCName).get("Company"),TestData.get(TCName).get("sal"));
		//newlead.Clicksave();
		newlead.varifiedLeadtext();
		
         extent.flush(); 
	}
	@Test(groups= {"sanity","Regression"})
	public void TC06_CreatAccountInfoSave()
	{
		String TCName = "TC06_CreatAccountInfoSave";
		logger=extent.createTest(TCName);
		//LoginPage lp = new LoginPage(driver,logger);
		//lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
	    // lp.Sterrormsg();
		AccountPage ac=new AccountPage(driver,logger);
		ac.clickaccount();
		ac.AccountSave(TestData.get(TCName).get("AccountName"), TestData.get(TCName).get("website"), TestData.get(TCName).get("symbol"), TestData.get(TCName).get("indusry"));
		//ac.ClicksaveAccount();
		ac.varifiedAccounttext();
         extent.flush(); 
	}
	@Test(groups= {"sanity","Regression"})
	public void TC07_varify_newaccount_popupwindow()
	{
		String TCName = "TC07_varify_newaccount_popupwindow";
		logger=extent.createTest(TCName);
		//LoginPage lp = new LoginPage(driver,logger);
		//lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
	    // lp.Sterrormsg();
		AccountPage ac=new AccountPage(driver,logger);
		ac.clickaccount();
		ac.AccountSave(TestData.get(TCName).get("AccountName"), TestData.get(TCName).get("website"), TestData.get(TCName).get("symbol"),  TestData.get(TCName).get("indusry"));
		ac.ClicksaveAccount();
		ac.varifiedchangebuttonpopupwindow();
         extent.flush(); 
	}
	
	@Test(groups= {"smoke","Regression"})
	public void TC08_varify_NewPotential_save()
	{
		String TCName = "TC08_varify_NewPotential_save";
		logger=extent.createTest(TCName);
		//LoginPage lp = new LoginPage(driver,logger);
		//lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password"));
	    // lp.Sterrormsg();
		NewPotentialPage pp=new NewPotentialPage(driver,logger);
		pp.clickNewPotential();
		pp.AccountSavePotetial(TestData.get(TCName).get("potentialname"), TestData.get(TCName).get("opportunitiers"), TestData.get(TCName).get("source"), TestData.get(TCName).get("description"), TestData.get(TCName).get("stage"));
		
		pp.varifiedpotentialsave();
		
         extent.flush(); 
	}
	@Test(groups= {"sanity","Regression"})
	public void TC09_varify_mouseovermenu()
	{
		String TCName = "TC09_varify_mouseovermenu";
		logger=extent.createTest(TCName);
        HeaderPage header=new HeaderPage(driver,logger);
		header.clickmouseovermenu();
		
		
		
         extent.flush(); 
	}
	@Test(groups= {"smoke","Regression"})
	public void TC10_varify_activitysave()
	{
		String TCName = "TC10_varify_activitysave";
		logger=extent.createTest(TCName);
        HeaderPage header=new HeaderPage(driver,logger);
		header.clickmouseovermenu();
		ActivityPage ap=new ActivityPage(driver,logger);
		ap.activitiesSave(TestData.get(TCName).get("subject"), TestData.get(TCName).get("subdate"),TestData.get(TCName).get("ptype"), TestData.get(TCName).get("description"),TestData.get(TCName).get("DeuDate"));
		
         extent.flush(); 
	}

}

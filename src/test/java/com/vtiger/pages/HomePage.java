package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;



public class HomePage extends HeaderPage {
	
	
	//constructor to use initialization
	public HomePage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		
		PageFactory.initElements(driver, this);
		
	}
	// pagefactory webelement locators
	  @FindBy(xpath="//*[text()='My Pipeline']")
	   WebElement map_pipeline;
	  public void verifypipline()
	  {
		  cf.IsElementDisplay(map_pipeline," pipline graph displayed succesfully ");
		  
	  }

}

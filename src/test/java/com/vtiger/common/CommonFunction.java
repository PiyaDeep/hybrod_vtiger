package com.vtiger.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;


public class CommonFunction {

	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest logger;

	public   CommonFunction(WebDriver driver, ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	public void EnterValue(WebElement elm,String value, String details)
	{
		try {
			
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(value);
			logger.pass(details);
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");
	
		}
	}
	
	public void SelectDropdownValue(WebElement elm,String value,String details)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
		Select s=new Select(elm);
		s.selectByVisibleText(value);
		logger.pass(details);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
	}
	

	public void ClickElement(WebElement elm,String details)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.click();
			logger.pass(details);
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
	}
	public void MouseOverMenu(WebElement elm,String details)
	{
		try {
			//wait.until(ExpectedConditions.visibilityOf(elm));
			Actions action=new Actions(driver);
			action.moveToElement(elm).perform();
			//action.click(elm).perform();
			logger.pass(details);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
		
	}
	public void MouseOverMenu2(WebElement elm,String details)
	{
		try {
			//wait.until(ExpectedConditions.visibilityOf(elm));
			Actions action=new Actions(driver);
			action.moveToElement(elm).perform();
			action.click(elm).perform();
			logger.pass(details);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
		
	}
	
	public void Getwindowhandle(WebElement elm,String details)
	{
		try {
			//wait.until(ExpectedConditions.visibilityOf(elm));

			java.util.Set<String> set=driver.getWindowHandles();
			Iterator<String> iter=set.iterator();
			String parentwindow=iter.next();
			String childwindow=iter.next();
			driver.switchTo().window(childwindow);
			elm.click();
			driver.switchTo().window(parentwindow);
			logger.pass(details);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
		
	}
	
	
	public void IsElementDisplay(WebElement elm,String details)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.isDisplayed();
			logger.pass(details);

		
			
		} catch (Exception e)
		{
			
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
	}
	
	
	public void acceptAlert(WebDriver driver,String details)
	{
		try {
			driver.switchTo().alert().accept();
			logger.pass(details);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.fail(e.getMessage()+"<span class='label end-time'><a href='"+getscreenshot()+"'>Screenshot</a></span>");

		}
	}
		public String getscreenshot() 
		{
			DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
			Date d = new Date();
			String str = f.format(d);
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+str+".png";
			//Move image file to new destination
			File DestFile=new File(path);
			//Copy file at destination
			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return path;
			
		}
	}


	


package com.utils;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
public static WebDriver driver;
	
	public static WebDriver selectbrowser(String browser){
		if(browser.equals("firefox")|| browser.equals("FIREFOX")){
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
	        return driver;
		}else if(browser.equals("chrome")||browser.equals("CHROME")){
			System.out.println("Chrome browser");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    return driver;
		}else if(browser.equals("IE")||browser.equals("ie")){
			System.out.println("EDGE Explorer");
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\Driver\\MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
		
	}
    public void implicitwait(int timesec){
    	try{
    		driver.manage().timeouts().implicitlyWait(timesec,TimeUnit.SECONDS);
    	}
    	catch(Throwable error){
			Assert.assertTrue(false);
    }
     }
    	public void Timeout(int timetowait) throws InterruptedException{
    		Thread.sleep(timetowait);
    	}
	 
        public void explicitWait(int expwait,WebElement element){
        	WebDriverWait wait=new WebDriverWait(driver,expwait);
        	wait.until(ExpectedConditions.visibilityOf(element));
        }
        public void seleteDropDownValue(WebElement element, String dropDownValue){
    		Select select = new Select(element);
    	    select.selectByVisibleText(dropDownValue);
    	}
       public void iselementpresent(WebElement element){
    	   try{
    		   if(element.isDisplayed()==true){
        		   element.click();
        	   }   
    		   
    	   }
    	   catch(Exception e){
    		   System.out.println("No such element");
    	   }
    	   
    	    
    	 }
  }
	



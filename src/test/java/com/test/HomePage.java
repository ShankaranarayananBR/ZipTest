package com.test;

import java.sql.Time;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.maintest.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage extends TestBase{
	
	@Given("^Verify if the search bar is displayed$")
	public void verify_if_the_search_bar_is_displayed() throws Throwable {
		WebElement bangalore=getWebElement("Bangalore_selection_popup");
		Actions actions = new Actions(driver);
        actions.moveToElement(bangalore).click().perform();
        Timeout(3000);
		WebElement SearchElement=getWebElement("Search_bar");
		Timeout(3000);
		iselementpresent(SearchElement);
		
	  }
	@When("^Searching for Koramangala$")
	public void searching_for_Koramangala() throws Throwable {
	    getWebElement("Search_bar").sendKeys("Kor");
	    Timeout(5000);
	    WebElement iframe=getWebElement("i_frame");
	    driver.switchTo().frame(iframe);
	    Timeout(5000);
	    getWebElement("Autosuggest").click();
	    
	    
	    
	    
	    
	    
	}
     
	@Then("^Clicking on the filter icon$")
	public void clicking_on_the_filter_icon() throws Throwable {
		WebElement filter=getWebElement("Filter_click");
		explicitWait(5,filter);
		Actions actions= new Actions(driver);
	    actions.moveToElement(filter).click().perform();
	}
	
}

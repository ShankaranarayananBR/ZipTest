package com.test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.maintest.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class FirstTest extends TestBase{
	
	@Before
	public void initiate() throws Exception{
		init();
	}
    
	@After
	public void teardown(Scenario scenario) throws Exception{
		if(scenario.isFailed()){
			final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
          scenario.embed(screenshot, "image/png");
		}
		Timeout(2000);
		//closeBrowser();
	}
}

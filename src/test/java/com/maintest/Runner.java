package com.maintest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty","html:target/html","json:cucumber.json"},
		features={"src/main/java/project/features"},
		glue={"com/test"},
		monochrome=true
		
		
		)


public class Runner {

}

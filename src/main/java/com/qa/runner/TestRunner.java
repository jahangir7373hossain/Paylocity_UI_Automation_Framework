package com.qa.runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = ".//src//main//java//com//qa//features//PaylocityBenefitsDashbordPositive.feature",
		glue= {"com.qa.stepDefination"},
		monochrome = true,
		strict = true,
		dryRun = false
		
		)
public class TestRunner {
	

}

package com.GSD.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {".//FeatureFiles/"}, 
		glue = "stepDefinitions", 
		plugin = {"pretty","html:reports/report.html"},
		dryRun=false,
		monochrome=true
		
		)

public class testRunner {

}

//This is the testNG runner file which is used to implement the functionalities of GSD app using TestNG framework
package com.GSD.testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features= {".//FeatureFiles/"}, 
		glue = "com.GSD.stepDefinitions", 
		plugin = {"pretty","html:reports/report.html","rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false,
		monochrome=true
		)
public class testNGRunner extends AbstractTestNGCucumberTests{

}

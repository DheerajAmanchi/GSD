//This is implementation of login.feature file
package com.GSD.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.GSD.utils.baseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.GSD.pageObjects.loginPage;
import com.GSD.pageObjects.beCognizantPage;
import com.GSD.passwordEncryption.*;

public class loginSteps {

	static loginPage lp ;
	static beCognizantPage bcp;
	
	@Given("user opens beCognizant portal")
	public void user_opens_be_cognizant_portal() {
		lp = new loginPage(baseClass.getDriver());

	   
	    
	}
	
	@When("user enters valid username")
	public void user_entered_valid_username() {
		try {
			
			lp.sendUserName(baseClass.getProperties().getProperty("email"));
			lp.clickNext();
			

		}
		catch(Exception e) {
			
		}
	
	
	}
	
	@When("user enters valid password")
	public void user_entered_valid_password() {
		
		try {
			
			lp.sendPassword(passwordEncrypt.dePass);
			lp.clickSignIn();
			
			
			lp.clickYes();			
		}
		catch(Exception e) {

		}
	}
	@Then("check if the home page of beCognizant is opening or not")
	public void check_if_the_home_page_of_be_cognizant_is_opening_or_not() {
		bcp  = new beCognizantPage(baseClass.getDriver());
		try {
			WebElement menu = bcp.waitForMenubar();		
		    Assert.assertEquals(menu.isDisplayed(), true); 
		}
		catch(Exception e) {
			
		}
	}

	@Then("user should see user account details")
	public void user_should_see_user_account_details() {

		
		try {
		

	    bcp.clickAccButton();
	    
	    
	    Assert.assertEquals(bcp.accName.isDisplayed(), true);
		}
		catch(Exception e){
			System.out.println("user details cannot be seen");
		}
	    
	}
}

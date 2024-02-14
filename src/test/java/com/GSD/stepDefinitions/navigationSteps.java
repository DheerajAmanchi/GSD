//This is the implementation of navigation.feature file
package com.GSD.stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

import com.GSD.utils.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.GSD.pageObjects.*;


public class navigationSteps {

	static beCognizantPage bcp;
	static oneCognizantPage ocp;
	static GSDPage gp;
	static String elem;
	static String[] uname;
	static int noOfQueries;
	WebElement oneC;
	
	@Given("user is on beCognizant page")
	public void user_is_on_be_cognizant_page() {

		bcp = new beCognizantPage(baseClass.getDriver());
		
		
	}


	@When("click on the oneCognizant")
	public void click_on_the_one_cognizant() {
		
	
		bcp.clickOneCogButton();
	}

	@Then("verify oneCognizant page is opened")
	public void verify_one_cognizant_page_is_opened() {
		
		ocp = new oneCognizantPage(baseClass.getDriver());
      
        
		ocp.windowHandling();
		

        Assert.assertEquals(ocp.oneCTitle.isDisplayed(), true);
        
      
	}

	@When("user enters value: {string} in search box")
	public void user_enters_value_in_search_box(String search) {

		ocp.sendSearchValue(search);
	}

	@When("click on GSD app")
	public void click_on_gsd_app() {
	    

	    ocp.clickGsdButton();
	}

	@Then("verify GSD page is opened")
	public void verify_gsd_page_is_opened() {
		
		gp = new GSDPage(baseClass.getDriver());
		
		gp.switchTOIframe();
		
		
		System.out.println(gp.GSDTitle.getText());
		Assert.assertEquals(gp.GSDTitle.isDisplayed(), true);
		
	}
	
	@Then("verify welcome message is displayed")
	public void verify_welcome_message_is_displayed() throws InterruptedException {
		
		String welcomeTxt = gp.getWelcomeText();
		if(welcomeTxt.equalsIgnoreCase("Welcome Dheeraj")) {
			Assert.assertTrue(true);
		}
		else if (welcomeTxt.equalsIgnoreCase("Bem vindo (a) Dheeraj")) {
			Assert.assertTrue(true);
		}
		

	}

	

	
	@When("select the language: {string}")
	public void select_the_language(String language) throws InterruptedException {
		
		gp.clickLanguageDD();
        
	    gp.setLanguage(language);
	    
	    
	    
	}

	@When("select the country available")
	public void select_the_country_available() throws InterruptedException{
		
		gp.clickCountryDD();
		
		String rSCountry = gp.setCountry();
		System.out.println(rSCountry);

		String countrySelected = gp.getCountrySelected(rSCountry).getText();
		System.out.println(countrySelected);

		Assert.assertEquals(countrySelected, rSCountry);
		
	
	


	}
	
	
	@Then("click on a random tile")
	public void click_on_a_random_tile() {
		
//		List<WebElement> tiles = new ArrayList<>();
//		tiles = driver.findElements(By.xpath("/html/body/div[2]/main/div[2]/div/div[5]/div/div/div/div/div[2]/div/div"));
		Random rand = new Random();
		int rn = rand.nextInt(gp.tiles.size());
		System.out.println(gp.tiles.size());
		gp.tiles.get(rn).click();
		
		gp.clickBackToTiles();;
	}
	
	@When("user checks for the presence of query options")
	public void count_the_query_types()
	{
		int numberOfQueryTitle =gp.queryheaders.size();
		Boolean flag=false;
		System.out.println(numberOfQueryTitle);
		if(numberOfQueryTitle>0)
			flag=true;
		Assert.assertTrue(flag);
	}
	@Then("count the number of queries that are available on the gsd app")
	public void count_and_store_available_options()
	{
		List<WebElement> query= new ArrayList<WebElement>();
		query = gp.queries;
		noOfQueries=query.size();
		System.out.println(noOfQueries);
	}

	@Then("store the description in excel that appears when hovering over each query")
	public void validate_and_store_the_descriotion_of_each_query() throws IOException
	{
		gp.storingMetadata();
	}
	
	@When("user clicks on ticket status")
	public void user_clicks_on_ticket_status() throws InterruptedException {
		
		gp.clickTicketStatusButton();
		
	}
	@Then("click on show all tickets")
	public void click_on_show_all_tickets() {
		
		gp.clickOnShowAllTickets();
		
	}
	
	@Then("count the number of tickets created")
	public void count_the_number_of_tickets_created(){
		
		System.out.println(gp.countNoOfTicketsRaised());
	}
	@AfterMethod
	@Then("navigate to gsd homepage")
	public void navigate_to_gsd_homepage() {
		
		gp.navigateToGSDPage();
	}
		

}

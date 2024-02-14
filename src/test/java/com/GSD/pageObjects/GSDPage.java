package com.GSD.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GSD.utils.*;

public class GSDPage extends basePage {

	public GSDPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@id=\"appFrame\"]")								//Finding the WebElement iframe
	WebElement iframe;
	
	@FindBy(xpath="/html/body/nav[1]/div/a/span")						//Finding the WebElement GSDTitle
	public WebElement GSDTitle;
	
	@FindBy(xpath="/html/body/nav[1]/div/form/div[3]")					//Finding the WebElement welcomeText
	WebElement welcomeText;
	
	
	
	@FindBy(xpath="//*[@class=\"d-flex ms-auto\"]/div[1]/a")			//Finding the WebElement languageDD dropdown
	WebElement languageDD;
	
	@FindBy(xpath="/html/body/nav[1]/div/form/div[1]/ul")				//Finding the WebElement languageMenu
	WebElement languageMenu;
	
	@FindBy(xpath="/html/body/nav[1]/div/form/div[1]/ul/li/a")			//Finding the list of WebElements languageList
	List<WebElement> languagesList;
	
	@FindBy(xpath="/html/body/nav[1]/div/form/div[1]/a/span")			//Finding the WebElement languageSelected
	WebElement languageSelected;
	
	@FindBy(xpath="/html/body/nav[1]/div/form/div[2]/a")				//Finding the WebElement countryDD dropdown
	WebElement countryDD;
	
	@FindBy(xpath="/html/body/nav[1]/div/form/div[2]/ul")				//Finding the WebElement countryMenu
	WebElement countryMenu;
	
	@FindBy(xpath="/html/body/nav[1]/div/form/div[2]/ul/li/a")			//Finding the list of WebElements countriesList
	List<WebElement> countriesList;
	
	@FindBy(xpath="/html/body/nav[1]/div/form/div[2]/a/span")			//Finding the WebElement countrySelected
	WebElement countrySelected;
	
	@FindBy(xpath="/html/body/div[2]/main/div[2]/div/div[5]/div/div/div/div/div[2]/div/div")
	public List<WebElement> tiles;										//Finding the list of WebElements tiles
	
	@FindBy(xpath="(//*[@class='nav-link chat_gsd'])[1]")				//Finding the WebElement ticketStatusButton
	WebElement ticketStatusButton;
	
	@FindBy(xpath="(//*[@class='showMore btncursor showTwo'])[2]")		//Finding the WebElement allTicketsButton
	WebElement allTicketsButton;
	
	@FindBy(xpath="//*[@class='ticket_summary']")						//Finding the list of WebElements ticketSummaries
	List<WebElement> ticketSummaries;
	
	@FindBy(xpath="//div[@class='col-sm-12 col-md-12 tile-inner-header']")
	public List<WebElement> queryheaders;								//Finding the list of WebElements queryheaders
	
	@FindBy(xpath="//div[@class='col-md-12 application-tiles']")		//Finding the list of WebElements queries
	public List<WebElement> queries;
	
	@FindBy(id="back_button")											//Finding the WebElement backToTiles
	WebElement backToTiles;
	
	@FindBy(id="botFaqOl")
	WebElement tickets;
	
	
	public void switchTOIframe() {										//Method for switching to an iframe
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
	}
	
	public String getWelcomeText() throws InterruptedException {		//Method to get the text present in the welcomeText WebElement 
		
		Thread.sleep(25000);

	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(welcomeText));
		String welcomeTxt = welcomeText.getText();

		return welcomeTxt;

	}
	
	public void clickTicketStatusButton() {								//Method to click on the ticketStatus button
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",ticketStatusButton);
	}
	
	public void clickOnShowAllTickets() {								//Method to click on Show all tickets
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(allTicketsButton));
		
		allTicketsButton.click();
	}
	
	public int countNoOfTicketsRaised() {								//Method used to count the no of tickets raised
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(ticketSummaries));
		
		return ticketSummaries.size();
	}
	
	public void navigateToGSDPage(){									// Method for navigating back to GSD page
		
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(welcomeText));
		
	}
	
	public void clickLanguageDD() {										//Method to click on language dropdown
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", languageDD);
		
	}
	
	public void setLanguage(String lang) {								//Method to set the language
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(languageMenu));
		for(int i=0; i<languagesList.size(); i++) {
			if(lang.equalsIgnoreCase(languagesList.get(i).getText())) {
				
				languagesList.get(i).click();
				
				break;
			}
		}
		
		
	}
	
	public void clickCountryDD() {										//Method to click on country dropdown
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		if(languageSelected.getText().equalsIgnoreCase("English")) {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()=\"Global\"])[1]")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", countryDD);
		}
		
		else {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()=\"Brazil\"])[1]")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", countryDD);
		}
		
		
	}
	
	public String setCountry() {										//Method to set the country
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(countryMenu));
		Random rand = new Random();
		int rn = rand.nextInt(countriesList.size());
		wait.until(ExpectedConditions.elementToBeClickable(countriesList.get(rn)));
		String rSCountry = countriesList.get(rn).getText();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",countriesList.get(rn));
		return rSCountry;
	}
	
	public WebElement getCountrySelected(String rSCountry) {			//Method to get the selected country
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.textToBePresentInElement(countrySelected, rSCountry));
		return countrySelected;
		
	}
	
	public void clickBackToTiles() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(tickets));
		backToTiles.click();
	}
	
	public void storingMetadata() throws IOException {					//Method used to store the metadata in excel file
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target elements
		int index = 0;
		for(WebElement query: queries) {
			index++;
			excelUtils.createRow(System.getProperty("user.dir")+"/src/test/resources/GSDAppData.xlsx","Sheet1",index,3,"");
    		excelUtils.setCellData(System.getProperty("user.dir")+"/src/test/resources/GSDAppData.xlsx","Sheet1",index,0,Integer.toString(index));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement temp= driver.findElement(By.xpath("(//div[@class=\"col-md-12 application-tiles\"])["+index+"]"));
			String queryText=temp.getText();

			excelUtils.setCellData(System.getProperty("user.dir")+"/src/test/resources/GSDAppData.xlsx","Sheet1",index,1,queryText);
		    action.moveToElement(temp).perform();
		    String toolTip=temp.getAttribute("data-bs-original-title");
			excelUtils.setCellData(System.getProperty("user.dir")+"/src/test/resources/GSDAppData.xlsx","Sheet1",index,2,toolTip);

	}

	}
	


}

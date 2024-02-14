package com.GSD.pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class oneCognizantPage extends basePage {

	public oneCognizantPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//div[@id='divHomepageContainer']/div[1]/div[1]/div[2]/div[1]/div")
	public WebElement beCogNews;										//Finding the WebElement beCogNews
	
	@FindBy(xpath="//div[@id='DesktopPlatformBar']/nav[1]/div/a[2]")	//Finding the WebElement oneCTitle
	public WebElement oneCTitle;
	
	@FindBy(id="oneC_searchAutoComplete")								//Finding the WebElement search
	WebElement search;
	
	@FindBy(xpath="//div[@id='newSearchAppsLST']/div/div/div[2]")		//Finding the WebElement gsdButton
	WebElement gsdButton;
	
	@FindBy(xpath="//*[@id='dkuserName']")								//Finding the WebElement elem
	WebElement elem;
	
	public String getFullUserName() {									//Method to get the full username
		String userFullName = elem.getText();
		return userFullName;
	}
	
	public void sendSearchValue(String searchval) {						//Method to pass the value into searchbar
		
		
		
		search.sendKeys(searchval);
		
		
	}
	
	public void clickGsdButton() {										//Method to click on GSDButton														
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		gsdButton.click();
	}
	
	public void windowHandling() {										//Method for handling the multiple windows
		//find current window handle
				String parentWinHandle = driver.getWindowHandle(); 

		        Set<String> winHandles = driver.getWindowHandles();
		        
		        String childWinHandle = "";
		        // Iterate over the handles to find the child window
		        for (String handle : winHandles) 
		        {
		            if (!handle.equals(parentWinHandle)) 
		            {
		                childWinHandle = handle;
		                break;
		            }
		        }
		        //Switch to child window handle
		        driver.switchTo().window(childWinHandle);
		        
		        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
				wait.until(ExpectedConditions.visibilityOf(beCogNews));
		        
		        
	}


}

package com.GSD.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class beCognizantPage extends basePage {

	public beCognizantPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@role='menubar']")							//Finding the WebElement menubar 
	public WebElement menubar;
	

	
	By settings = By.xpath("//*[@id=\"O365_MainLink_Settings\"]");	//Finding settings using By
	
	@FindBy(id="O365_MainLink_Me")									//Finding the WebElement accButton
	WebElement accButton;
	
	@FindBy(id="mectrl_currentAccount_primary")						//Finding the WebElement accName
	public WebElement accName;
	
	By acName = By.id("mectrl_currentAccount_primary");				//Finding acName using By
	

	
	@FindBy(xpath="//div[@title='OneCognizant']")					//Finding the WebElement oneCognizantButton
	WebElement oneCogButton;
	
	public void clickAccButton() {									//Method to click on ACCButton
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(settings));
		accButton.click();

	    wait.until(ExpectedConditions.visibilityOfElementLocated(acName));
	}
	
	public void clickOneCogButton() {								//Method to click on OneCognizant Button
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.a_a_beed2cf1.c_a_beed2cf1.e_a_beed2cf1').scrollTop=900");
		js.executeScript("arguments[0].click();", oneCogButton);

	}
	public WebElement waitForMenubar() {							//Method used to wait  for the menubar to appear
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement menu = wait.until(ExpectedConditions.visibilityOf(menubar));
		return menu;
	}
}

package com.GSD.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

	public loginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@type='email']")							//Finding the WebElement username
	WebElement username;
	
	@FindBy(xpath="//*[@type='submit']")						//Finding the WebElement next
	WebElement next;
	
	@FindBy(xpath="//*[@type='password']")						//Finding the WebElement password
	WebElement password;
	
	@FindBy(xpath="//*[@value='Sign in']")						//Finding the WebElement signin
	WebElement signin;
	
	@FindBy(xpath="//*[@value='Yes']")							//Finding the WebElement yes
	WebElement yes;  //remember me after sign in 
	
	public void sendUserName(String uname) {					//Method for passing the username 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		username.sendKeys(uname);
	}
	
	public void clickNext() {									//Method for clicking next button
		next.click();
	}
	
	public void sendPassword(String pass) {						//Method for passing the password
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		password.sendKeys(pass);
	}
	
	public void clickSignIn() {									//Method for clicking signin button
		signin.click();
	}
	
	public void clickYes() {									//Method for clicking yes button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		yes.click();
	}

}

package com.nopcommerce.admindemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	// declaration
			@FindBy(id =  "Email") 
				private WebElement emailId;
			
			@FindBy(id = "Password") 
			private WebElement password;
			
			@FindBy(xpath = "//*[text()='Log in']") 
			private WebElement loginButton;
			
			// initilization
			
			public LandingPage (WebDriver driver) {
				PageFactory.initElements(driver, this);
				
			}
			public void
			enterAdminEmail(String EmailAddress) {
				emailId.clear();
				emailId.sendKeys(EmailAddress);
			}
			public void
			enterAdminPassword(String pass) {
				password.clear();
				password.sendKeys(pass);
			}
			
			public void
			clickOnLoginButton() {
				loginButton.click();
			}
}

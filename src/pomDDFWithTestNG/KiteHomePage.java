package pomDDFWithTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class KiteHomePage {
	
	// declaration
				@FindBy(xpath = "//*[@class=\"avatar\"]") 
					private WebElement profileName;
				
				@FindBy(xpath = "//*[@class=\"user-id\"]")
				private WebElement menuButton;
				
				@FindBy(xpath = "//*[@class=\"icon icon-exit\"]")
				private WebElement logoutButton;

				
				// initilization
				
				public KiteHomePage (WebDriver driver) {
					PageFactory.initElements(driver, this);
					
				}
				
				public void
				veryfyKiteHomePageProfileName(String expected ) {
					
					String actual = profileName.getText();
					Assert.assertEquals(actual, expected);
					Reporter.log("User navigated to right page", true);
					
				}
				
				public void 
				verifyProfileMenuButton() {
					Assert.assertTrue(menuButton.isEnabled());
					Reporter.log("Profile Menu button is enabled", true);
					
				}
				
				public void
				clickOnProfileMenuButton() {
					menuButton.click();
				}
				
				public void
				verifyLogoutButton() {
					Assert.assertTrue(logoutButton.isEnabled());
					Reporter.log("Logout button is enabled", true);
				}
				
				public void
				clickOnLogoutButton() {
					logoutButton.click();
				}

}

package pomDDFWithTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class KiteLoginPage1 {
	String kitePage1Title;
	
	// declaration
		@FindBy(xpath = "//*[@id=\"userid\"]") 
			private WebElement UN;
		@FindBy(xpath = "//*[@id=\"password\"]")
		private WebElement PWD;
		
		@FindBy(xpath = "//*[@class=\"button-orange wide\"]")
		private WebElement login;
		
		private WebDriver driver;
		
		
		// initilization
		
		public KiteLoginPage1 (WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
//		public void
//		verifyPageTitle(String expectedTitle) {
//			kitePage1Title = driver.getTitle();
//			Assert.assertEquals(kitePage1Title, expectedTitle);
//			Reporter.log("User land on correct page",true);
//		}
		
		
		public void
		setKiteLoginPage1Username(String userName) {
			UN.sendKeys(userName);
		}
		
		public void
		setKiteLoginPage1Password(String password) {
			PWD.sendKeys(password);
		}
		
		public void
		clickKiteLoginPage1LoginButton() {
			login.click();
		}
		

}

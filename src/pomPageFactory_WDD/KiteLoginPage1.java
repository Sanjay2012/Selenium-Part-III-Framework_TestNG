package pomPageFactory_WDD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage1 {
	
	// declaration
		@FindBy(xpath = "//*[@id=\"userid\"]") 
			private WebElement UN;
		@FindBy(xpath = "//*[@id=\"password\"]")
		private WebElement PWD;
		
		@FindBy(xpath = "//*[@class=\"button-orange wide\"]")
		private WebElement login;
		
		
		// initilization
		
		public KiteLoginPage1 (WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
		
		public void
		setKiteLoginPage1Username() {
			UN.sendKeys("KW0610");
		}
		
		public void
		setKiteLoginPage1Password() {
			PWD.sendKeys("Shiv@123");
		}
		
		public void
		clickKiteLoginPage1LoginButton() {
			login.click();
		}
		

}

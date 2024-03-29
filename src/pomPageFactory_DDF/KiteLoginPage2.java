package pomPageFactory_DDF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage2 {
	
	// declaration
			@FindBy(xpath = "//*[@id=\"pin\"]") 
				private WebElement PIN;
			@FindBy(xpath = "//*[@class=\"button-orange wide\"]")
			private WebElement UN;

			
			
			// initilization
			
			public KiteLoginPage2 (WebDriver driver) {
				PageFactory.initElements(driver, this);
				
			}
			
			
			public void
			setKiteLoginPage2Pin(String pinValue) {
				PIN.sendKeys(pinValue);
			}
			
			
			public void
			clickKiteLoginPage2ContinueButton() {
				UN.click();
			}

}

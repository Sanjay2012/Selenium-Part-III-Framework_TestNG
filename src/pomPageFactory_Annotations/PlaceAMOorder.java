package pomPageFactory_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceAMOorder {
	// declaration
			@FindBy(xpath = "//*[contains(text(),'ASHOKLEY')]") 
				private WebElement symbol;
			
			@FindBy(xpath = "//*[@class=\"button-blue buy\"]")
			private WebElement buyButton;
			
			@FindBy(xpath = "//*[@class=\"button-orange wide\"]")
			private WebElement login;
			
			
			// initilization
			
			public PlaceAMOorder (WebDriver driver) {
				PageFactory.initElements(driver, this);
				
			}
			
			
			
			

}

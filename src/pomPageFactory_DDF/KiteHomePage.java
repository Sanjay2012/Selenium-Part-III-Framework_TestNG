package pomPageFactory_DDF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
	
	// declaration
				@FindBy(xpath = "//*[@class=\"avatar\"]") 
					private WebElement profileName;

				
				// initilization
				
				public KiteHomePage (WebDriver driver) {
					PageFactory.initElements(driver, this);
					
				}
				
				public void
				veryfyKiteHomePageProfileName(String expected ) {
					
					String actual = profileName.getText();
					
					if (actual.equals(expected)) {
						
						System.out.println("PASS");
						
					}
					
					else {
						System.out.println("FAIL");
					}
					
				}

}

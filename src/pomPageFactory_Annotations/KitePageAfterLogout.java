package pomPageFactory_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class KitePageAfterLogout {
	
	// declaration

	@FindBy(className = "avatar")
	private WebElement profileName;
	private WebDriver driver;

	// initilization

	public KitePageAfterLogout(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void verifyProfileNameAfterLogout(String expected) {
		String actual = profileName.getText();
		Assert.assertEquals(actual, expected);

//		if (actual.equals(expected)) {
//
//			System.out.println("Logout Succesfully");
//
//		}
//
//		else {
//			System.out.println("Log out failed");
//		}

	}
	
	
	public void
	VerifyPageTitleAfterLogout(String expectedTitle) {
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
//		if (actualTitle.equals(expectedTitle)) {
//			
//			System.out.println("PASS");
//			
//		}
//		
//		else {
//			System.out.println("FAIL");
//		}
		
		
		
	}

}

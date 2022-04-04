package pomDDFWithTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class KitePageAfterLogout {
	String kiteLogoutPageTitle;
	
	// declaration

	@FindBy(className = "avatar")
	private WebElement profileName;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	private WebElement PWD;
	
	@FindBy(xpath = "//*[@class=\"remove text-xxsmall\"]")
	private WebElement changeUserLink;
	
	private WebDriver driver;

	// initilization

	public KitePageAfterLogout(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;

	}
	

	public void verifyProfileNameAfterLogout(String expected) {
		String actual = profileName.getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Correct User",true);

	}
	
	
	public void
	VerifyPageTitleAfterLogout(String expectedTitle) {
		kiteLogoutPageTitle=driver.getTitle();
		Assert.assertEquals(kiteLogoutPageTitle, expectedTitle);
		Reporter.log("Correct page title",true);
	
	}
	
	public void clickOnChangeUser() {
		changeUserLink.click();
	}

}

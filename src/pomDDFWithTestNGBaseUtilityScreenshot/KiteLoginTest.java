package pomDDFWithTestNGBaseUtilityScreenshot;

import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class KiteLoginTest extends BaseClass {
	public KiteLoginPage1 login1;
	public KiteLoginPage2 login2;
	public KiteHomePage home;
	public KitePageAfterLogout logout;
	SoftAssert soft = new SoftAssert();

	@BeforeMethod
	public void loginApp() throws EncryptedDocumentException, IOException {

		// calling methods from POM class -- KiteLoginPage1
		login1 = new KiteLoginPage1(driver);

		login1.setKiteLoginPage1Username(Utility.getTestData(1, 0));
		login1.setKiteLoginPage1Password(Utility.getTestData(1, 1));

		login1.clickKiteLoginPage1LoginButton();

		// cllaing methods from page2

		login2 = new KiteLoginPage2(driver);
		login2.setKiteLoginPage2Pin(Utility.getTestData(1, 2));
		login2.clickKiteLoginPage2ContinueButton();

	}

	@Test(description = "This TC will verify Profile Name on dashboard")
	public void verifyProfileName() throws EncryptedDocumentException, IOException {
		// calling methods from home page class
		home = new KiteHomePage(driver);
		String actResult = home.veryfyKiteHomePageProfileName();
		String expResult = Utility.getTestData(1, 4);
		soft.assertEquals(actResult, expResult);
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();
		logout=new KitePageAfterLogout(driver);
		logout.clickOnChangeUser();
		soft.assertAll();
		
	}
		
		@Test(description = "This TC will verify status of Profile Menu Button")
		public void verifyProfileMenuButton() {
			home = new KiteHomePage(driver);
		//assert profile menu button
		boolean menuButtonStatus = home.verifyProfileMenuButton();
		soft.assertTrue(menuButtonStatus);
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();
		logout=new KitePageAfterLogout(driver);
		logout.clickOnChangeUser();
		soft.assertAll();
		
		}
		
		@Test(description = "This TC will verify status of logout Button")
		public void verifyLogoutButton() {
			home = new KiteHomePage(driver);
		// assert logout button
		home.clickOnProfileMenuButton();
		boolean logoutButtonStatus = home.verifyLogoutButton();
		soft.assertTrue(logoutButtonStatus);
		home.clickOnLogoutButton();
		logout=new KitePageAfterLogout(driver);
		logout.clickOnChangeUser();
		soft.assertAll();	
		
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure (ITestResult testResult) throws IOException  {
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			Utility.captureScreenshot(driver,testResult.getName());
			
}
		
	}
	
	
}
		
		

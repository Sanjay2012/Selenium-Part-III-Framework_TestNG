package pomDDFWithTestNGBaseClassUtilityClass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KiteLoginTest extends BaseClass {
	public KiteLoginPage1 login1;
	public KiteLoginPage2 login2;
	public KiteHomePage home;
	public KitePageAfterLogout logout;

	@BeforeMethod
	public void loginApp() throws EncryptedDocumentException, IOException {

		// calling methods from POM class -- KiteLoginPage1
		login1 = new KiteLoginPage1(driver);

		login1.setKiteLoginPage1Username(Utility.getTestData(1,0));
		login1.setKiteLoginPage1Password(Utility.getTestData(1,1));

		login1.clickKiteLoginPage1LoginButton();

		// cllaing methods from page2

		login2 = new KiteLoginPage2(driver);
		login2.setKiteLoginPage2Pin(Utility.getTestData(1,2));

		login2.clickKiteLoginPage2ContinueButton();

	}

	@Test(description="This TC will verify Profile Name on dashboard")
	public void verifyProfileName() throws EncryptedDocumentException, IOException {
		// calling methods from home page class

		home = new KiteHomePage(driver);
		home.veryfyKiteHomePageProfileName(Utility.getTestData(1,3));
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();
	}

@Test(description="This TC will verify Profile Menu Button Status")
	public void verifyProfileMenuEnabled() {
		home = new KiteHomePage(driver);
		home.verifyProfileMenuButton();
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();

	}

	@Test(description="This TC will verify Logout Button status")
	public void verifyLogoutButtonStatus() {
		home = new KiteHomePage(driver);
		home.clickOnProfileMenuButton();
		home.verifyLogoutButton();
		home.clickOnLogoutButton();
	}
	
	@Test(description="This TC will verify page title and profile name after Logout")
	public void verifyLogoutPageTitle() throws EncryptedDocumentException, IOException {
		
		home = new KiteHomePage(driver);
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();
		
		logout = new KitePageAfterLogout(driver);
		logout.verifyProfileNameAfterLogout(Utility.getTestData(1,3));
		logout.VerifyPageTitleAfterLogout("Kite - Zerodha's fast and elegant flagship trading platform");
		
	}

	@AfterMethod
	public void goBackToLoginPage()  {
		
		logout = new KitePageAfterLogout(driver);
		logout.clickOnChangeUser();
		
	}

}

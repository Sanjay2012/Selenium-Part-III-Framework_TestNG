package pomDDFWithTestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KiteLoginTest {

	WebDriver driver;
	Sheet sh;
	KiteLoginPage1 login1;
	KiteLoginPage2 login2;
	KiteHomePage home;
	KitePageAfterLogout logout;
	String pageTitle;

	@BeforeClass
	public void oprnBrowser() throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Dell\\eclipse-workspace\\Selenium Part-III Junit Framework\\Contents\\testdata.xlsx");
		sh = WorkbookFactory.create(file).getSheet("DDF");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");

		driver = new ChromeDriver(options);

		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		login1 = new KiteLoginPage1(driver);
		login2 = new KiteLoginPage2(driver);
		home = new KiteHomePage(driver);
		logout = new KitePageAfterLogout(driver);

	}

	@BeforeMethod
	public void loginApp() {

		// calling methods from POM class -- KiteLoginPage1
		login1 = new KiteLoginPage1(driver);

		String UN = sh.getRow(1).getCell(0).getStringCellValue();
		login1.setKiteLoginPage1Username(UN);

		String PWD = sh.getRow(1).getCell(1).getStringCellValue();
		login1.setKiteLoginPage1Password(PWD);

		login1.clickKiteLoginPage1LoginButton();

		// cllaing methods from page2

		login2 = new KiteLoginPage2(driver);
		String PIN = sh.getRow(1).getCell(2).getStringCellValue();
		login2.setKiteLoginPage2Pin(PIN);

		login2.clickKiteLoginPage2ContinueButton();

	}

	@Test
	public void verifyProfileName() {
		// calling methods from home page class

		home = new KiteHomePage(driver);

		String PN = sh.getRow(1).getCell(3).getStringCellValue();
		home.veryfyKiteHomePageProfileName(PN);
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();
	}

@Test
	public void verifyProfileMenuEnabled() {
		home = new KiteHomePage(driver);
		home.verifyProfileMenuButton();
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();

	}

	@Test
	public void verifyLogoutButtonStatus() {
		home = new KiteHomePage(driver);
		home.clickOnProfileMenuButton();
		home.verifyLogoutButton();
		home.clickOnLogoutButton();
	}
	
	@Test
	public void verifyLogoutPageTitle() {
		
		home = new KiteHomePage(driver);
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();
		
		logout = new KitePageAfterLogout(driver);
		String PN = sh.getRow(1).getCell(3).getStringCellValue();
		logout.verifyProfileNameAfterLogout(PN);
		//String title = sh.getRow(1).getCell(4).getStringCellValue();
		logout.VerifyPageTitleAfterLogout("Kite - Zerodha's fast and elegant flagship trading platform");
		
	}

	@AfterMethod
	public void goBackToLoginPage()  {
		
		logout = new KitePageAfterLogout(driver);
		logout.clickOnChangeUser();
		

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}

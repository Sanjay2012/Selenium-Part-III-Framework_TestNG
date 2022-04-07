package testNG.Parameter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");

	    driver = new ChromeDriver();

		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@BeforeMethod
	@Parameters({"username", "password", "PIN"})
	public void loginToApp(String username, String password, String PIN) throws EncryptedDocumentException, IOException {
		driver.findElement(By.xpath("//*[@id=\"userid\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@class=\"button-orange wide\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"pin\"]")).sendKeys(PIN);
		driver.findElement(By.xpath("//*[@class=\"button-orange wide\"]")).click();
		
	}
	
	@Test
	@Parameters({"profileName"})
	public void verifyProfileName(String profileName) throws EncryptedDocumentException, IOException {
		String expected = driver.findElement(By.xpath("//*[@class=\"avatar\"]")).getText();
		Assert.assertEquals(profileName, expected);
	}
	
	@AfterMethod
	public void logoutFromApp() {
		driver.findElement(By.xpath("//*[@class=\"user-id\"]")).click();
		driver.findElement(By.xpath("//*[@class=\"icon icon-exit\"]")).click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}

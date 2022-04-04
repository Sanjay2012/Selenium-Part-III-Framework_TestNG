package pomDDFWithTestNGBaseClassUtilityClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	public void setupApplication() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		Reporter.log("=====Browser Session Started=====", true);
		driver = new ChromeDriver(options);

		driver.get("https://kite.zerodha.com/");
		Reporter.log("=====Application Started=====", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);
		
	}

}

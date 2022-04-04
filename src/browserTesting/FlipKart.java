package browserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlipKart {
	WebDriver driver;
	@Parameters("browser")
	
	@Test
	public void TC(String browser) throws InterruptedException {
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
			
		}
		
		else if (browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//Drivers/msedgedriver.exe");
			 driver = new EdgeDriver();
			
		}
		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.quit();
	}
	
	

}

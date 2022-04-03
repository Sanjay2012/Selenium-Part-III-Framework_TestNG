package pomPageFactory_WDD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KiteLoginTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		// calling methods from POM class -- KiteLoginPage1
		KiteLoginPage1 login1= new KiteLoginPage1(driver);
		login1.setKiteLoginPage1Username();
		login1.setKiteLoginPage1Password();
		login1.clickKiteLoginPage1LoginButton();
		
		
		// cllaing methods from page2
		
		KiteLoginPage2 login2= new KiteLoginPage2(driver);
		login2.setKiteLoginPage2Pin();
		login2.clickKiteLoginPage2ContinueButton();
		
		
		// calling methods from home page class
		
		KiteHomePage home=new KiteHomePage(driver);
		home.veryfyKiteHomePageProfileName();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	
		
	}
	
	
	

}

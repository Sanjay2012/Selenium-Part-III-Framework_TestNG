package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WDDF {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");

	       WebDriver driver=new ChromeDriver();
		
		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		// enter UN
		driver.findElement(By.id("userid")).sendKeys("KW0610");
		
		// enter pwd
		
		driver.findElement(By.id("password")).sendKeys("Shiv@123");
		
		// click on login button
		
		driver.findElement(By.xpath("//*[text()='Login ']")).click();
		
		// enter pin
		
		driver.findElement(By.id("pin")).sendKeys("152022");
		
		// click on continue 
		
		driver.findElement(By.xpath("//*[text()='Continue ']")).click();
		
		String actual = driver.findElement(By.xpath("//*[text()='KW0610']")).getText();
		
		String expected="KW0610";
		
		if (actual.equals(expected)) {
			
			System.out.println("PASS");
			
		}
		
		else {
			System.out.println("FAIL");
		}
		
		
		// move to desired symbol
		WebElement symbol = driver.findElement(By.xpath("//*[contains(text(),'ASHOKLEY')]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(symbol).perform();
		
		driver.findElement(By.xpath("//*[@class=\"button-blue buy\"]")).click();
		
		driver.findElement(By.xpath("//*[text()='AMO']")).click();
		
		driver.findElement(By.xpath("//*[@label=\"Qty.\"]")).sendKeys("100");
		
		
		 WebElement orderType = driver.findElement(By.xpath("//*[@name=\"orderType\"]"));
		    executor.executeScript("arguments[0].checked=true", orderType);
		    
		driver.findElement(By.xpath("//*[@class=\"submit\"]")).click();
		
		
		
		//driver.quit();

	}

}

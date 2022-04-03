package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDF {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Selenium Part-III Junit Framework\\Contents\\testdata.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");

	       WebDriver driver=new ChromeDriver();
		
		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// enter UN
		String UN = sh.getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.id("userid")).sendKeys(UN);
		
		// enter pwd
		String PWD = sh.getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.id("password")).sendKeys(PWD);
		
		// click on login button
		
		driver.findElement(By.xpath("//*[text()='Login ']")).click();
		
		// enter pin
		String PIN = sh.getRow(1).getCell(2).getStringCellValue();
		driver.findElement(By.id("pin")).sendKeys(PIN);
		
		// click on continue 
		
		driver.findElement(By.xpath("//*[text()='Continue ']")).click();
		
		String actual = driver.findElement(By.className("avatar")).getText();
		
		String expected=sh.getRow(1).getCell(3).getStringCellValue();
		
		if (actual.equals(expected)) {
			
			System.out.println("PASS");
			
		}
		
		else {
			System.out.println("FAIL");
		}
		
		driver.quit();

	}

}

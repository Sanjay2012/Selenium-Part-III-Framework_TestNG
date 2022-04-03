package pomPageFactory_DDF;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KiteLoginTest {
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Selenium Part-III Junit Framework\\Contents\\testdata.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notification");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		// calling methods from POM class -- KiteLoginPage1
		KiteLoginPage1 login1= new KiteLoginPage1(driver);
		String UN=sh.getRow(1).getCell(0).getStringCellValue();
		login1.setKiteLoginPage1Username(UN);
		
		String PWD=sh.getRow(1).getCell(1).getStringCellValue();
		login1.setKiteLoginPage1Password(PWD);
		
		login1.clickKiteLoginPage1LoginButton();
		
		
		// cllaing methods from page2
		
		KiteLoginPage2 login2= new KiteLoginPage2(driver);
		String PIN=sh.getRow(1).getCell(2).getStringCellValue();
		login2.setKiteLoginPage2Pin(PIN);
		
		login2.clickKiteLoginPage2ContinueButton();
		
		
		// calling methods from home page class
		
		KiteHomePage home=new KiteHomePage(driver);
		
		String PN=sh.getRow(1).getCell(3).getStringCellValue();
		home.veryfyKiteHomePageProfileName(PN);
		
		Thread.sleep(5000);
		
		driver.quit();
		
	
		
	}
	
	
	

}

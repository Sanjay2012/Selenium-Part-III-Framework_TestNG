package testNG;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Annotationns {
	
	
	
	@BeforeClass
	public void openBrowser() {
		System.out.println("open Browser");
		Reporter.log("open Browser", true);
	}
	
	@BeforeMethod
	public void loginToApp() {
		System.out.println("login To App---");
	}

	@Test
	public void TC1() {
		System.out.println("running TC1---");
		Reporter.log("TC1 passed", false);
	}

	@Test
	public void TC2() {
		System.out.println("running TC2---");
		Reporter.log("TC2 passed", true);
	}

	@AfterMethod
	public void logoutFromApp() {
		System.out.println("logout From App---");
	}
	
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("close Browser");
	}

}

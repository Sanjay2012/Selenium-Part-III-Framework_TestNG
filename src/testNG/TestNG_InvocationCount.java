package testNG;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_InvocationCount {
	@BeforeClass
	public void openBrowser() {
		Reporter.log("open Browser", true);
	}
	
	
	@Test()
	public void EmailLogin() {
		Reporter.log("Login into Account", true);
	}
	
	@Test(dependsOnMethods = "EmailLogin", invocationCount = 10)
	public void ComposeEmail() {
		Reporter.log("Email Compose", true);
	}
	
	@Test(dependsOnMethods = "ComposeEmail")
	public void LogoutAccount() {
		Reporter.log("Logout From Account", true);
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("close Browser");
	}

}

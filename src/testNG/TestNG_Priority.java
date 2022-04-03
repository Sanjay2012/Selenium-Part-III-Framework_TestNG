package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNG_Priority {

	/*
	 * TestNG Keyword: 1. invocationCount 2. priority 3. enabled 4. TimeOut 5.
	 * dependsOnMethods
	 */

	/*
	 * Single test class may contain multiple test methods. To execute each tewst
	 * method we need to write @Test annotation
	 */

	@Test(priority = -1)
	public void CreateAccount() {
		Reporter.log("Create Account", true);
	}
	
	@Test(priority = 0)
	public void EditAccount() {
		Reporter.log("Edit Account", true);
	}
	
	@Test(priority = 1)
	public void DeleteAccount() {
		Reporter.log("Delete Account", true);
	}
	
	
	/*if test method priority is duplicate then only execution will happens on alphabetical order*/

}

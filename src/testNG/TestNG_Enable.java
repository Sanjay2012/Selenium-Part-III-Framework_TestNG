package testNG;

import static org.testng.Assert.assertFalse;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNG_Enable {
	
	@Test()
	public void Test1() {
		Reporter.log("Test1", true);
	}
	
	@Test(enabled = false)
	public void Test2() {
		Reporter.log("Test2", true);
	}
	
	@Test()
	public void Test3() {
		Reporter.log("Test3", true);
	}
	
	@Test(enabled = false)
	public void Test4() {
		Reporter.log("Test4", true);
	}
	
	@Test()
	public void Test5() {
		Reporter.log("Test5", true);
	}

}

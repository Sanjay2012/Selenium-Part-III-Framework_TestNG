package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FailedTest {
	
	@Test(timeOut = 8000)
	public void Test1() throws InterruptedException {
		Thread.sleep(5000);
		Reporter.log("Test1", true);
	}
	
	@Test()
	public void Test2() {
		Reporter.log("Test2", true);
	}
	
	@Test(timeOut = 8000)
	public void Test3() throws InterruptedException {
		Thread.sleep(5000);
		Reporter.log("Test3", true);
	}
	
	@Test(timeOut = 8000)
	public void Test4() throws InterruptedException {
		Thread.sleep(5000);
		Reporter.log("Test4", true);
	}
	
	@Test(timeOut = 8000)
	public void Test5() throws InterruptedException {
		Thread.sleep(5000);
		Reporter.log("Test5", true);
	}

}

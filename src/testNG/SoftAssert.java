package testNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SoftAssert {
	@Test
	public void Test1() {
		String s1="Hi";
		String s2="Hello";
		String s3="Hello";
		String s4=null;
		
		
		Reporter.log("Verify AssertEqual method", true);;
		Assert.assertEquals(s3, s2);
		
		Reporter.log("Verify AssertEqual method", true);
		Assert.assertEquals(s1, s2);
	
		Reporter.log("Verify AssertNotEqual method", true);
		Assert.assertNotEquals(s2, s1);
				
		Reporter.log("Verify AssertNotEqual method", true);
		Assert.assertNotEquals(s3, s2);
				
		Reporter.log("Verify AssertTrue method", true);
		Assert.assertTrue(s2==s3);
		
		Reporter.log("Verify AssertTrue method", true);
		Assert.assertTrue(s1==s2);
		
		Reporter.log("Verify AssertFalse method");
		Assert.assertFalse(s2==s3);
		
		Reporter.log("Verify AssertFalse method");
		Assert.assertFalse(s1==s2);
		
		Reporter.log("Verify AssertNull method");
		Assert.assertNull(s3);
		
		Reporter.log("Verify AssertNull method");
		Assert.assertNull(s4);
		
		Reporter.log("Verify AssertNotNull method");
		Assert.assertNotNull(s3);
		
		Reporter.log("Verify AssertNotNull method");
		Assert.assertNotNull(s4);
		
		Reporter.log("forcefully fail test", true);
		Assert.fail();

		
	}
}

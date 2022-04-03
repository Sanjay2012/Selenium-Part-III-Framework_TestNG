package testNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Verification {
	@Test
	public void Test1() {
		Reporter.log("Verify AssertEqual method");
		String s1="Hi";
		String s2="Hello";
		
		Assert.assertEquals(s1, s2);   // fail
		
	}
	@Test
	public void Test2() {
		Reporter.log("Verify AssertEqual method");;
		String s2="Hello";
		String s3="Hello";

		Assert.assertEquals(s3, s2);  //pass
		
	}
	
	@Test
	public void Test3() {
		Reporter.log("Verify AssertNotEqual method");
		String s1="Hi";
		String s2="Hello";
		
		Assert.assertNotEquals(s2, s1); //pass
				
	}
	
	@Test
	public void Test4() {
		Reporter.log("Verify AssertNotEqual method");
		String s2="Hello";
		String s3="Hello";
		Assert.assertNotEquals(s3, s2); // fail
				
	}
	
	@Test
	public void Test5() {
		Reporter.log("Verify AssertTrue method");
		String s2="Hello";
		String s3="Hello";
		
		Assert.assertTrue(s2==s3);  // pass
		
		
	}
	
	@Test
	public void Test6() {
		Reporter.log("Verify AssertTrue method");
		String s1="Hi";
		String s2="Hello";
		
		Assert.assertTrue(s1==s2);  //fail
		
		
	}
	
	@Test
	public void Test7() {
		Reporter.log("Verify AssertFalse method");
		String s2="Hello";
		String s3="Hello";
		
		Assert.assertFalse(s2==s3); // fail
		
	}
	
	@Test
	public void Test8() {
		Reporter.log("Verify AssertFalse method");
		String s1="Hi";
		String s2="Hello";
		
		Assert.assertFalse(s1==s2); //pass
		
	} 
	
	@Test
	public void Test9() {
		Reporter.log("Verify AssertNull method");
		String s3="Hello";
		
		Assert.assertNull(s3);  //fail
		
	}
	
	@Test
	public void Test10() {
		Reporter.log("Verify AssertNull method");
		String s4=null;
		
		Assert.assertNull(s4);  //pass
		
	}
	
	@Test
	public void Test11() {
		Reporter.log("Verify AssertNotNull method");

		String s3="Hello";
		Assert.assertNotNull(s3);  //pass
		
	}
	
	@Test
	public void Test12() {
		Reporter.log("Verify AssertNotNull method");
		String s4=null;
		
		Assert.assertNotNull(s4); //fail
		
	}
	
	
	@Test
	public void Test13() {
		Reporter.log("forcefully fail test", true);
		Assert.fail();   // fail
		
	}
	
	@Test(dependsOnMethods = "Test13")
	public void Test14() {
		Reporter.log("Method should skipped", true);
		Assert.fail();   // skip
		
	}



}

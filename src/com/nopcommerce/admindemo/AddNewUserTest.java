package com.nopcommerce.admindemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.utility.RandomString;

public class AddNewUserTest {
	
public static void main(String[] args) throws InterruptedException {
	
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// calling login page class
		
		LandingPage login=new LandingPage(driver);
		login.enterAdminEmail("admin@yourstore.com");
		login.enterAdminPassword("admin");
		login.clickOnLoginButton();
		
		
		// call dashboardPage class
		
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.verifyPageTitle("Dashboard");
		dashboard.clickOnCustomerMenu();
		dashboard.clickOnCustomerMenuItem();
		
		// calling addcustomer class
		
		CustomerPage cust=new CustomerPage(driver);
		String str = RandomString.make(4);
		String emailAddress = "Shiv" + str + "@gmail.com";
		String firstName = "Shiv" + str;
		String lastName = "Kumar" + str;
		String password = str + "@123";
		
		System.out.println(emailAddress);
		System.out.println(password);
		System.out.println(firstName);
		System.out.println(lastName);
		
		cust.clickOnAddButton();
		cust.setEmail(emailAddress);
		cust.setPassword(password);
		cust.setFirstName(firstName);
		cust.setLastName(lastName);
		cust.setGender("Male");
		cust.setDOB("1/30/1990");
		cust.setCompany("Made Easy Pvt. ltd");
		cust.setAdminComment("Test add new customer flow");
		cust.clickOnSaveButton();
		
		
		// calling Customer list class
		CustomerListPage custList=new CustomerListPage(driver);
		custList.verifySuccessMessage("The new customer has been added successfully.");
		//custList.enterEmail(emailAddress);
		//custList.clickOnSearchButton();
		//custList.searchCustomerByEmail(emailAddress);\
		custList.searchCustomerByEmailInTable(emailAddress);
		
}


}

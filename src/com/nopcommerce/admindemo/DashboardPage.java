package com.nopcommerce.admindemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	// declaration

	@FindBy(xpath = "//*[@class=\"content-header\"]")
	private WebElement pageTitle;
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement customerMenu;
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	private WebElement customerMenuItem;

// initialization

public DashboardPage (WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}


	public void verifyPageTitle(String expected) {
		String actual=pageTitle.getText();
		if (actual.equals(expected)) {
			
			System.out.println("User land on correct page");
			
		}
		
		else {
			System.out.println("User land on wrong page");
		}
	}

	public void clickOnCustomerMenu() {
		customerMenu.click();
	}

	public void clickOnCustomerMenuItem() {
		customerMenuItem.click();
	}

}

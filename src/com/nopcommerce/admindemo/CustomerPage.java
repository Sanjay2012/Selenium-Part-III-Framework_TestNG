package com.nopcommerce.admindemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

	// declaration

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement addButton;
	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailId;
	@FindBy(xpath = "//input[@name='Password']")
	private WebElement password;
	@FindBy(xpath = "//input[@name='FirstName']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@id='Gender_Male']")
	private WebElement male;
	@FindBy(xpath = "//input[@id='Gender_Female']")
	private WebElement female;
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	private WebElement date;
	@FindBy(xpath = "//input[@id='Company']")
	private WebElement companyName;
	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	private WebElement taxExemptedCheck;
	@FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
	private WebElement customerRole;
	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	private WebElement lstItemAdmin;
	@FindBy(xpath = "//li[contains(.,'Forum Moderators')]")
	private WebElement lstItemForumMod;
	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	private WebElement lstItemGuest;
	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	private WebElement lstItemVendor;
	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	private WebElement lstItemRegister;
	@FindBy(xpath = "//select[@id='VendorId']")
	private WebElement drpmngVenderRole;
	@FindBy(xpath = "//option[@value='0']")
	private WebElement noVenderRoleItem;
	@FindBy(xpath = "//option[@value='1']")
	private WebElement vender1Item;
	@FindBy(xpath = "//option[@value='2']")
	private WebElement venser2Item;
	@FindBy(xpath = "//textarea[@id='AdminComment']")
	private WebElement adminComment;
	@FindBy(xpath = "//button[@name='save']")
	private WebElement saveButton;

	// initilization

	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void clickOnAddButton() {
		addButton.click();
	}

	public void setEmail(String email) {
		emailId.sendKeys(email);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);

	}

	public void setFirstName(String name) {
		firstName.sendKeys(name);

	}

	public void setLastName(String lName) {
		lastName.sendKeys(lName);

	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			male.click();

		} else if (gender.equals("Female")) {
			female.click();

		} else {
			male.click();
		}

	}

	public void setDOB(String DOB) {
		date.sendKeys(DOB);

	}

	public void setCompany(String company) {
		companyName.sendKeys(company);

	}

	public void taxExemptionStatus() {
		taxExemptedCheck.click();

	}

	public void setAdminComment(String comment) {
		adminComment.sendKeys(comment);

	}

	public void clickOnSaveButton() throws InterruptedException {
		Thread.sleep(2000);
		saveButton.click();

	}
}

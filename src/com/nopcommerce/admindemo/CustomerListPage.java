package com.nopcommerce.admindemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerListPage {
	
	// declaration
				@FindBy(xpath =  "//*[@class=\"alert alert-success alert-dismissable\"]") 
					private WebElement successMessage;
				
				@FindBy(id = "SearchEmail") 
				private WebElement searchEmail;
				
				@FindBy(id = "search-customers") 
				private WebElement searchButton;

				@FindBy(xpath = "//*[@id=\"customers-grid\"]") 
				private WebElement table;
				
				@FindBy(xpath = "//*[@id=\"customers-grid\"]/tbody/tr") 
				private List<WebElement> tableRows;
				@FindBy(id = "//*[@id=\"customers-grid\"]/tbody/tr/td") 
				private List<WebElement> tableColumns;
				
				// initilization
				
				public CustomerListPage (WebDriver driver) {
					PageFactory.initElements(driver, this);
					
				}
				public void
				verifySuccessMessage(String expected) {
					String actual=successMessage.getText();
					System.out.println(actual);
					
					if (actual.equalsIgnoreCase(expected)) {
						
						System.out.println("User added successfully");
						
					}
					
					else {
						System.out.println("User not added");
					}
					
				}
				
				public void
				enterEmail(String EmailAddress) {
					searchEmail.sendKeys(EmailAddress);
				}
				
				/*public void
				clickOnSearchButton() {
					searchButton.click();
				}*/
				
				public int getRowCount() {
					return(tableRows.size());
				}
				
				public int getColumnCount() {
					return(tableColumns.size());
				}
				
				
				/*public boolean searchCustomerByEmail(String email) {
					
					boolean flag=false;
					String emailId=table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[2]")).getText();
					System.out.println(emailId);		
					if (emailId.equals(email)) {			
						flag=true;
					}
					
				return flag;
					
				}*/
				
				//----- to search email in table without search button

				public boolean searchCustomerByEmailInTable(String email) {
					
					boolean flag=false;
					
					for (int i = 1; i <=getRowCount(); i++) {
						String emailId=table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
						System.out.println(emailId);
						
						if (emailId.equals(email)) {
							flag=true;
							break;
						}
					}

					return flag;
					

				}

}

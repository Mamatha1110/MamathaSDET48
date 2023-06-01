package com.hrm.hrmProjectObjectRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HRM_Project.GenericUtilities.WebdriverUtility;

/**
 * This class contains webElements and Business Libraries of Admin Dashboard page
 * @author Admin
 *
 */
public class AdminDashboardPage {
	
	WebDriver driver;
	WebdriverUtility wLib;
	
	/**
	 * Locators for elements in Admin dashboard page
	 */
	@FindBy (xpath = "//button[contains(.,'Add Admin')]") private WebElement addAdminbtn;
	@FindBy (xpath = "//label[.='Search:']/input[@type='search']") private WebElement searchTextField;
	
	@FindBy (xpath = "//div[@class='modal fade show']//input[@name='hr_companyid']") private WebElement companyIdTextField;
	@FindBy (xpath = "//div[@class='modal fade show']//input[@name='hr_firstname']") private WebElement firstNameTextField;
	@FindBy (xpath = "//div[@class='modal fade show']//input[@name='hr_lastname']") private WebElement lastNameTextField;
	@FindBy (xpath = "//div[@class='modal fade show']//input[@name='hr_middlename']") private WebElement middleNameTextField;
	@FindBy (xpath = "//div[@class='modal fade show']//input[@name='hr_contactno']") private WebElement contactNoTextField;
	@FindBy (xpath = "//div[@class='modal fade show']//select[@name='hr_type']") private WebElement hrTypeDropdown;
	@FindBy (xpath = "//div[@class='modal fade show']//input[@name='hr_email']") private WebElement eMailTextField;
	@FindBy (xpath = "//div[@class='modal fade show']//input[@name='hr_password']") private WebElement passWordTextField;
	@FindBy (xpath = "//div[@class='modal fade show']//button[.='Save']") private WebElement saveButton;
	@FindBy (xpath = "//div[@class='modal fade show']//button[.='Close']") private WebElement closeButton;
	
	@FindBy (xpath = "//table[@id='example1']/tbody/tr") private List<WebElement> tableRows;
	@FindBy (xpath = "//table[@id='example1']/tbody/tr/td") private List<WebElement> tableData;
	@FindBy (xpath = "//a[.='Next']") private WebElement nextBtn;
	@FindBy (xpath = "//a[.='Previous']") private WebElement previousBtn;
	
	/**
	 * Initialization
	 * @param driver
	 * @param wLib
	 */
		public AdminDashboardPage(WebDriver driver, WebdriverUtility wLib )
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wLib = wLib;
	}
	
	
	// Utilization
	 
	public WebElement getAddAdminbtn() {
		return addAdminbtn;
	}


	public WebElement getSearchTextField() {
		return searchTextField;
	}


	public WebElement getCompanyIdTextField() {
		return companyIdTextField;
	}


	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}


	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}


	public WebElement getMiddleNameTextField() {
		return middleNameTextField;
	}


	public WebElement getContactNoTextField() {
		return contactNoTextField;
	}


	public WebElement getHrTypeDropdown() {
		return hrTypeDropdown;
	}


	public WebElement geteMailTextField() {
		return eMailTextField;
	}


	public WebElement getPassWordTextField() {
		return passWordTextField;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getCloseButton() {
		return closeButton;
	}
	
	public List<WebElement> getTableData() {
		return tableData;
	}


	public WebElement getNextBtn() {
		return nextBtn;
	}

	/**
	 * This method is used to Create an Admin account
	 * @param cmpId
	 * @param fName
	 * @param lName
	 * @param mName
	 * @param contNo
	 * @param type
	 * @param eMail
	 * @param pwd
	 */
	public void createAdmin(String cmpId, String fName, String lName, String mName, String contNo, String type, String eMail, String pwd)
	{
		addAdminbtn.click();
		companyIdTextField.sendKeys(cmpId);
		firstNameTextField.sendKeys(fName);
		lastNameTextField.sendKeys(lName);
		middleNameTextField.sendKeys(mName);
		contactNoTextField.sendKeys(contNo);
		
		int hrType = 1;
		if(type.equalsIgnoreCase("hrhead"))
			hrType = 1;
		else 
		if(type.equalsIgnoreCase("hrofficer"))
			hrType = 2;
		else
		if(type.equalsIgnoreCase("hrassistant"))
		hrType = 3;
		
		wLib.selectElementInDropdown(hrTypeDropdown, hrType);
		eMailTextField.sendKeys(eMail);
		passWordTextField.sendKeys(pwd);
		saveButton.click();
		wLib.switchToAlertPopupAndAccept(driver);
	}
	
	/**
	 * This method is used to Search an admin account
	 * @param text
	 */
	public void serchAdmin(String text)
	{
		searchTextField.sendKeys(text);
		System.out.println(tableRows.size()+" Records found for "+text);
	}
	
	/**
	 * This method is used to edit or modify an admin account information
	 * @param findText
	 * @param field
	 * @param replaceText
	 * @throws Throwable
	 */
	public void modifyAdmin(String findText, String field, String replaceText) throws Throwable
	{
		int count = 0;
		searchTextField.sendKeys(findText);
		
		for (WebElement data : tableData) {
			if(data.getText().equalsIgnoreCase(findText))
			{
				driver.findElement(By.xpath("//td[.='"+findText+"']/../td[1]")).click();
				driver.findElement(By.xpath("//td[@class='child']//i[@title='Edit Employee']")).click();

				if(field.equalsIgnoreCase("companyId"))
				{
					companyIdTextField.clear();
					companyIdTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("firstName"))
				{
					firstNameTextField.clear();
					firstNameTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("lastName"))
				{
					lastNameTextField.clear();
					lastNameTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("middleName"))
				{
					middleNameTextField.clear();
					middleNameTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("contactno"))
				{
					contactNoTextField.clear();
					contactNoTextField.sendKeys(replaceText);	
				}
				else if(field.equalsIgnoreCase("position"))
				{
					int hrType;
					if(replaceText.equalsIgnoreCase("hrhead"))
						hrType = 1;
					else 
					if(replaceText.equalsIgnoreCase("hrofficer"))
						hrType = 2;
					else
						hrType = 3;
					
					wLib.selectElementInDropdown(hrTypeDropdown, hrType);
				}
				count++;
				saveButton.click();
				wLib.switchToAlertPopupAndAccept(driver);
				break;
			}
			if (count==0)
				System.err.println("Record not found");
		}
	}
	
	/**
	 * This method is used to delete an admin account
	 * @param findText
	 */
	public void deleteAdmin(String findText)
	{
		int count = 0;
		searchTextField.sendKeys(findText);
		for (WebElement data : tableData) {
			if(data.getText().equalsIgnoreCase(findText))
			{
				driver.findElement(By.xpath("//td[.='"+findText+"']/../td[1]")).click();
				driver.findElement(By.xpath("//td[@class='child']//i[@title='Delete Employee']")).click();
				driver.findElement(By.xpath("//div[@class='modal fade show']//button[.='Delete']")).click();
				wLib.switchToAlertPopupAndAccept(driver);
				count++;
				break;
			}
		}
		if(count==0)
			System.out.println("No Records found for "+ findText);
	}
	
	public void createAdmin1(HashMap<String, String> fields)
	{
		addAdminbtn.click();
		
		for (Entry<String, String> set : fields.entrySet()) 
		{			
			if(set.getKey().equalsIgnoreCase("hr_type"))
			{
				int hrType = 1;
				if(set.getValue().equalsIgnoreCase("hrhead"))
					hrType = 1;
				else 
				if(set.getValue().equalsIgnoreCase("hrofficer"))
					hrType = 2;
				else
				if(set.getValue().equalsIgnoreCase("hrassistant"))
				hrType = 3;
				
				WebElement dropdownType = driver.findElement(By.xpath("//div[@class='modal fade show']//select[@name='"+set.getKey()+"']"));
				wLib.selectElementInDropdown(dropdownType, hrType);
			}
			else
				driver.findElement(By.xpath("//div[@class='modal fade show']//input[@name='"+set.getKey()+"']")).sendKeys(set.getValue());
		}
		saveButton.click();
		wLib.switchToAlertPopupAndAccept(driver);
	}
}

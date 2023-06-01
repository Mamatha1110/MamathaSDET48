package com.hrm.hrmProjectObjectRepository;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HRM_Project.GenericUtilities.WebdriverUtility;

/**
 * This class contains WebElements and Business Libraries of Employee Dashboard page
 * @author Admin
 *
 */
public class EmployeeDashboardPage {
	
	WebDriver driver;
	WebdriverUtility wLib;

	/**
	 * Locators for WebElements of Employee Dashboard page
	 */
	@FindBy(xpath = "//button[contains(.,'Add Employee')]") private WebElement addEmployeeBtn;
	@FindBy(xpath = "//label[.='Search:']/input[@type='search']") private WebElement searchTextField;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_companyid']") private WebElement companyIdTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_firstname']") private WebElement firstNameTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_lastname']") private WebElement lastNameTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_middlename']") private WebElement middleNameTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_datefrom']") private WebElement branchesDateFromTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_recentdate']") private WebElement branchesRecentDateTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//select[@name='employee_department']") private WebElement departmentDropdown;
	@FindBy(xpath = "//div[@class='modal fade show']//select[@name='employee_branches']") private WebElement branchesDropdown;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_position']") private WebElement positionTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_contact']") private WebElement contactNoTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_sss']") private WebElement sssTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_tin']") private WebElement tinTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_hdmf_pagibig']") private WebElement hdmfPagibigTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_gsis']") private WebElement gsisTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_file201']") private WebElement file201TextField;
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_image']") private WebElement imageTextField;
	@FindBy(xpath = "//div[@class='modal fade show']//button[.='Close']") private WebElement closeBtn;
	@FindBy(xpath = "//div[@class='modal fade show']//button[.='Save']") private WebElement saveBtn;
	@FindBy(xpath = "//div[@class='modal fade show']//button[.='Update']") private WebElement updateBtn;
	
	@FindBy(xpath = "//table[@id='example1']/tbody/tr[@role='row']") private List<WebElement> tableRows;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr[@role='row']/td") private List<WebElement> tableData;
	@FindBy(xpath = "//a[.='Next']") private WebElement nextBtn;
	@FindBy(xpath = "//a[.='Previous']") private WebElement previousBtn;
	
	//Initialization
	public EmployeeDashboardPage(WebDriver driver, WebdriverUtility wLib)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wLib = wLib;
	}

	//Utilization
	public WebDriver getDriver() {
		return driver;
	}

	public WebdriverUtility getwLib() {
		return wLib;
	}

	public WebElement getAddEmployeeBtn() {
		return addEmployeeBtn;
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

	public WebElement getBranchesDateFromTextField() {
		return branchesDateFromTextField;
	}

	public WebElement getBranchesRecentDateTextField() {
		return branchesRecentDateTextField;
	}

	public WebElement getDepartmentDropdown() {
		return departmentDropdown;
	}

	public WebElement getBranchesDropdown() {
		return branchesDropdown;
	}

	public WebElement getPositionTextField() {
		return positionTextField;
	}

	public WebElement getContactNoTextField() {
		return contactNoTextField;
	}

	public WebElement getSssTextField() {
		return sssTextField;
	}

	public WebElement getTinTextField() {
		return tinTextField;
	}

	public WebElement getHdmfPagibigTextField() {
		return hdmfPagibigTextField;
	}

	public WebElement getGsisTextField() {
		return gsisTextField;
	}

	public WebElement getFile201TextField() {
		return file201TextField;
	}

	public WebElement getImageTextField() {
		return imageTextField;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public List<WebElement> getTableRows() {
		return tableRows;
	}

	public List<WebElement> getTableData() {
		return tableData;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getPreviousBtn() {
		return previousBtn;
	}
	
	/**
	 * This method is used to Add an Employee
	 * @param cmpId
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param branchesDateFrom
	 * @param branchesRecentDate
	 * @param department
	 * @param branches
	 * @param position
	 * @param contactNo
	 * @param sss
	 * @param tin
	 * @param hdmf
	 * @param gsis
	 * @param file201
	 * @param image
	 */
	public void addEmployee(String cmpId, String firstName, String lastName, String middleName, String branchesDateFrom, String branchesRecentDate, String department, String branches, String position, String contactNo, String sss, String tin, String hdmf, String gsis, String file201, String image)
	{
		addEmployeeBtn.click();
		
		companyIdTextField.sendKeys(cmpId);
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		middleNameTextField.sendKeys(middleName);
		branchesDateFromTextField.sendKeys(branchesDateFrom);
		branchesRecentDateTextField.sendKeys(branchesRecentDate);
		Select select = new Select(departmentDropdown);
		select.selectByVisibleText(department);
		Select select1 = new Select(branchesDropdown);
		select1.selectByVisibleText(branches);
		positionTextField.sendKeys(position);
		contactNoTextField.sendKeys(contactNo);
		sssTextField.sendKeys(sss);
		tinTextField.sendKeys(tin);
		hdmfPagibigTextField.sendKeys(hdmf);
		gsisTextField.sendKeys(gsis);
		String filePath1 = new File(file201).getAbsolutePath();
		file201TextField.sendKeys(filePath1);
		String imagePath = new File(image).getAbsolutePath();
		imageTextField.sendKeys(imagePath);
		
		saveBtn.click();
		wLib.switchToAlertPopupAndAccept(driver);
	}
	
	/**
	 * This method is used to Search an Employee
	 */
	public void searchEmployee(String findText)
	{
		searchTextField.clear();
		searchTextField.sendKeys(findText);
		System.out.println(tableRows.size()+" Records found");
	}
	
	/**
	 * This method is used to Download Employee details file
	 * @param text
	 */
	public void downloadEmployeeFile(String text)
	{
		int count = 0;
		searchTextField.sendKeys(text);
		for (WebElement data : tableData) {
			if(data.getText().equalsIgnoreCase(text)) 
			{
				driver.findElement(By.xpath("//td[.='"+text+"']/../td[1]")).click();
				driver.findElement(By.xpath("//td[@class='child']//a[@title='Download File 201']")).click();
				System.out.println("File 201 for "+text+" is downloaded");
				count++;
				break;
			}
		}
		if(count==0)
			System.out.println("Record not found");
	}
	
	public void modifyEmployee(String findText, String field, String replaceText, String file201, String image)
	{
		int count = 0;
		searchTextField.sendKeys(findText);
		for (WebElement data : tableData) {
			if(data.getText().equalsIgnoreCase(findText))
			{
				driver.findElement(By.xpath("//td[.='"+findText+"']/../td[1]")).click();
				driver.findElement(By.xpath("//td[@class='child']//i[@title='Edit Employee']")).click();
				
				if(field.equalsIgnoreCase("companyid"))
				{
					companyIdTextField.clear();
					companyIdTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("firstname"))
				{
					firstNameTextField.clear();
					firstNameTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("lastname"))
				{
					lastNameTextField.clear();
					lastNameTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("middlename"))
				{
					middleNameTextField.clear();
					middleNameTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("branchesDateFrom"))
				{
					branchesDateFromTextField.clear();
					branchesDateFromTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("branchesRecentDate"))
				{
					branchesRecentDateTextField.clear();
					branchesRecentDateTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("department"))
				{
					Select select = new Select(departmentDropdown);
					select.selectByVisibleText(replaceText);
				}
				else if(field.equalsIgnoreCase("branches"))
				{
					Select select = new Select(branchesDropdown);
					select.selectByVisibleText(replaceText);
				}				
				else if(field.equalsIgnoreCase("position"))
				{
					positionTextField.clear();
					positionTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("contactno"))
				{
					contactNoTextField.clear();
					contactNoTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("sss"))
				{
					sssTextField.clear();
					sssTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("tin"))
				{
					tinTextField.clear();
					tinTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("hdmf"))
				{
					hdmfPagibigTextField.clear();
					hdmfPagibigTextField.sendKeys(replaceText);
				}
				else if(field.equalsIgnoreCase("gsis"))
				{
					gsisTextField.clear();
					gsisTextField.sendKeys(replaceText);
				}
				
				String filePath = new File(file201).getAbsolutePath();
				file201TextField.sendKeys(filePath);
				String imagePath = new File(image).getAbsolutePath();
				imageTextField.sendKeys(imagePath);
				
				updateBtn.click();
				wLib.switchToAlertPopupAndAccept(driver);
				count++;
				break;
			}
		}
		if(count==0)
			System.out.println("Record not found");
	}

}

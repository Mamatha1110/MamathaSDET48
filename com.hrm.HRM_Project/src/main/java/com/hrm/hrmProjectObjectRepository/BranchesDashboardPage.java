package com.hrm.hrmProjectObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HRM_Project.GenericUtilities.WebdriverUtility;

public class BranchesDashboardPage {

	WebDriver driver;
	WebdriverUtility wLib;
	
	@FindBy (xpath = "//button[contains(.,'Add Branches')]") private WebElement addBranchesBtn;
	@FindBy (xpath = "//label[.='Search:']/input[@type='search']") private WebElement searchTextField;
	@FindBy (xpath = "//div[@class='modal fade show']//input[@name='branches_name']") private WebElement branchesTextField;
	@FindBy (xpath = "//div[@class='modal fade show']//button[.='Save']") private WebElement saveBtn;
	@FindBy (xpath = "//div[@class='modal fade show']//button[.='Cancel']") private WebElement cancelBtn;
	@FindBy (xpath = "//div[@class='modal fade show']//button[.='Update']") private WebElement updateBtn;
	@FindBy (xpath = "//div[@class='modal fade show']//button[.='Delete']") private WebElement deleteBtn;
	@FindBy (xpath = "//table[@id='example1']/tbody/tr[@role='row']") private List<WebElement> tableRows;
	@FindBy (xpath = "//table[@id='example1']/tbody/tr[@role='row']/td") private List<WebElement> tableData;
	@FindBy (xpath = ".//a[.='Next']") private WebElement nextBtn;
	
	//Initialization
	public BranchesDashboardPage(WebDriver driver, WebdriverUtility wLib)
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

	public WebElement getAddBranchesBtn() {
		return addBranchesBtn;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getBranchesTextField() {
		return branchesTextField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
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
		
	/**
	 * This method is used to create Branches
	 * @param corpName
	 */
	public void createBranches(String branchesName)
	{
		addBranchesBtn.click();
		branchesTextField.sendKeys(branchesName);
		saveBtn.click();
		wLib.switchToAlertPopupAndAccept(driver);
	}
	
	public void searchBranches(String text)
	{
		searchTextField.sendKeys(text);
		System.out.println(tableRows.size()+" Records found");
	}
	
	public void modifyBranches(String findText, String replaceText) 
	{
		searchTextField.sendKeys(findText);
		for (WebElement tdata : tableData) {
			if(tdata.getText().equalsIgnoreCase(findText))
			{
				driver.findElement(By.xpath("//table[@id='example1']/tbody/tr/td[.='"+findText+"']/following-sibling::td/button[.='Edit']")).click();
				branchesTextField.sendKeys(replaceText);
				updateBtn.click();
				wLib.switchToAlertPopupAndAccept(driver);
				break;
			}
		}
	}
	
	public void deleteBranches(String findText) 
	{
		searchTextField.sendKeys(findText);
		for (WebElement tdata : tableData) {
			if(tdata.getText().equalsIgnoreCase(findText))
			{
				driver.findElement(By.xpath("//table[@id='example1']/tbody/tr/td[.='"+findText+"']/following-sibling::td/button[.='Delete']")).click();
				deleteBtn.click();
				wLib.switchToAlertPopupAndAccept(driver);
				break;
			}
		}
	}
}

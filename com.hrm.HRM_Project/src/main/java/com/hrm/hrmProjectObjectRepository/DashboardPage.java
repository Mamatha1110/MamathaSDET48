package com.hrm.hrmProjectObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import HRM_Project.GenericUtilities.WebdriverUtility;


/**
 * This class contains WebElements and Business libraries of Dashboard page
 * @author Admin
 *
 */
public class DashboardPage {

	WebdriverUtility wLib;
	WebDriver driver;
	
	/**
	 * Locators for WebElements in Dashoboard page
	 */
	@FindBy(xpath = "//a[@data-toggle='dropdown']") private WebElement userIcon;
	@FindBy(xpath = "//a[@href='log_out.php']") private WebElement logoutBtn;
	@FindBys({@FindBy(xpath="//a[@class='dropdown-item']"), @FindBy(xpath="//a[contains(.,' Account Setting')]")}) public WebElement acntSetting;
	
	@FindBy(xpath = "//p[contains(.,'ADMIN')]") private WebElement adminLink;
	@FindBy(xpath = "//p[.='Add Admin']") private WebElement addAdminOpt;
	
	@FindBy(xpath = "//p[contains(.,'CORPORATE')]") private WebElement corporateLink;
	@FindBy(xpath = "//p[.='Add Corporate']") private WebElement addCorporateOpt;
	
	@FindBy(xpath = "//p[contains(.,'BRANCHES')]") private WebElement branchLink;
	@FindBy(xpath = "//p[.='Add Braches']") private WebElement addBranchOpt;
	
	@FindBy(xpath = "//p[contains(.,'EMPLOYEE')]") private WebElement employeeLink;
	@FindBy(xpath = "//p[.='Add Employee']") private WebElement addEmployeeOpt;

	//Initialization
	
	public DashboardPage(WebDriver driver, WebdriverUtility wLib)
	{
		PageFactory.initElements(driver, this);
		this.wLib = wLib;
		this.driver = driver;
	}

	//Utlization
	
	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getAddAdminOpt() {
		return addAdminOpt;
	}

	public WebElement getCorporateLink() {
		return corporateLink;
	}

	public WebElement getAddCorporateOpt() {
		return addCorporateOpt;
	}

	public WebElement getBranchLink() {
		return branchLink;
	}

	public WebElement getAddBranchOpt() {
		return addBranchOpt;
	}

	public WebElement getEmployeeLink() {
		return employeeLink;
	}

	public WebElement getAddEmployeeOpt() {
		return addEmployeeOpt;
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getAcntSetting() {
		return acntSetting;
	}

	
	/**
	 * This method is used to Logout of the application
	 */
	public void logoutOfApp()
	{
		userIcon.click();
		logoutBtn.click();
		wLib.switchToAlertPopupAndAccept(driver);
	}
	
	/**
	 * This method is used to get into the Employee Dashoboard page
	 */
	public void getEmpDashboardPage()
	{
		employeeLink.click();
		addEmployeeOpt.click();
	}
	
	/**
	 * This method is used to get into the Branches Dashoboard page
	 */
	public void getBranchesDashboardPage()
	{
		branchLink.click();
		addBranchOpt.click();
	}
	
	/**
	 * This method is used to get into the Corporate Dashoboard page
	 */
	public void getCorporateDashboardPage()
	{
		corporateLink.click();
		addCorporateOpt.click();
	}
	
	/**
	 * This method is used to get into the Admin Dashoboard page
	 */
	public void getAdminDashboardPage()
	{
		adminLink.click();
		addAdminOpt.click();
	}
}


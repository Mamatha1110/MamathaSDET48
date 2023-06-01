package com.hrm.hrmProjectObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HRM_Project.GenericUtilities.WebdriverUtility;

/**
 * This class contains WebElements and Business Libraries of Login Page
 * @author Admin
 *
 */
public class LoginPage {

	WebdriverUtility wLib;
	WebDriver driver;
	
	/**
	 * Locators for WebElements of Login page
	 */
		
	@FindBy(name="hr_email") private WebElement usernameTextField;
	@FindBy(name="hr_password") private WebElement passwordTextField;
	@FindBy(id="hr_type") private WebElement typeDropdown;
	@FindBy(name="login_hr") private WebElement loginBtn;
	
	//Initialization
	public LoginPage(WebDriver driver, WebdriverUtility wLib)	
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wLib = wLib;
	}

	//Utilization
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * This metod is used to Login to the Application
	 * @param userName
	 * @param passWord
	 * @param type
	 */
	public void logIntoApp(String userName, String passWord, String type)
	{
		usernameTextField.sendKeys(userName);
		passwordTextField.sendKeys(passWord);
		int hrType;
		if(type.equalsIgnoreCase("hrhead"))
			hrType = 1;
		else 
		if(type.equalsIgnoreCase("hrofficer"))
			hrType = 2;
		else
			hrType = 3;
		
		wLib.selectElementInDropdown(typeDropdown, hrType);
		loginBtn.click();
		wLib.switchToAlertPopupAndAccept(driver);
	}
}

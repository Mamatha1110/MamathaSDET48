package com.hrm.HrHead;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.hrmProjectObjectRepository.CorporateDashboardPage;
import com.hrm.hrmProjectObjectRepository.DashboardPage;
import com.hrm.hrmProjectObjectRepository.LoginPage;

import HRM_Project.GenericUtilities.BaseClass;
import HRM_Project.GenericUtilities.ExcelUtility;
import HRM_Project.GenericUtilities.FileUtility;
import HRM_Project.GenericUtilities.WebdriverUtility;

public class DeleteCorporateAddedByOneHrHeadAsOtherHrHead extends BaseClass {

	@Test (groups = "Delete")
	public void DeleteCorporateAddedByOneHrHeadAsOtherHrHeadTest() throws Throwable 
	{
		dashboardPage.getCorporateDashboardPage();
		CorporateDashboardPage corporateDashboardPage = new CorporateDashboardPage(driver, wLib);
		corporateDashboardPage.createCorporate("Quality");
			
		//Verify whether the new Corporate is created or not
		corporateDashboardPage.searchCorporate("Quality");
		
		//Logout as HR Head
		dashboardPage.logoutOfApp();
						
		//Verify the HR Head account is logged out
		Assert.assertTrue(driver.getCurrentUrl().contains("http://rmgtestingserver/domain/HRM_System/"),"Fail: " +userName + " Account is not Logged out successfully");
		
		//Login as HRhead account: veena@gmail.com
		String userName1 = fLib.getPropertyKeyValue("username1");
		String passWord1 = fLib.getPropertyKeyValue("password1");
		String hrtype1 = fLib.getPropertyKeyValue("type1");	
			
		loginPage.logIntoApp(userName1, passWord1, hrtype1);
			
		//Verify Dashboard page of correct account is displayed or not
		String currentUrl = driver.getCurrentUrl();
		String currentUserId = dashboardPage.getUserIcon().getText();
		Assert.assertTrue(currentUrl.contains("Superadmin_Dashboard") && currentUserId.contains(userName1),"Fail: The Dashboard page of " +userName1+ " account is not displayed");
		
		dashboardPage.getCorporateDashboardPage();
		corporateDashboardPage.deleteCorporate("Quality");
	}
}


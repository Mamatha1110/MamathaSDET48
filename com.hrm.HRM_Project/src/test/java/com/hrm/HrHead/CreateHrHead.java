package com.hrm.HrHead;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.hrmProjectObjectRepository.AdminDashboardPage;
import com.hrm.hrmProjectObjectRepository.DashboardPage;

import HRM_Project.GenericUtilities.BaseClass;
import HRM_Project.GenericUtilities.ListenerImplementationClass;
import HRM_Project.GenericUtilities.RetryAnalyzer;

@Listeners(ListenerImplementationClass.class)
public class CreateHrHead extends BaseClass{
			
@Test (retryAnalyzer = RetryAnalyzer.class, groups = "Smoke")
public void createHrheadTest() throws Throwable
{
	dashboardPage = new DashboardPage(driver,wLib);
	
	//get Admin Dashboard Page
	dashboardPage.getAdminDashboardPage();
		
	String cmpId = eLib.getExcelData("addAdmin", 1, 0);
	String fName = eLib.getExcelData("addAdmin", 1, 1);
	String lName = eLib.getExcelData("addAdmin", 1, 2);
	String mName = eLib.getExcelData("addAdmin", 1, 3);
	String contNo = eLib.getExcelData("addAdmin", 1, 4);
	String type = eLib.getExcelData("addAdmin", 1, 5);
	String eMail = eLib.getExcelData("addAdmin", 1, 6);
	String pwd = eLib.getExcelData("addAdmin", 1, 7);
		
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver, wLib);
		adminDashboardPage.createAdmin(cmpId, fName, lName, mName, contNo, type, eMail, pwd);
		Assert.fail();
		
		//Verify the new HR account is created or not
		adminDashboardPage.serchAdmin(fName);
		
	 	//Logout as HR Head
		dashboardPage.logoutOfApp();
		
		//Verify the HR Head account is logged out
		
		Assert.assertTrue(driver.getCurrentUrl().contains("http://rmgtestingserver/domain/HRM_System/"), "Fail: " +userName + " Account is not Logged out successfully");
		
		//Login with newly created HR Head account
		loginPage.logIntoApp(eMail, pwd, type);
		
		//Verify Dashboard page of correct account is displayed or not
		String newCurrentUrl = driver.getCurrentUrl();
		String newCurrentUserId = dashboardPage.getUserIcon().getText();
	
		Assert.assertTrue(newCurrentUrl.contains("Superadmin_Dashboard") && newCurrentUserId.contains(eMail), "Fail: The Dashboard page of "+eMail+" account is not displayed" );
	}
}

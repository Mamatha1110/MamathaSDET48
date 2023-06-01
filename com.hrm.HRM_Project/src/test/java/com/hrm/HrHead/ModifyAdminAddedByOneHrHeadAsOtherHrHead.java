package com.hrm.HrHead;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.hrmProjectObjectRepository.AdminDashboardPage;

import HRM_Project.GenericUtilities.BaseClass;

public class ModifyAdminAddedByOneHrHeadAsOtherHrHead extends BaseClass {

	@Test (groups = "Modify")
	public void ModifyAdminAddedByOneHrHeadAsOtherHrHeadTest() throws Throwable
	{
		//get Admin Dashboard Page
		dashboardPage.getAdminDashboardPage();
		
		String cmpId = eLib.getExcelData("addAdmin", 2, 0);
		String fName = eLib.getExcelData("addAdmin", 2, 1);
		String lName = eLib.getExcelData("addAdmin", 2, 2);
		String mName = eLib.getExcelData("addAdmin", 2, 3);
		String contNo = eLib.getExcelData("addAdmin", 2, 4);
		String type = eLib.getExcelData("addAdmin", 2, 5);
		String eMail = eLib.getExcelData("addAdmin", 2, 6);
		String pwd = eLib.getExcelData("addAdmin", 2, 7);
		
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver, wLib);
		adminDashboardPage.createAdmin(cmpId, fName, lName, mName, contNo, type, eMail, pwd);
		
		//Verify the HR account is created or not
		adminDashboardPage.serchAdmin(fName);
		
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

		dashboardPage.getAdminDashboardPage();
		adminDashboardPage.modifyAdmin("222", "firstname", "Preran");
	}
}
		
						
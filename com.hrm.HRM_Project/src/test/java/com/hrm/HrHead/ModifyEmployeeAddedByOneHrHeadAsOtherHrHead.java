package com.hrm.HrHead;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.hrmProjectObjectRepository.EmployeeDashboardPage;

import HRM_Project.GenericUtilities.BaseClass;

public class ModifyEmployeeAddedByOneHrHeadAsOtherHrHead extends BaseClass {
@Test (groups = "Modify")
public void ModifyEmployeeAddedByOneHrHeadAsOtherHrHeadTest() throws Throwable 
{
	dashboardPage.getEmpDashboardPage();

	String cmpId = eLib.getExcelData("addEmployee", 1, 0);
	String firstName = eLib.getExcelData("addEmployee", 1, 1);
	String lastName = eLib.getExcelData("addEmployee", 1, 2);
	String middleName = eLib.getExcelData("addEmployee", 1, 3);
	String branchesDateFrom = eLib.getExcelData("addEmployee", 1, 4);
	String branchesRecentDate = eLib.getExcelData("addEmployee", 1, 5);
	String department = eLib.getExcelData("addEmployee", 1, 6);
	String branches = eLib.getExcelData("addEmployee", 1, 7);
	String position = eLib.getExcelData("addEmployee", 1, 8);
	String contactNo = eLib.getExcelData("addEmployee", 1, 9);
	String sss = eLib.getExcelData("addEmployee", 1, 10);
	String tin = eLib.getExcelData("addEmployee", 1, 11);
	String hdmf = eLib.getExcelData("addEmployee", 1, 12);
	String gsis = eLib.getExcelData("addEmployee", 1, 13);
	String file201 = eLib.getExcelData("addEmployee", 1, 14);
	String image = eLib.getExcelData("addEmployee", 1, 15);
		
	EmployeeDashboardPage employeeDashboardPage = new EmployeeDashboardPage(driver, wLib);
	employeeDashboardPage.addEmployee(cmpId, firstName, lastName, middleName, branchesDateFrom, branchesRecentDate, department, branches, position, contactNo, sss, tin, hdmf, gsis, file201, image);
		
	employeeDashboardPage.searchEmployee("444");
	
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

	dashboardPage.getEmpDashboardPage();
	employeeDashboardPage.modifyEmployee("444", "firstname", "Keerthi", file201, image);
}
}

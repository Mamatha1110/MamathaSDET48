package com.hrm.HrHead;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.hrmProjectObjectRepository.CorporateDashboardPage;

import HRM_Project.GenericUtilities.BaseClass;

public class ModifyCorporateAddedByOneHrHeadAsOtherHrHead extends BaseClass {
@Test (groups = "Modify")
public void ModifyCorporateAddedByOneHrHeadAsOtherHrHeadTest() throws Throwable 
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
		corporateDashboardPage.modifyCorporate("Quality","QualityAssurance");
	}
}


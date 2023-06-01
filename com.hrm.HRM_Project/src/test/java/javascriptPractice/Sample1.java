package javascriptPractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hrm.hrmProjectObjectRepository.AdminDashboardPage;
import com.hrm.hrmProjectObjectRepository.DashboardPage;

import HRM_Project.GenericUtilities.BaseClass;

public class Sample1{
	
	//Welcome to Sample program
	
	@Test 
	public void A()
	{
		System.out.println("Test case A");
	}
	
	@Test 
	public void b()
	{
		System.out.println("Test case b");
	}
	
	@Test
	public void c()
	{
		System.out.println("Test case c");
	}
	
	@Test (dependsOnMethods = "b")
	public void D()
	{
		System.out.println("Test case D");
	}
}

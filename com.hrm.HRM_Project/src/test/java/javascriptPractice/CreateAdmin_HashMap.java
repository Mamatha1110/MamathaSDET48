package javascriptPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.hrmProjectObjectRepository.AdminDashboardPage;
import com.hrm.hrmProjectObjectRepository.DashboardPage;
import com.hrm.hrmProjectObjectRepository.LoginPage;

import HRM_Project.GenericUtilities.ExcelUtility;
import HRM_Project.GenericUtilities.FileUtility;
import HRM_Project.GenericUtilities.WebdriverUtility;

public class CreateAdmin_HashMap {
public static void main(String[] args) throws Throwable {
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		WebDriver driver;
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String userName = fLib.getPropertyKeyValue("username");
		String passWord = fLib.getPropertyKeyValue("password");
		String hrtype = fLib.getPropertyKeyValue("type");
		
		//Open the Browser
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		
		else
			driver = new ChromeDriver();

		//Maximize the Browser window
		wLib.maximizeBrowserWindow(driver);		
		//ImplicitlyWait for 10 seconds
		wLib.waitUntilElementIsLocated(driver);		
		
		//Trigger the URL of the Application
		driver.get(URL);
		
		//Login as HR HEAD
		LoginPage loginPage = new LoginPage(driver, wLib);
		loginPage.logIntoApp(userName, passWord, hrtype);
		
		//verify Dashboard page of Hrhead account is displayed or not
		DashboardPage dashboardPage = new DashboardPage(driver, wLib);
		
		String currentUrl = driver.getCurrentUrl();
		String currentUserId = dashboardPage.getUserIcon().getText();
		if(currentUrl.contains("Superadmin_Dashboard") && currentUserId.contains(userName) )
			{
				System.out.println("The Dashboard page of HR Head account is displayed");
			}else
			{
				System.out.println("The Dashboard page of HR Head account is not displayed");
			}
		
		//get Admin Dashboard Page
		dashboardPage.getAdminDashboardPage();
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver, wLib);
		adminDashboardPage.createAdmin1(eLib.getMultipleData("adminHashMap"));
		
		driver.manage().window().minimize();
		driver.quit();
}
}

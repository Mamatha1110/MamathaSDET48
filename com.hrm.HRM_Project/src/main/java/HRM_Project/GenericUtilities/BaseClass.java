package HRM_Project.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.hrm.hrmProjectObjectRepository.DashboardPage;
import com.hrm.hrmProjectObjectRepository.LoginPage;

public class BaseClass {

	public static WebDriver sDriver;
	public WebDriver driver = null;
	
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebdriverUtility wLib = new WebdriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public JavaScriptUtility jsLib = new JavaScriptUtility(driver);
	
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	
	
	public String BROWSER;
	public String URL;
	public String userName;
	public String passWord;
	public String hrtype;
	
	@BeforeSuite (groups = {"Smoke","Modify"})
	public void config_BS()
	{
		System.out.println("-- Before Suite --");
	}
	
	@AfterSuite (groups = {"Smoke","Modify"})
	public void config_AS()
	{
		System.out.println("-- After Suite --");
	}
	
//	@Parameters ("BROWSER")
	@BeforeClass (groups = {"Smoke","Modify"})
	public void config_BC() throws Throwable
	{
		BROWSER = fLib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		
		else
			driver = new ChromeDriver();
		
		wLib.maximizeBrowserWindow(driver);
		wLib.waitUntilElementIsLocated(driver);
		sDriver = driver;
	} 
	
	@AfterClass (groups = {"Smoke","Modify"})
	public void config_AC()
	{
		wLib.minimizeBrowserWindow(driver);
		driver.quit();
	}
	
	@BeforeMethod (groups = {"Smoke","Modify"})
	public void config_BM() throws Throwable
	{
		dashboardPage = new DashboardPage(driver,wLib);
		URL = fLib.getPropertyKeyValue("url");
		userName = fLib.getPropertyKeyValue("username");
		passWord = fLib.getPropertyKeyValue("password");
		hrtype = fLib.getPropertyKeyValue("type");
		
		driver.get(URL);
		loginPage = new LoginPage(driver, wLib);
		loginPage.logIntoApp(userName, passWord, hrtype);
		
		String currentUserId = dashboardPage.getUserIcon().getText();
		
		Assert.assertTrue(currentUserId.contains(userName), "Fail: The Dashboard page of " +userName+ " account is not displayed");
	}
	
	@AfterMethod (groups = {"Smoke","Modify"})
	public void config_AM()
	{
		DashboardPage dashboardPage = new DashboardPage(driver, wLib);
		dashboardPage.logoutOfApp();
	}
}
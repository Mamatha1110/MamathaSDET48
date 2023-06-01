package javascriptPractice;

import java.time.Duration;
import java.util.List;

import javax.swing.JList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.hrmProjectObjectRepository.DashboardPage;
import com.hrm.hrmProjectObjectRepository.EmployeeDashboardPage;
import com.hrm.hrmProjectObjectRepository.LoginPage;

import HRM_Project.GenericUtilities.ExcelUtility;
import HRM_Project.GenericUtilities.FileUtility;
import HRM_Project.GenericUtilities.JavaScriptUtility;
import HRM_Project.GenericUtilities.WebdriverUtility;

public class handleEmployeeTable {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
				
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
		
		dashboardPage.getEmpDashboardPage();
		EmployeeDashboardPage employeeDashboardPage = new EmployeeDashboardPage(driver, wLib);
		
		JavaScriptUtility jsLib = new JavaScriptUtility(driver);
		int count=0;
		WebElement nextBtn = employeeDashboardPage.getNextBtn();
		WebElement previousBtn = employeeDashboardPage.getPreviousBtn();
		List<WebElement> tableRows = employeeDashboardPage.getTableRows();
		List<WebElement> tableData = employeeDashboardPage.getTableData();
		String expectedText = "1123";
	
			for( ; ; )
			{
				for(int i=0; i<tableData.size(); i++) 
				{
					String actualText = tableData.get(i).getText();
					if(actualText.equalsIgnoreCase(expectedText))
					{
						count++;
						//tableData.get(i).click();
					}
				}
				String pageNo = driver.findElement(By.xpath("//li[@class='paginate_button page-item active']/a[@aria-controls='example1']")).getText();
				System.out.println(pageNo);
				if(pageNo.charAt(0)>='0' && pageNo.charAt(0)<='9')
				{	
					jsLib.scrollDown();
					nextBtn.click();
				}
				else
				break;
				}
				
		System.out.println(count);
		
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
	boolean flag = false;
	
	for(; ;)
	{
		try {
			for
			
			
		}catch (Exception e) {
			jse.executeScript("scrollBy(0,900)");
			Thread.sleep(2000);
			employeeDashboardPage;
		}
		if(!(driver.findElement(By.xpath("//div[@id='example1_wrapper']//a[.='Next']")).isEnabled()))
			break;
	}
	if(!flag)
	{
		System.out.println("Employee not found");
	}
*/
	driver.manage().window().minimize();
	driver.quit();
	}
	
}

package javascriptPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handleEmployeeTable1 {

	public static void main(String[] args) throws InterruptedException {
	//Open the Chrome Browser
	WebDriver driver = new ChromeDriver();
				
	//Maximize the Browser window
	driver.manage().window().maximize();
				
	//ImplicitlyWait for 10 seconds
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//explicitwait for 10 sec
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
	//Trigger the URL of the Application
	driver.get("http://rmgtestingserver/domain/HRM_System/");
				
	//Login as HR HEAD
	//enter HRhead email id into HR Email textField
	driver.findElement(By.name("hr_email")).sendKeys("hrhead@gmail.com");
				
	//Enter HRhead Password into HR Password textField
	driver.findElement(By.name("hr_password")).sendKeys("hrhead@123");
				
	//Select the HR type from the 'Select Type' dropdown list
	Select select = new Select(driver.findElement(By.id("hr_type")));
	select.selectByVisibleText("→ HR Head");
				
	//Click on SignIn Button
	driver.findElement(By.name("login_hr")).click();
				
	//Click 'OK' on the Confirmation popup - Login Successfully 
	driver.switchTo().alert().accept();
	//Create an Employee: Click on Employee module
	
	driver.findElement(By.xpath("//p[contains(.,'EMPLOYEE')]")).click();
	
	//CLick on Add Employee option
	driver.findElement(By.xpath("//p[.='Add Employee']")).click();
	
		/*for(; ;)
	{
		try {
			driver.findElement(By.xpath("//div[@id='example1_wrapper']//tbody/tr[@role='row']/td[.='483']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@class='child']//i[@class='fa fa-download']")).click();
			Thread.sleep(2000);
			flag = true;
			break;
			
		}catch (Exception e) {
			jse.executeScript("scrollBy(0,900)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='example1_wrapper']//a[.='Next']")).click();
		}
		if(!(driver.findElement(By.xpath("//div[@id='example1_wrapper']//a[.='Next']")).isEnabled()))
			break;
	}
	if(!flag)
	{
		System.out.println("Employee not found");
	}*/
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	boolean flag = false;
	Actions actions = new Actions(driver);
	
	for(; ;)
	{
		List<WebElement> empIds = driver.findElements(By.xpath("//div[@id='example1_wrapper']//tbody/tr[@role='row']/td[1]"));
		for (int i=0; i<empIds.size(); i++) 
		{
			WebElement id = empIds.get(i);
			if(id.getText().equalsIgnoreCase("xyz"))
			{
				actions.moveToElement(id).click().perform();
				Thread.sleep(2000);
				jse.executeScript("scrollBy(0,100)");
				driver.findElement(By.xpath("//td[@class='child']//i[@class='fa fa-download']")).click();
				Thread.sleep(2000);
				flag = true;
				break;
			}
		}
	if(!flag)
	{
		jse.executeScript("scrollBy(0,900)");
		WebElement nextButton = driver.findElement(By.xpath("//div[@id='example1_wrapper']//a[.='Next']"));
		if(nextButton.isEnabled())
			nextButton.click();
		else
		{
			System.out.println("Employee not found");
			break;
		}
	}
	else
	break;
	}
	
	driver.manage().window().minimize();
	driver.quit();
	}
	
}

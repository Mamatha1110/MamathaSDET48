package javascriptPractice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ModifyAdminAddedByOneHrHeadAsOtherHrHead {
	public static void main(String[] args) throws Throwable {
		//Open the Chrome Browser
		WebDriver driver = new ChromeDriver();
		
		//Maximize the Browser window
		driver.manage().window().maximize();
		
		//ImplicitlyWait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
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
		
		//Verify Dashboard page of Hrhead account is displayed or not
		String currentUrl = driver.getCurrentUrl();
		String currentUserId = driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).getText();
		if(currentUrl.contains("Superadmin_Dashboard") && currentUserId.contains("hrhead@gmail.com") )
			{
				System.out.println("The Dashboard page of HR Head account is displayed");
			}else
			{
				System.out.println("The Dashboard page of HR Head account is displayed");
			}
		
		//Click on ADMIN Link
		driver.findElement(By.xpath("//p[contains(.,'ADMIN')]")).click();

		//Click on Add Admin button
		driver.findElement(By.xpath("//p[.='Add Admin']")).click();
		
		//Click on Add Admin button in Admin Dashboard page
		driver.findElement(By.xpath("//button[contains(.,'Add Admin')]")).click();
		
		//Enter CompanyId into companyId textField
		driver.findElement(By.name("hr_companyid")).sendKeys("234");
		
		//Enter FirstName into firstName textField
		driver.findElement(By.name("hr_firstname")).sendKeys("Varun");
		
		//Enter LastName into lasstName textField
		driver.findElement(By.name("hr_lastname")).sendKeys("Gowda");
		
		//Enter MiddleName into middleName textField
		driver.findElement(By.name("hr_middlename")).sendKeys("Kumar");
		
		//Enter ContactNo into contactNo textField
		driver.findElement(By.name("hr_contactno")).sendKeys("98756412589");
		
		//Select the HR type from the 'Select Type' dropdown list
		select = new Select(driver.findElement(By.name("hr_type"))); 
		select.selectByVisibleText("→ HR Head");
		
		//Enter EmailAddress into emailAddress textField
		driver.findElement(By.name("hr_email")).sendKeys("varun@gmail.com");
		
		//Enter Password into password textField
		driver.findElement(By.name("hr_password")).sendKeys("pwd123");
		
		//Click on Save Button
		driver.findElement(By.name("hr_admin")).click();
		
		//Click 'OK' on the Confirmation popup - Insert Successfully 
		driver.switchTo().alert().accept();
		
		//Verify the HR account is created or not 
		List<WebElement> hrList = driver.findElements(By.xpath("//tr[@role='row']//td"));
		for (WebElement hr : hrList) {
			if(hr.getText().equalsIgnoreCase("123"))
				{
					System.out.println("The HR Account is Created");
					break;
				}else
				{
					System.out.println("The HR Account is not Created");
				}
		}
		
		//Logout as HR Head
		driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
		driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
		
		//Click 'OK' on the Confirmation popup - Successfully Logout
		driver.switchTo().alert().accept();
		
		//Verify the HR Head account is logged out
		if(driver.getCurrentUrl().contains("http://rmgtestingserver/domain/HRM_System/"))
		{
			System.out.println("The HR Head Account is Logged out successfully");
		}else
		{
			System.out.println("The HR Head Account is not Logged out successfully");
		}
		
		//Login as Veena HR Head account
			driver.findElement(By.name("hr_email")).sendKeys("veena@gmail.com");
						
			//Enter HRhead Password into HR Password textField
			driver.findElement(By.name("hr_password")).sendKeys("pwd123");
						
			//Select the HR type from the 'Select Type' dropdown list
			select = new Select(driver.findElement(By.id("hr_type")));
			select.selectByVisibleText("→ HR Head");
						
			//Click on SignIn Button
			driver.findElement(By.name("login_hr")).click();
					
			//Click 'OK' on the Confirmation popup - Login Successfully 
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
						
			//Verify Dashboard page of correct account is displayed or not
			currentUrl = driver.getCurrentUrl();
			currentUserId = driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).getText();
			if(currentUrl.contains("Superadmin_Dashboard") && currentUserId.contains("veena@gmail.com") )
			{
				System.out.println("The Dashboard page of Veena account is displayed");
			}else
			{
				System.out.println("The Dashboard page of Veena account is displayed");
			}
			
			//Click on ADMIN Link
			driver.findElement(By.xpath("//p[contains(.,'ADMIN')]")).click();

			//Click on Add Admin button
			driver.findElement(By.xpath("//p[.='Add Admin']")).click();

			//Select the Admin to be modified
			boolean flag = false;
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			for(; ;)
			{
				List<WebElement> adminIds = driver.findElements(By.xpath("//tr[@role='row']/td[1]"));
				for (WebElement adminId : adminIds)
				{
					if(adminId.getText().equalsIgnoreCase("234"))
					{
						jse.executeScript("scrollBy(0,949)");
						adminId.click();
						driver.findElement(By.xpath("//td[@class='child']/ul[@class='dtr-details']//i[@title='Edit Employee']")).click();
						
						WebElement firstNameTextField = driver.findElement(By.xpath("//div[@class='card-body']/div[@class='modal fade show']//input[@name='hr_firstname']"));
						firstNameTextField.clear();
						firstNameTextField.sendKeys("Karan");
						driver.findElement(By.xpath("//div[@class='card-body']/div[@class='modal fade show']//button[.='Save']")).click();
						
						//Click 'OK' on the Confirmation popup - Update Successfully 
						Thread.sleep(2000);
						driver.switchTo().alert().accept();
						
						flag = true;
						break;
					}
					else
					{
						jse.executeScript("ScrollBy(0,949)");
						driver.findElement(By.xpath("//a[.='Next']")).click();
					}
				}
				if(!driver.findElement(By.xpath("//a[.='Next']")).isEnabled())
					break;
			}
			if(!flag)
			{
				System.out.println("Admin account not found");
			}
	
	}
}
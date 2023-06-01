package javascriptPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ModifyCorporateAddedByOneHrHeadAsOtherHrHead {
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
		
		//Verify Dashboard page of HRhead account is displayed or not
		String currentUrl = driver.getCurrentUrl();
		String currentUserId = driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).getText();
		if(currentUrl.contains("Superadmin_Dashboard") && currentUserId.contains("hrhead@gmail.com") )
			{
				System.out.println("The Dashboard page of HR Head account is displayed");
			}else
			{
				System.out.println("The Dashboard page of HR Head account is displayed");
			}
		
		//Click on CORPORATE link
		driver.findElement(By.xpath("//p[contains(.,'CORPORATE')]")).click();
		
		//CLick on 'Add Corporate' button
		driver.findElement(By.xpath("//p[.='Add Corporate']")).click();
		
		//Click on Add Corporate button in Corporate Dashboard page
		driver.findElement(By.xpath("//button[contains(.,'Add Corporate')]")).click();

		//Enter the New Corporate Name into corporateName textField
		driver.findElement(By.name("corporate_name")).sendKeys("Finance");
		
		//Click on Save button
		driver.findElement(By.xpath("//button[.='Save']")).click();
		
		//Click 'OK' on the Confirmation popup - Insert Successfully 
				driver.switchTo().alert().accept();
				
		//Verify whether the new Corporate is created or not
		driver.findElement(By.xpath("//th[.='Date Created']")).click();
		driver.findElement(By.xpath("//th[.='Date Created']")).click();
		List <WebElement> corporateList = driver.findElements(By.xpath("//tr/td[2]"));
		for (WebElement corporate : corporateList) {
			if(corporate.getText().equalsIgnoreCase("Finance"))
			{
				System.out.println("The new Corporate is created");
				break;
			}
			else
			{
				System.out.println("The new Corporate is not created");
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
				
				//Login with other HR Head account
				//enter HRhead email id into HR Email textField
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
				
				//Click on CORPORATE link
				driver.findElement(By.xpath("//p[contains(.,'CORPORATE')]")).click();
				
				//CLick on 'Add Corporate' button
				driver.findElement(By.xpath("//p[.='Add Corporate']")).click();
				
				//Choose the Corporate to edit
				driver.findElement(By.xpath("//th[.='Date Created']")).click();
				driver.findElement(By.xpath("//th[.='Date Created']")).click();
				List <WebElement> corporateList1 = driver.findElements(By.xpath("//tr/td[2]"));
				for (WebElement corporate : corporateList1) {
					if(corporate.getText().equalsIgnoreCase("Finance"))
					{
						//Click on Edit
						corporate.findElement(By.xpath("//td/button[.='Edit']")).click();
						WebElement editCorporateTextField = driver.findElement(By.xpath("//div[@class='modal fade show']//input[@name='corporate_name']"));
						editCorporateTextField.clear();
						editCorporateTextField.sendKeys("Finance Sec");
						//Click on Update button
						driver.findElement(By.xpath("//div[@class='modal fade show']//button[.='Update']")).click();
						
						//Click 'OK' on the Confirmation popup - Update Successfully 
								driver.switchTo().alert().accept();
					}
					else
					{
						System.out.println("Corporate not found");
					}
					
					//Verify if the edited corporate is displayed or not
					//Verify whether the new Corporate is created or not
					driver.findElement(By.xpath("//th[.='Date Created']")).click();
					driver.findElement(By.xpath("//th[.='Date Created']")).click();
					
					corporateList = driver.findElements(By.xpath("//tr/td[2]"));
					for (WebElement corporate1 : corporateList) {
						if(corporate1.getText().equalsIgnoreCase("Finance Sec"))
						{
							System.out.println("The new Corporate is Updated");
							break;
						}
						else
						{
							System.out.println("The new Corporate is not Updated");
						}
					}
					
					//Logout as HR Head - Veena
					driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
					driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
					
					//Click 'OK' on the Confirmation popup - Successfully Logout
					driver.switchTo().alert().accept();
					
					//Verify the HR Head account is logged out
					if(driver.getCurrentUrl().contains("http://rmgtestingserver/domain/HRM_System/"))
					{
						System.out.println("Veena Account is Logged out successfully");
					}else
					{
						System.out.println("Veena Account is not Logged out successfully");
					}
					}
		
		driver.manage().window().minimize();
		driver.quit();
	}
}


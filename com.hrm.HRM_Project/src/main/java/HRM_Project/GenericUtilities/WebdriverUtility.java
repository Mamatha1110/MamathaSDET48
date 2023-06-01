package HRM_Project.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of all Webdriver related methods
 * @author Admin
 *
 */
public class WebdriverUtility {
	
	/**
	 * This method is used to Maximize the Browser window
	 * @author Admin
	 *
	 */
	public void maximizeBrowserWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to Maximize the Browser window
	 * @author Admin
	 *
	 */
	public void minimizeBrowserWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to wait till the WebElement is Located
	 * @param driver
	 */
	public void waitUntilElementIsLocated(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstants.explicitWaitDuration));		
	}
	
	/**
	 * This method is used to wait till the WebElement is visible on UI
	 * @param driver
	 * @param element
	 */
	public void waitUntilElementIsVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait till the WebElement becomes Clickable
	 * @param driver
	 * @param element
	 */
	public void waitUntilElementIsClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to wait till Alert popup is present on UI
	 * @param driver
	 */
	public void waitForAlertPopup(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * This method is used to wait till the Title of the page is matched
	 * @param driver
	 * @param title
	 */
	public void waitForTitle(WebDriver driver, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * This method is used to wait till the URL of the page is matched
	 * @param driver
	 * @param title
	 */
	public void waitForUrl(WebDriver driver, String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	/**
	 * This method ignores if it gets NoSuchElementException
	 * @param driver
	 */
	public void ignoreNoSuchElementExcp(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	/**
	 * This method is used to select element in dropdown list by Index
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method is used to select element in dropdown list by value
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method is used to select element in dropdown list by Visible text
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(String text, WebElement element)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to print all the options in the Dropdown list
	 * @param element
	 */
	public void printAllOptionsFromDropdown(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) 
		{
			System.out.println(option.getText());
		}
	}
	
	/**
	 * This method is used to get all the options in the Dropdown list
	 * @param element
	 */
	public List<WebElement> getAllOptionsFromDropdown(WebElement element)
	{
		Select select = new Select(element);
		return select.getOptions();
	}
	
	/**
	 * This method is used to Mouse hover on an element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to perform Right Click on an element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}	
	
	/**
	 * This method is used to perform Double Click on an element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to Switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to Switch to frame based on id
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, String id)
	{
		driver.switchTo().frame(id);
	}
	
	/**
	 * This method is used to Switch to frame based on WebElement
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to Switch to main frame of the webpage 
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to Switch to parent frame of current frame
	 * @param driver
	 * @param index
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method is used to Switch to Alert popup and click on 'OK'
	 * @param driver
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver)
	{
		waitForAlertPopup(driver);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to Switch to Alert popup and click on 'CANCEL'
	 * @param driver
	 */
	public void switchToAlertPopupAndDismiss(WebDriver driver)
	{
		waitForAlertPopup(driver);
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to check whether the expected Alert popup is appeared
	 * @param driver
	 */
	public void checkForAlertPopupText(WebDriver driver, String text)
	{
		waitForAlertPopup(driver);
		Alert alt = driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(text))
			System.out.println("Expected Alert popup is appeared");
		else
			System.out.println("Expected Alert popup is not appeared");
	}
	
	/**
	 * This method is used to  handle FileUpload Popup
	 * @param element
	 * @param path
	 */
	public void fileUpload(WebElement element, String path)
	{
		element.sendKeys(path);
	}
	
	/**
	 * This method is used to specify user defined Polling time
	 * @param duration
	 * @param element
	 * @param pollingTime
	 */
	public void customWait(int duration, WebElement element, long pollingTime)
	{
		int count = 0;
		while(count<duration)
		{
			try {
				element.click();
				break;
			}catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			count++;
		}
	}

	/**
	 * This method is used to take Screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException 
	 */
	public String takeScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String localDateTime = LocalDateTime.now().toString().replace(":","-");
		File dst = new File("./screenShot"+screenshotName+" "+localDateTime+".png");
		FileUtils.copyFile(src, dst);
		return screenshotName;
	}
	
	/**
	 * This method is used to Switch to child window
	 * @param driver
	 * @param title
	 */
	public void switchWindow(WebDriver driver, String title)
	{
		Set<String> set = driver.getWindowHandles();
		for (String wid : set) {
			driver.switchTo().window(wid);
			String text = driver.getTitle();
			if(text.contains(title))
			{
				break;
			}
		}
	}
	
	/**
	 * This method is used to Switch to child window
	 * @param driver
	 * @param title
	 */
	public void switchingWindow(WebDriver driver, String url)
	{
		Set<String> set = driver.getWindowHandles();
		for (String wid : set) {
			driver.switchTo().window(wid);
			String text = driver.getCurrentUrl();
			if(text.contains(url))
			{
				break;
			}
		}
	}
}


package HRM_Project.GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Admin
 *
 */
public class JavaScriptUtility {
	JavascriptExecutor js;
	
	/**
	 * 
	 * @param driver
	 */
	public JavaScriptUtility(WebDriver driver)
	{
		js = (JavascriptExecutor) driver;
	}
	
	/**
	 * 
	 */
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	/**
	 * 
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	/**
	 * 
	 */
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/**
	 * 
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	
	/**
	 * 
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element, String data)
	{
		js.executeScript("arguments[0].value = arguments[1]",element,data);
	}
	
	/**
	 * 
	 * @param element
	 */
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click",element);
	}
	
	/**
	 * 
	 * @param elementId
	 */
	public void clickElementByID(String elementId)
	{
		js.executeScript("document.getElementById('elementId').click()");
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	public String getTheText(WebElement element)
	{
		String textFieldValue = (String)js.executeScript("return arguments[0].value;",element);
		return textFieldValue;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUrlOfCurrentPage()
	{
		String url = (String)js.executeScript("return window.location.href");
		return url;
	}
	
	public String getTitleOfCurrentPage()
	{
		String title = (String)js.executeScript("return document.title");
		return title;
	}
}
	

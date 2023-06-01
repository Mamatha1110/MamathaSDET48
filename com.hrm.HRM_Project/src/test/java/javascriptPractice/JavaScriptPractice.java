package javascriptPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import HRM_Project.GenericUtilities.JavaScriptUtility;

public class JavaScriptPractice {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	
	JavaScriptUtility js = new JavaScriptUtility(driver);
	
	//Launch application
	js.launchApplication("https://docs.phptravels.com/");
	
	//get URL of the current page
	System.out.println(js.getUrlOfCurrentPage());
	
	//get title of the current page
	System.out.println(js.getTitleOfCurrentPage());
	
	//scrollDown
	js.scrollDown();
	
	//ScrollUp
	js.scrollUp();
	
	//Scroll till Element - Click on "API REsponse error" link
	WebElement element = driver.findElement(By.xpath("//div[@data-testid='page.desktopTableOfContents']//div[.='API Response Error' and @dir='auto']"));
	js.scrollTillElement(element);
	//click on element
	js.click(element);
	
	//Scroll Till Element 2 - Clck on smiley face
	WebElement element1 = driver.findElement(By.xpath("//div[@data-testid='page.desktopTableOfContents']//div[.='API Response Error' and @dir='auto']"));
	js.scrollTillElement(element1);
	//click on element
	js.click(element1);
}
}

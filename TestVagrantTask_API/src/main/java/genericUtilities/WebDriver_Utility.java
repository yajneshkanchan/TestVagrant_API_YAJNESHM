package genericUtilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * contains all the reusable Actions of Webdriver
 * @author yajnesh
 */

public class WebDriver_Utility {
	/**
	 * this method will always wait for Element in DOM document & release the control if element available. It is a implicit wait
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstant.implicitlyTimeout, TimeUnit.SECONDS);
	}

	/**
	 * it's an Explicitly wait always wait for page to be loaded & available in GUI
	 * @param driver
	 * @param partialPageURL
	 */

	public void waitForElementInDOM(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,IConstant.expliclitytimeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method is used to maximize the window
	 * @author yajneshm
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * used to switch any window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String Wid = it.next();
			driver.switchTo().window(Wid);
			String currentWindowtitle = driver.getTitle();
			if (currentWindowtitle.contains(partialWindowTitle)) {
				break;	
			}}     
	}
	public void moveElement(WebDriver driver, WebElement ele)
	{
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	/**
	 * this method is used to move the curson to the required element
	 * @return
	 */

	public void select(WebElement element,String text) {
		Select sel =new Select(element);
		sel.selectByValue(text);
	}
	/**
	 * it's an Explicitly wait always wait for Page to be loaded & available in GUI 
	 * @param driver
	 * @param partialPageURL
	 */

	public void waitForPage(WebDriver driver,String partialPageUrl)
	{
		WebDriverWait wait = new WebDriverWait(driver, IConstant.expliclitytimeout);
		wait.until(ExpectedConditions.urlContains(partialPageUrl));
	}

	/**
	 * it's an Explicitly wait always wait for Page to be loaded & available in GUI 
	 * @param driver
	 * @param element
	 */

	public void waitForElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, IConstant.expliclitytimeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * switch to alert window & click on ok button
	 * @param driver
	 */ 

	public void swithToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg) 
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
			System.out.println("Alert Message is verified");
		}else {
			System.out.println("Alert Message is not verified");
		}
		alt.accept();
	}

	/**
	 * used to switch to alert window & click on cancel button
	 * @param driver
	 */

	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		if(alt.getText().equals(expectedMsg)) {
			System.out.println("Alert Message is verified");
		}else {
			System.out.println("Alert Message is not verified");
		}
		alt.dismiss();
	}

	/**
	 * used to switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */

	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}

	/**
	 *used to switch to Frame Window based on id or name attribute 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select value from drop down based on index
	 * @param driver
	 * @param index
	 */

	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 *used to select the value from the dropdown based on value / option available in GUI 
	 *@param element
	 *@param value
	 */
	public void select1(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * @param driver 
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * used to right click on specified element 
	 * @param driver
	 * @param element
	 */

	public void rightClickonElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * use javascript executor for scroll up and scroll down
	 * @param driver
	 * @param javaScript
	 */

	public void executeJvaScript(WebDriver driver,String javaScript) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}

	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * pass enter Key appertain in to Browser 
	 * @param driver
	 */

	public void passEnterKey(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
}	



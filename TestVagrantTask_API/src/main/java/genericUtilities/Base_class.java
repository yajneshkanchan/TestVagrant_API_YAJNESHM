package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base_class {

	public	Propertyfile_Utility filelib=new Propertyfile_Utility();
	public static Java_utility jlib = new Java_utility();
	public static Excel_Utility elib = new Excel_Utility();
	public static WebDriver_Utility wlib = new WebDriver_Utility();
	

	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite
	public void bs()
	{
		System.out.println("database connection");
	}
	@BeforeTest
	public void bt() 
	{
		System.out.println("execute script in parallel mode");
	}
	@BeforeClass 
	public void bc() throws Throwable
	{
		/*String Browser=filelib.getpropertyKeyAndValue("browser");

		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		wlib.waitForElementInDOM(driver);
		String url=filelib.getpropertyKeyAndValue("url");
		System.out.println(url);
		driver.get(url);
		sdriver=driver;
		 */
	}

	@BeforeMethod
	/* public void bm() throws Throwable{
		String username=filelib.getpropertyKeyAndValue("username");
		String password=filelib.getpropertyKeyAndValue("password");
		System.out.println(username +" "+ password);
		Loginpage lp=new Loginpage(driver);
		lp.loginToApp(username, password);
		 homepage = new HomePage(driver);}
	 */

	@AfterMethod
	public void am() 
	{/*

		homepage.logout();
	 */}
	@AfterClass
	public void ac()
	{driver.quit();
	}
	@AfterTest
	public void at()
	{
		System.out.println("parallel execution is completed");
	}
	@AfterSuite
	public void as()
	{
		System.out.println("connection with database removed");
	}
}







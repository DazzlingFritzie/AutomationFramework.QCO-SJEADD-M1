package vTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	public JavaUtility jUtil = new JavaUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();

	public WebDriver driver = null;
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun=true)
	public void bsconfig()
	{
		System.out.println(" --- Database Connection Successful ---");
	}	
	
	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
	public void  bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(opt);
			System.out.println(BROWSER+" --- Browser launch successful ---");
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			EdgeOptions opt = new EdgeOptions();
		    opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver(opt); 
			System.out.println(BROWSER+" --- Browser launch successful ---");
		}
		else
		{
			System.out.println("invalid browser name in property file");
		}
		
		sDriver=driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
		{
		 String USERNAME = pUtil.readDatafromPropertyFile("username");
		    String PASSWORD = pUtil.readDatafromPropertyFile("password");
		    
		    LoginPage lp = new LoginPage(driver);
		    lp.loginToApp(USERNAME, PASSWORD);
		    System.out.println(" --- Login is Successful ---");
		}
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logOutOfApp(driver);
		System.out.println(" --- Logout is Successful ---");
		
	}
	//@AfterTest
	@AfterClass(groups="SmokeSuite")
	public void  acConfig()
	{
		driver.quit();
		System.out.println(" --- browser closed Successfully ---");
	}
	
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void asconfig()
	{
		System.out.println(" --- Database closed Successfully ---");
	}
	}
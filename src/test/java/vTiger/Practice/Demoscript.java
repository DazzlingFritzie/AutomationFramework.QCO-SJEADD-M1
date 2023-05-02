package vTiger.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.LoginPage;


public class Demoscript {

	public static void main(String[] args) throws IOException {
		
		//Create Object of all Utilities
				JavaUtility jUtil = new JavaUtility();
				PropertyFileUtility pUtil = new PropertyFileUtility();
				ExcelFileUtility eUtil = new ExcelFileUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				
				//Read all the required Data
				String BROWSER = pUtil.readDatafromPropertyFile("browser");
				String URL = pUtil.readDatafromPropertyFile("url");
				String USERNAME = pUtil.readDatafromPropertyFile("username");
				String PASSWORD = pUtil.readDatafromPropertyFile("password");
				
				String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
				WebDriver driver = null;
				
				//Step 1: launch the browser - RUNTIME POLYMORPHISM 
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					ChromeOptions opt=new ChromeOptions();
					opt.addArguments("--remote-allow-origins=*");
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(opt); // driver is initialised to chrome 
				}
				else if(BROWSER.equalsIgnoreCase("edge"))
				{
					EdgeOptions opt = new EdgeOptions();
					opt.addArguments("--remote-allow-origins=*");
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver(opt); // driver is initialised to chrome
				}
				else 
				{
					System.out.println("invalid browser name");
				}
				
				 
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				driver.get(URL);
				
				//Step 2: Login to App
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("submitButton")).click();
				
				LoginPage lp = new LoginPage(driver);
				//lp.getUserNameEdt().sendKeys(USERNAME);
				//lp.getPasswordEdt.sendKeys(PASSWORD);
				//lp.get
				
				lp.loginToApp(USERNAME,PASSWORD);
				
				//Step 3: Navigate to Organizations Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 4: click on Create Organization Look Up Image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 5: Create Organization with Mnadatory fields
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 6: Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 7: Validate
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println("=== PASS ===");
				}
				else
				{
					System.out.println("=== FAIL ===");
				}
				
				//Step 8: Logout
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Signout successfull");
				
			}

	}



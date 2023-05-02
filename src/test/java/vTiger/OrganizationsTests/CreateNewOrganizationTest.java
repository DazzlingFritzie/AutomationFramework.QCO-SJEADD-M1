package vTiger.OrganizationsTests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateNewOrganizationTest extends BaseClass {
	
	@Test(groups="SmokeSuite")
	public void createNewOrgTest() throws IOException
	{
	
	
	String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
	
	
			// Step 3: Navigate to Organizations LInk
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLink();

			// Step 4: click on Create Organization Look Up Image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrgLookUpImg();

			// Step 5: Create Organization with Mandatory fields
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNeworg(ORGNAME);

			// Step 7: Validate
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String OrgHeader = oip.getOrgHeader();
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			
			/*if (OrgHeader.contains(ORGNAME)) {
				System.out.println("=== PASS ===");
			} else {
				System.out.println("=== FAIL ===");
			}*/

		}
	        @Test(groups="RegressionSuite")
             public void demoOrg()
             {
	          System.out.println("This is Demo");
             }
	}


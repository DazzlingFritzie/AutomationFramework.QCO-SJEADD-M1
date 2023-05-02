package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;


public class CreateContactWithOrganizationTest extends BaseClass{
	
	@Test
	public void createContactOrgTest() throws IOException
	{
	//public static void main(String[] args) throws IOException {

		String LASTNAME= eUtil.readDataFromExcel("Contact", 4, 2);
		
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)
				+jUtil.getRandomNumber();
		
		//Step 3: Navigate to Organizations Link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		
		//Step 4: click on Create Organization Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 5: Create Organization with Mnadatory fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNeworg(ORGNAME);
		
		//Step 7: Validate
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String OrgHeader = oip .getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		/*if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader + "--> Organization created successfully");
		}
		else
		{
			System.out.println("=== FAIL ===");
		}*/
		/*create  Contact using the same Organization*/
		//step 8 : navigate Contact Link
		hp.clickOnContactLink();
		
		//step 9: click on Creatye Contact Look Up image
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		//step 10:Create Contact
		CreateNewContactPage cncp= new CreateNewContactPage(driver) ;
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		wUtil.takeScreenShot(driver, "Contact");
		
		//step 11: validate
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));

       /*if(ContactHeader.contains(LASTNAME))
		{
			System.out.println(ContactHeader + "Pass");
		}
		else {
			System.out.println("Fail");
		}*/
		
		
	}

	}




package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Opporunities")
	private WebElement OpportunitiesLink;
	
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText ="Sign Out")
	private WebElement SignOut;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//business library
	
	public void clickOnOrgLink()
	{
		OrganizationsLink.click();
	}
	
	public void clickOnContactLink()
	{
		ContactsLink.click();
	}
	
	
	public void logOutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOut.click();
	}
	
	
	
	
	
	
	
}

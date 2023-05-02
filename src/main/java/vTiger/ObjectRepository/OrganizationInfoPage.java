package vTiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
			private WebElement OrgHeaderText;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrgHeaderText()
	{
	return OrgHeaderText;
	}
	
	//Business Library
	/**
	 * This method will get the header text and return it to the called
	 * @return
	 */
	public String getOrgHeader()
	{
		return OrgHeaderText.getText();
	}

}

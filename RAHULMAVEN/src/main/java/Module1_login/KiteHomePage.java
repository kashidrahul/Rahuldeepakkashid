package Module1_login;
//pom class 3

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
	@FindBy(xpath="//span[@class='user-id']")	private WebElement userID;
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String getKiteHomePageUserID() 
	{
		String actUserID = userID.getText();
		return actUserID;
	}
	
	
//	public void verifyKiteHomePageUserID(String expuserID)
//	{
//		String actUserID = userID.getText();
//		
//		if(actUserID.equals(expuserID))
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}		
//	}
	
	
	
}


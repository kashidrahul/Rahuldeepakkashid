package Module1_login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.BaseClass;
import Library_Files.UtilityClass;
import Module1_login.KiteHomePage;
import Module1_login.KiteLogin1Page;
import Module1_login.KiteLogin2Page;

public class KiteLoginTest extends BaseClass
{
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	KiteHomePage home;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException 
	{
	    initializeBrowser();
		login1=new KiteLogin1Page(driver);
	    login2=new KiteLogin2Page(driver);
	    home=new KiteHomePage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws EncryptedDocumentException, IOException
	{
		login1.inpKiteLogin1PageUsername(UtilityClass.getPFdata("UN"));
		login1.inpKiteLogin1PagePassword(UtilityClass.getPFdata("PWD"));
		login1.clickKiteLogin1PageLoginBtn();
		login2.inpKiteLogin2PagePin(UtilityClass.getPFdata("PIN"));
		login2.clickKiteLogin2PageCntBtn();
	}
	
	@Test
	public void verifyUserID() throws EncryptedDocumentException, IOException
	{
		TCID = 101;
		String actUserID=home.getKiteHomePageUserID();
		String expUserID=UtilityClass.getTD(0, 3);
		Assert.assertEquals(actUserID, expUserID,"Failed: both results are diff");
	}
	
	
	@AfterMethod
	public void appLogout(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
}



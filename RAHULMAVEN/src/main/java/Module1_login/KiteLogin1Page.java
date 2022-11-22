package Module1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//pom class1
public class KiteLogin1Page 
{
	//step1: variable declaration
	@FindBy(xpath="//input[@id='userid']") private WebElement UN;   // private WebElement UN = driver.findElement(By.xpath(""))
	@FindBy(xpath="//input[@id='password']") private WebElement PWD;  // private WebElement PWD = driver.findElement(By.xpath(""))
	@FindBy(xpath="//button[text()='Login ']") private WebElement loginBtn;  // private WebElement loginBtn = driver.findElement(By.xpath(""))

	//step2: variable initialization
	public KiteLogin1Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3: variable usage	
	public void inpKiteLogin1PageUsername(String username) 
	{
		UN.sendKeys(username);
	}
		
	public void inpKiteLogin1PagePassword(String password) 
	{
		PWD.sendKeys(password);
	}
	
	public void clickKiteLogin1PageLoginBtn()
	{
		loginBtn.click();
	}
	
	
}

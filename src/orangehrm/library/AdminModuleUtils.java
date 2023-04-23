package orangehrm.library;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.AppUtils;

public class AdminModuleUtils extends AppUtils 
{

	
	String uid = "Admin";
	String pwd = "Qedge123!@#";
	
	@BeforeTest
	public void adminLogin()
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@AfterTest
	public void adminLogout()
	{
		
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.partialLinkText("Logout")).click();
	}
	
}

package orangehrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLUtils;

public class AdminLoginTestwithValidData extends AppUtils
{
	String datafile="C:\\Users\\devi\\workspace\\selenium\\011122\\OrangeHRM_DDT\\TestDataFiles\\testdata.xlsx";
	String datasheet = "AdminLoginValidData";

	@Test
	public void checkAdminLogin() throws IOException
	{
		
		int rowcount = XLUtils.getRowCount(datafile, datasheet);
		LoginPage lp = new LoginPage();
		String adminuid , adminpwd;
		boolean res;
		
		for(int i=1;i<=rowcount; i++)
		{
			System.out.println(i);
			adminuid = XLUtils.getStringCellData(datafile, datasheet, i, 0);
			adminpwd = XLUtils.getStringCellData(datafile, datasheet, i, 1);
			
			lp.login(adminuid, adminpwd);
			res = lp.isAdminModuleDisplayed();
			Assert.assertTrue(res);
			
			if(res)
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Pass");
				XLUtils.fillGreenColor(datafile, datasheet, i, 2);
			} else
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Fail");
				XLUtils.fillRedColor(datafile, datasheet, i, 2);
			}
			
			lp.logout();
		}
				
	}
		
}

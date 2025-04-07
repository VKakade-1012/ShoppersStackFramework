package com.ShoppersStack_TestScript;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ShoppersStack_GenericUtility.Base_Test;
import com.ShoppersStack_POM.MyAddresses_Page;
import com.ShoppersStack_POM.MyProfile_Page;

public class TC_002_verify_user_is_able_to_delete_address_or_not_Test extends Base_Test
{
	@Test
	public void deleteAddress() throws IOException
	{
		homePage.getAccountSettingBtn().click();
		homePage.getMyProfile().click();
		
		MyProfile_Page myProfilePage=new MyProfile_Page(driver);
		myProfilePage.getMyAddressesBtn().click();
		
		MyAddresses_Page myaddresAddresses=new MyAddresses_Page(driver);
		wait.until(ExpectedConditions.elementToBeClickable(myaddresAddresses.getDeleteBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(myaddresAddresses.getYesBtn())).click();

		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		webDriverUtility.getWebPageScreenShot(driver);
	}
}

package org.pageexe;

import java.io.IOException;

import org.basecls.BaseCls;
import org.junit.Before;
import org.junit.Test;
import org.locators.LoginPage;
import org.openqa.selenium.WebElement;

public class LoginPageExe extends LoginPage {
	@Before
	public static void launch() {
		browserOpen("chrome");
		BaseCls.launch("https://adactinhotelapp.com/");
	}

	@Test
	public static void UserName() throws IOException {

		BaseCls.sendKeys(findElementById(LoginPage.username), getPropertyData("UserName"));
		BaseCls.sendKeys(findElementById(LoginPage.password), getPropertyData("password"));
		clickButton(findElementById("login"));
	}
	
	}
	

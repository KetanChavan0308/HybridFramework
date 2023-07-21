package com.Demo.login;

import org.testng.annotations.Test;

import com.Demo.commons.Commons;
import com.Demo.utilities.PropertiesReading;

/**
 * The value we have give is hard coded we have to maintain one properties file
 * to add this or we can use excel sheet as well. Excel,CSV, Data Provider we
 * can use this.
 */
public class LoginTests {
	@Test(priority = 1, enabled = true)
	public void TE_007() throws InterruptedException {
		Commons.textToEnter(PropertiesReading.setProperties("emailField")[0],
				PropertiesReading.setProperties("emailField")[1], PropertiesReading.setCredential("username"));

		Commons.textToEnter(PropertiesReading.setProperties("passField")[0],
				PropertiesReading.setProperties("passField")[1], PropertiesReading.setCredential("password"));

		Commons.clickButton("xpath", "//input[@value=\"Login\"]");
		Thread.sleep(3000);
	}

	@Test(priority = 2, enabled = false, dependsOnMethods = "TE_007")
	public static void TE_001() throws Exception {
		Commons.actionClass("xpath", "//a[text()=\"MP3 Players\"]");
		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void TE_002() throws Exception {
		Commons.dropDownSelection("xpath", "//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select", "India");
		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void TE_003() {

		Commons.displayText("xpath", "//h1[text()=\"This is a sample page\"][1]");

	}

	@Test(enabled = false)
	public void TE__004() throws Exception {
		Commons.clickButton("xpath", "(//input[@name=\"chk\"])[1] ");
		Commons.isPresent("xpath", "(//input[@name=\"chk\"])[1] ");
		Thread.sleep(3000);

	}
}

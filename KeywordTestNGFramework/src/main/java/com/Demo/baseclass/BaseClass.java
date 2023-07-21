package com.Demo.baseclass;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.Demo.commons.Commons;
import com.Demo.utilities.PropertiesReading;

public class BaseClass {
	@BeforeTest
	public static void setup() {
		Commons.selectBrowser("Chrome");
		Commons.maximazWindow();
		Commons.launchUrl(PropertiesReading.setProperty("appUrl",
				"D:\\Eclipse\\Eclipse_Code\\KeywordTestNGFramework\\ObjectRepository\\ObjectRepository.Properties"));
		Commons.waitForElement(10);

	}

	@AfterTest
	public static void tearDown() {
		Commons.closeAllbrowser();
	}

}

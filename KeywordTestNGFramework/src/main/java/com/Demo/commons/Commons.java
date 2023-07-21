/*
 * Project Name:DemoFramework
 * Autor:Kevin Wills
 * Organization:Conizant solution.pvt.ltd.
 */
package com.Demo.commons;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.Demo.constants.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Commons {
	/**
	 * This Method will provide the option of driver which they want to use.
	 * 
	 * @param browser_Name {@code String}
	 * @return Void
	 */

	public static void selectBrowser(String browser_Name) {
		switch (browser_Name) {

		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			break;

		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			Constants.driver = new EdgeDriver();
			break;

		case "Safari":
			WebDriverManager.safaridriver().setup();
			Constants.driver = new SafariDriver();
			break;

		default:
			System.out.println("Invalid Browser Name:" + browser_Name);
			break;
		}
	}

	/**
	 * This Method use to Maximize the opened window.
	 */
	public static void maximazWindow() {
		Constants.driver.manage().window().maximize();
	}

	/**
	 * This Method will wait until NoSuchElement Exception occure.
	 * 
	 * @param Time {@code Integer}
	 */
	public static void waitForElement(int Time) {
		Constants.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time));
	}

	/**
	 * This Method use to open url which is entered by user.
	 * 
	 * @param Url {@code String}
	 */
	public static void launchUrl(String Url) {
		Constants.driver.get(Url);
	}

	/**
	 * This Method Will Close currently open Browser.
	 */
	public static void closeBrowser() {
		Constants.driver.close();
	}

	/**
	 * This Method will close All open Browser.
	 */
	public static void closeAllbrowser() {
		Constants.driver.quit();
	}

	/**
	 * This Method use to select loactor for finding web Element.
	 * 
	 * @param locatorType  {@code String}
	 * @param locatorValue {@code String}
	 * @param textToEnter  {@code String}
	 */

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;

		switch (locatorType) {

		case "id":
			element = Constants.driver.findElement(By.id(locatorValue));
			break;

		case "name":
			element = Constants.driver.findElement(By.name(locatorValue));
			break;

		case "xpath":
			element = Constants.driver.findElement(By.xpath(locatorValue));
			break;

		case "tagName":
			element = Constants.driver.findElement(By.tagName(locatorValue));
			break;

		case "className":
			element = Constants.driver.findElement(By.className(locatorValue));
			break;

		case "linkText":
			element = Constants.driver.findElement(By.linkText(locatorValue));
			break;

		case "partialLinkText":
			element = Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;

		case "cssSelector":
			element = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;

		default:
			System.out.println("Invalid Locator Type:" + locatorType);
			break;
		}
		return element;

	}

	/**
	 * This Method is use to List of web Elements (Multiple WebElements)
	 * 
	 * @param locatorType  {@code Strining}
	 * @param locatorValue {@code Strining}
	 * @return
	 */
	public static List<WebElement> getWebElements(String locatorType, String locatorValue) {
		List<WebElement> elements = null;

		switch (locatorType) {

		case "id":
			elements = Constants.driver.findElements(By.id(locatorValue));
			break;

		case "name":
			elements = Constants.driver.findElements(By.name(locatorValue));
			break;

		case "xpath":
			elements = Constants.driver.findElements(By.xpath(locatorValue));
			break;

		case "tagName":
			elements = Constants.driver.findElements(By.tagName(locatorValue));
			break;

		case "className":
			elements = Constants.driver.findElements(By.className(locatorValue));
			break;

		case "linkText":
			elements = Constants.driver.findElements(By.linkText(locatorValue));
			break;

		case "partialLinkText":
			elements = Constants.driver.findElements(By.partialLinkText(locatorValue));
			break;

		case "cssSelector":
			elements = Constants.driver.findElements(By.cssSelector(locatorValue));
			break;

		default:
			System.out.println("Invalid Locator Type:" + locatorType);
			break;
		}
		return elements;
	}

	/**
	 * This Method is use to Enter text
	 * 
	 * @param locatorType  {@code String}
	 * @param locatorValue {@code String}
	 * @param textToEnter  {@code String}
	 */
	public static void textToEnter(String locatorType, String locatorValue, String textToEnter) {
		Commons.getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	/**
	 * This Method use to selct loactor for click operation.
	 * 
	 * @param locatorType  {@code= String}
	 * @param locatorValue {@code= String}
	 */
	public static void clickButton(String locatorType, String locatorValue) {
		Commons.getWebElement(locatorType, locatorValue).click();
	}

	/**
	 * This Method is use to handle action class
	 * 
	 * @param locatorType  {@code String}
	 * @param locatorValue {@code String}
	 */

	public static void actionClass(String locatorType, String locatorValue) {

		Actions action = new Actions(Constants.driver);
		WebElement ele = getWebElement(locatorType, locatorValue);
		action.moveToElement(ele).build().perform();
	}

	/**
	 * This Method is use to select DropDown value
	 * 
	 * @param locatorType  {@code String}
	 * @param locatorValue {@code String}
	 * @param textToEnter  {@code String}
	 */
	public static void dropDownSelection(String locatorType, String locatorValue, String textToEnter) {
		Select select = new Select(getWebElement(locatorType, locatorValue));
		select.selectByVisibleText(textToEnter);
	}

	/**
	 * This Method is use to Frame Switch
	 * 
	 * @param locatorType  {@code Strining}
	 * @param locatorValue {@code Strining}
	 */
	public static void frameSelection(String locatorType, String locatorValue) {
		Constants.driver.switchTo().frame(getWebElement(locatorType, locatorValue));

	}

	/**
	 * This Method is use to Display text.
	 * 
	 * @param locatorType  {@code Strining}
	 * @param locatorValue {@code Strining}
	 */
	public static void displayText(String locatorType, String locatorValue) {
		WebElement text = getWebElement(locatorType, locatorValue);
		System.out.println(text.getText());
	}

	/**
	 * This Method is use to Element
	 * 
	 * @param locatorType  {@code Strining}
	 * @param locatorValue {@code Strining}
	 * @return
	 */
	public static boolean isPresent(String locatorType, String locatorValue) {
		if (getWebElements(locatorType, locatorValue).size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * This Method is Use to Drag and Drop Operation on web element.
	 * 
	 * @param locatorType   {@code Strining}
	 * @param locatorValue  {@code Strining}
	 * @param locatorType1  {@code Strining}
	 * @param locatorValue1 {@code Strining}
	 */
	public static void dragAnddrop(String locatorType, String locatorValue, String locatorType1, String locatorValue1) {
		WebElement from = getWebElement(locatorType, locatorValue);
		WebElement to = getWebElement(locatorType1, locatorValue1);
		Actions action = new Actions(Constants.driver);
		action.dragAndDrop(from, to).build().perform();
	}
}

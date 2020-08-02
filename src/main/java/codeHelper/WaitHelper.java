package codeHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WaitHelper {
	public boolean waitForPresenceOfElement(AppiumDriver<MobileElement> driver, WaitParameters param) {
		boolean result = false;
		
		WebDriverWait wait = new WebDriverWait(driver, param.getTime());
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param.getXpath())));
			result = true;
		} catch (Exception ex) {
			System.out.println("Exception while locating path while searching Presence in DOM" + param.getXpath() + " >> " + ex.getMessage());
		}
		return result;
	}

	public boolean waitForButtonToBeClickable(AppiumDriver<MobileElement> driver, WaitParameters param) {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(driver, param.getTime());
		try {
			if (waitForPresenceOfElement(driver, param)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(param.getXpath())));
				result = true;
			} else {
				result = false;
			}
			
		} catch (Exception ex) {
			System.out.println("Exception while locating path " + param.getXpath() + " >> " + ex.getMessage());
		}
		return result;
	}
	
	public boolean waitForElementToBeVisible(AppiumDriver<MobileElement> driver, WaitParameters param) {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(driver, param.getTime());
		try {
			if (waitForPresenceOfElement(driver, param)) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(param.getXpath())));
				result = true;
			} else {
				result = false;
			}
			
		} catch (Exception ex) {
			System.out.println("Exception while locating path " + param.getXpath() + " >> " + ex.getMessage());
		}
		return result;
	}
}

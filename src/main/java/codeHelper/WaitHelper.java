package codeHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;

public class WaitHelper {
	public boolean waitForPresenceOfElement(AppiumDriver<MobileElement> driver, WaitParameters param) {
		boolean result = false;

		WebDriverWait wait = new WebDriverWait(driver, param.getTime());
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(param.getXpath())));
			result = true;
		} catch (Exception ex) {
			if (param.getLog()) {
				System.out.println("Exception while locating path while searching Presence in DOM" + param.getXpath()
						+ " >> " + ex.getMessage());
			}
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
	public String waitForAlert(AppiumDriver<MobileElement> driver, int time) {
		String alert="";
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
	alert=wait.until(ExpectedConditions.alertIsPresent()).getText();}
		catch(Exception ex) {		
		}
	return alert;
	}
	public boolean waitToFit(AppiumDriver<MobileElement> driver, WaitParameters param) {
		boolean result=false;
		WebDriverWait wait = new WebDriverWait(driver, param.getTime());
		result=wait.until(pageIsZoomedOutToFitElement(param.getXpath()));
		return result;
	}
	ExpectedCondition<Boolean> pageIsZoomedOutToFitElement(final String arg){
		return new ExpectedCondition<Boolean>(){

			@SuppressWarnings("unchecked")
			public Boolean apply(WebDriver driver) {
				boolean result=false;
				PinchHelper pinch=new PinchHelper();
				
				pinch.zoomOut(((AppiumDriver<MobileElement>)driver));
				
				result=((AppiumDriver<MobileElement>)driver).findElement(By.xpath(arg)).isDisplayed();
				//System.out.println("Element >> "+result);
				
				return result;
			}
		};
	}
}

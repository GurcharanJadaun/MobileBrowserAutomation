package assigment.StepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import assigment.DriverScript.DriverScript;
import codeHelper.WaitHelper;
import codeHelper.WaitParameters;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LoginDefinition extends DriverScript {

	@Given("^Browser window is open on mobile$")
	public void Browser_is_running_on_device() {
		boolean result = driver.queryAppState(appDetails.get("name")).toString().contains("RUNNING_IN_FOREGROUND");
		Assert.assertTrue(result);
	}

	@SuppressWarnings("deprecation")
	@When("^User hits login URL \"([^\"]*)\"$")
	public void user_hits_login_URL(String arg1) {
		boolean result = false;

		WaitHelper wait = new WaitHelper();
		WaitParameters param = new WaitParameters();
		param.setXpath(repository.get("SearchBar").toString());
		param.setTime(20);
		try {
			if (wait.waitForElementToBeVisible(driver, param)) {
				MobileElement ele = driver.findElement(By.xpath(param.getXpath()));
				ele.click();
				ele.clear();
				driver.getKeyboard().sendKeys(arg1);
				Thread.sleep(500);
				driver.getKeyboard().sendKeys(Keys.ENTER);
				Thread.sleep(500);
				driver.hideKeyboard();
				Thread.sleep(500);
				result = true;
			}
		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
			result = false;
		}
		Assert.assertTrue(result);
	}

	@Given("^\"([^\"]*)\" element is displayed$")
	public void element_is_displayed(String arg1) {
		boolean result = false;
		WaitHelper wait = new WaitHelper();
		WaitParameters param = new WaitParameters();

		param.setXpath(repository.get(arg1).toString());
		param.setTime(20);
		result = wait.waitForPresenceOfElement(driver, param);
		Assert.assertTrue(result);
	}

	@When("^User enters \"([^\"]*)\" in \"([^\"]*)\" text field$")
	public void user_enters_data_in_fieldLabel_text_field(String data, String locator) {
		boolean result = false;
		WaitHelper wait = new WaitHelper();
		WaitParameters param = new WaitParameters();

		param.setXpath(repository.get(locator).toString());
		param.setTime(20);
		if (wait.waitForElementToBeVisible(driver, param)) {
			try {
				MobileElement ele = driver.findElement(By.xpath(param.getXpath()));
				ele.click();
				Thread.sleep(1000);
				driver.getKeyboard().sendKeys(data);
				Thread.sleep(1000);
				driver.hideKeyboard();
				Thread.sleep(1000);
				result = true;
			} catch (Exception ex) {
				System.out.println("Exception >>" + ex.getMessage());
			}
		}
		Assert.assertTrue(result);
	}

	@When("^User taps \"([^\"]*)\" Button$")
	public void user_taps_Button(String arg1) {
		boolean result = false;
		WaitHelper wait = new WaitHelper();
		WaitParameters param = new WaitParameters();

		param.setXpath(repository.get(arg1));
		param.setTime(20);

		if (wait.waitForButtonToBeClickable(driver, param)) {
			try {
				driver.findElement(By.xpath(param.getXpath())).click();
				result = true;
			} catch (Exception ex) {
				System.out.println("Exception>> " + ex.getMessage());
			}
		} else {
			System.out.println("Button Not Clickable");
		}

		Assert.assertTrue(result);
		// get rid of remember password toast

		param.setXpath(repository.get("RememberLoginToast"));
		param.setTime(2);
		param.setLog(false);
		if (wait.waitForElementToBeVisible(driver, param)) {
			driver.findElement(By.xpath(repository.get("NeverButton"))).click();
		}
	}

	@Then("^The \"([^\"]*)\" element should be displayed$")
	public void the_element_should_be_displayed(String arg1) {
		boolean result = false;
		WaitHelper wait = new WaitHelper();
		WaitParameters param = new WaitParameters();
		param.setXpath(repository.get(arg1).toString());
		param.setTime(20);
		result = wait.waitForPresenceOfElement(driver, param);
		Assert.assertTrue(result);
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.closeApp();
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.HOME));
		boolean result = driver.queryAppState(appDetails.get("name")).toString().contains("NOT_RUNNING");
		Assert.assertTrue(result);
	}

	@Then("^An alert with text \"([^\"]*)\" should appear$")
	public void an_alert_with_text_should_appear(String message) {
		boolean result = false;
		WaitHelper wait = new WaitHelper();
		result = wait.waitForAlert(driver, 5).contains(message);
		Assert.assertTrue(result);
	}

	@Then("^On accepting the alert$")
	public void On_accepting_the_alert() {
		boolean result = false;
		try {
			driver.switchTo().alert().accept();
			result = true;
		} catch (Exception ex) {
			result = false;
		}
		Assert.assertTrue(result);
		WaitHelper wait = new WaitHelper();
		WaitParameters param = new WaitParameters();
		param.setXpath(repository.get("RememberLoginToast"));
		param.setTime(3);
		param.setLog(false);
		if (wait.waitForElementToBeVisible(driver, param)) {
			driver.findElement(By.xpath(repository.get("NeverButton"))).click();
		}
	}
	@When("^Zoom out such that \"([^\"]*)\" element is visible$")
	public void zoom_out_such_that_element_is_visible(String element) {
		boolean result = false;
		WaitHelper wait = new WaitHelper();
		WaitParameters param = new WaitParameters();
		param.setXpath(repository.get(element).toString());
		param.setTime(20);	
		result=wait.waitToFit(driver, param);
		Assert.assertTrue(result);
	}
}

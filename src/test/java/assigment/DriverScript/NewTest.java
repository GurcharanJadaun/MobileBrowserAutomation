package assigment.DriverScript;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import assigment.setupMaster.DesiredCapabilitySetup;
import codeHelper.WaitHelper;
import codeHelper.WaitParameters;
import codeHelper.WorkBookReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NewTest {
	AppiumDriver<MobileElement> driver = null;
	HashMap<String, String> repository = new HashMap<String, String>();
	HashMap<String, String> map = new HashMap<String, String>();

	//@Parameters({ "type", "name" })
	@BeforeTest
	public void beforeTest() {
		map.put("type", "App");
		String name="duck";
		if (name.equalsIgnoreCase("firefox")) {
			map.put("name", "org.mozilla.firefox");
			map.put("activity", "org.mozilla.gecko.BrowserApp");
		} else if (name.equalsIgnoreCase("chrome")) {
			map.put("name", "com.android.chrome");
			map.put("activity", "com.google.android.apps.chrome.Main");
		}else if(name.equalsIgnoreCase("duck")) {
			
			map.put("name", "com.duckduckgo.mobile.android");
			map.put("activity", "com.duckduckgo.app.browser.BrowserActivity");
			}

		DesiredCapabilitySetup cap = new DesiredCapabilitySetup();
		driver = cap.setDesiredCapabilities(driver, map);
		WorkBookReader read = new WorkBookReader();
		repository = read.getWorkBook("/src/main/resources/com/Repository/NativeObjectRepository.xls");
	}

	@BeforeClass
	public void beforeClass() {
		}
	@Test
	public void test() {
		WaitHelper wait=new WaitHelper();
		String arg1="https://the-internet.herok.com/login";
		WaitParameters param=new WaitParameters();
System.out.println("URL in Test  "+ arg1);
		param.setXpath(repository.get("SearchBar").toString());
		param.setTime(20);
		try {
			if(wait.waitForElementToBeVisible(driver, param)) {
			MobileElement ele=driver.findElement(By.xpath(param.getXpath()));
			ele.click();
			//ele.sendKeys(arg1);
			ele.clear();
			driver.getKeyboard().sendKeys(arg1); 
			Thread.sleep(500);
			driver.getKeyboard().sendKeys(Keys.ENTER); 
			driver.hideKeyboard();
			}
		} catch (Exception ex) {
			System.out.println("Exception "+ex.getMessage());}
		
	}
	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {
		//driver.closeApp();
	}
}

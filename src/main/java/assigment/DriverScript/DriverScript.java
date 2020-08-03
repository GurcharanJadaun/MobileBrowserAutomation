package assigment.DriverScript;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import assigment.setupMaster.DesiredCapabilitySetup;
import assigment.setupMaster.DeviceMaster;
import codeHelper.WorkBookReader;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
@CucumberOptions(features = "src/main/java/assigment/FeatureFiles", glue = { "assigment/StepDefination" },format="pretty",plugin= {"html:target/cucumber-html-report","pretty:target/report.txt"})
public class DriverScript extends AbstractTestNGCucumberTests {
	 DeviceMaster device=new DeviceMaster();
	 protected static  AppiumDriver<MobileElement> driver=null;
	 protected static HashMap<String,String> repository=new HashMap<String,String>();
	 protected static HashMap<String, String> appDetails = new HashMap<String, String>();
	 
	 @Parameters({ "type", "name"})
	 @BeforeTest
		public void beforeTest(String type, String name) {
		
		 appDetails.put("type", "App");
			if (name.equalsIgnoreCase("firefox")) {
				appDetails.put("name", "org.mozilla.firefox");
				appDetails.put("activity", "org.mozilla.gecko.BrowserApp");				
				
			} else if (name.equalsIgnoreCase("chrome")) {
				appDetails.put("name", "com.android.chrome");
				appDetails.put("activity", "com.google.android.apps.chrome.Main");			
			}else if(name.equalsIgnoreCase("duck")) {
				
				appDetails.put("name", "com.duckduckgo.mobile.android");
				appDetails.put("activity", "com.duckduckgo.app.browser.BrowserActivity");
				}

			WorkBookReader read=new WorkBookReader();
			repository=read.getWorkBook("/src/main/resources/com/Repository/ObjectRepository.xls");
			device.setAppiumDriverForApplication(appDetails);
			driver=device.driver;
			if(driver==null) {
				System.exit(0);
			}
			
	 }

	@AfterTest
	public void endSession() {
		
	}
}

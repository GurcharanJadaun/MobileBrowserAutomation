package assigment.setupMaster;

import java.util.HashMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DeviceMaster {
	public AppiumDriver<MobileElement> driver = null;

	public void setAppiumDriverForBrowser(String browserName) {
		DesiredCapabilitySetup cap = new DesiredCapabilitySetup();
		driver = cap.setDesiredCapabilities(driver, browserName);
	}

	public void setAppiumDriverForApplication(String appLocation, String appName) {
		DesiredCapabilitySetup cap = new DesiredCapabilitySetup();
		driver = cap.setDesiredCapabilities(driver, (appLocation + "/" + appName));
	}
	public void setAppiumDriverForApplication(HashMap<String,String> map) {
		DesiredCapabilitySetup cap = new DesiredCapabilitySetup();
		driver = cap.setDesiredCapabilities(driver, map);
	}

}

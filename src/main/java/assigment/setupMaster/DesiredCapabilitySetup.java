package assigment.setupMaster;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DesiredCapabilitySetup {
 public AppiumDriver<MobileElement> setDesiredCapabilities(AppiumDriver<MobileElement> driver,String map){
	 
	 DesiredCapabilities cap=new DesiredCapabilities();
	 
	 cap.setCapability(MobileCapabilityType.BROWSER_NAME, map);	 
	 cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	 cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
	 cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
	 cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Small_Device");
	 cap.setCapability(MobileCapabilityType.UDID, "ZH8005ZMX7");
	 try {
		 driver=new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	 }catch(Exception ex) {
		 System.out.println("Problem While Setting up the driver>>"+ex.getMessage());
	 }
	return driver;
	 
 }
public AppiumDriver<MobileElement> setDesiredCapabilities(AppiumDriver<MobileElement> driver,HashMap<String,String> AppDetails){
	 
	 DesiredCapabilities cap=new DesiredCapabilities();
	 
	 if(AppDetails.get("type").equalsIgnoreCase("App")) {
	 cap.setCapability("appPackage", AppDetails.get("name"));
	 cap.setCapability("appActivity", AppDetails.get("activity"));
	 }
	 cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	 cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1");
	 cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
	// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.1.107:5555");
	 cap.setCapability(MobileCapabilityType.UDID, "ZH8005ZMX7");
	 cap.setCapability("newCommandTimeout", 300);
	 try {
		 driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	 }catch(Exception ex) {
		 System.out.println("Problem While Setting up the driver>>"+ex.getMessage());
	 }
	return driver;
	 
 }
}

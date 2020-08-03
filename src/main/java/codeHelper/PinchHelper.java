package codeHelper;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PinchHelper {

	public void zoomOut(AppiumDriver<MobileElement> driver) {
		Dimension size = driver.manage().window().getSize();

		TouchAction finger1 = new TouchAction(driver);
		TouchAction finger2 = new TouchAction(driver);

		finger1.press(PointOption.point((int) (size.width * 0.5), (int) (size.height * 0.5)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300)))
				.moveTo(PointOption.point((int) (size.width * 0.9), (int) (size.height * 0.75))).release();// waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300)));

		finger2.press(PointOption.point((int) (size.width * 0.5), (int) (size.height * 0.5)))
				.moveTo(PointOption.point((int) (size.width * 0.1), (int) (size.height * 0.25))).release();

		MultiTouchAction actions = new MultiTouchAction(driver);
		actions.add(finger1);
		actions.add(finger2);

		actions.perform();

	}
}

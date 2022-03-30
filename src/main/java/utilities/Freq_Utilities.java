package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Freq_Utilities {

	AndroidDriver<AndroidElement> driver;

	public Freq_Utilities(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;

	}

	public void scrollToText(String text) {

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))");

	}

}

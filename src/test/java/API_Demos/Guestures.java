package API_Demos;

import java.util.concurrent.TimeUnit;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_Pro.Pro.Base;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Guestures extends Base {

	@SuppressWarnings("rawtypes")
	@Test
	public void Guestures_Test() throws IOException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities("apiDemos_App");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		WebElement eLists = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		TouchAction ta = new TouchAction(driver);
		ta.tap(tapOptions().withElement(element(eLists))).perform();
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		WebElement pNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		ta.longPress(longPressOptions().withElement(element(pNames)).withDuration(ofSeconds(2))).release().perform();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed(), true);

	}

}

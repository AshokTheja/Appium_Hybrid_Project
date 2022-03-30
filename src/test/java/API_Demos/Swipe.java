package API_Demos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import Appium_Pro.Pro.Base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class Swipe extends Base {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver = capabilities("apiDemos_App");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		Thread.sleep(1000);
		TouchAction ta = new TouchAction(driver);
		WebElement source = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement dest = driver.findElementByXPath("//*[@content-desc='45']");
		ta.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2))).moveTo(element(dest))
				.release().perform();

	}

}

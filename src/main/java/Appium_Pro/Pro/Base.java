package Appium_Pro.Pro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	public static AppiumDriverLocalService service;

	public void startServer() {

		boolean flag = checkIfServerIsRunning(4723);

		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}

	}

	public void stopServer() {

		service.stop();
		boolean flag = checkIfServerIsRunning(4723);
		if (!flag) {
			System.out.println("=> Server Closed Successfully");
		} else {
			System.out.println("=> Server Close Failed");
		}

	}

	public static boolean checkIfServerIsRunning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;

		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();

		} catch (IOException e) {

		} finally {
			serverSocket = null;
		}

		return isServerRunning;

	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Appium_Pro\\Pro\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		File appDir = new File("Apps");
		File app = new File(appDir, prop.getProperty(appName));
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("device_pixel4a"));
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		return driver;

	}

}

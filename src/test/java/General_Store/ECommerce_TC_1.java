package General_Store;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Appium_Pro.Pro.Base;
import GeneralStore_POs.CheckoutPage;
import GeneralStore_POs.FormPage;
import GeneralStore_POs.ProductsPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.Freq_Utilities;

public class ECommerce_TC_1 extends Base {

	public AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void beforeTest() throws IOException {

		startServer();
		driver = capabilities("generalStore_App");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void totalValidation() throws IOException, InterruptedException {

		FormPage formPage = new FormPage(driver);
		ProductsPage prodPage = new ProductsPage(driver);
		Freq_Utilities utils = new Freq_Utilities(driver);
		CheckoutPage chkoutPage = new CheckoutPage(driver);

		formPage.nameField.sendKeys("Mrs. Mam");
		driver.hideKeyboard();
		formPage.femaleOption.click();
		utils.scrollToText("Argentina");
		formPage.countryArgentina.click();
		Thread.sleep(1000);
		formPage.letsShop.click();
		Thread.sleep(2000);
		prodPage.pg3_AddtoCart.click();
		prodPage.gotoCart.click();
		Thread.sleep(1000);
		String prodPrice = chkoutPage.getProductPrice();
		String bilngPrice = chkoutPage.getBillingPrice();

		System.out.println(prodPrice);
		System.out.println(bilngPrice);

		Assert.assertEquals(prodPrice, bilngPrice);

	}

	@AfterMethod
	public void afterTest() {
		stopServer();
	}

}

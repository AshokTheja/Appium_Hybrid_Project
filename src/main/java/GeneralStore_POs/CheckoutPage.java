package GeneralStore_POs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {

	public CheckoutPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public WebElement productPrice;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement billingAmount;

	public String getProductPrice() {

		String prodPrice = productPrice.getText();
		prodPrice = prodPrice.replace(" ", "");
		return prodPrice;

	}

	public String getBillingPrice() {

		String bilngPrice = billingAmount.getText();
		bilngPrice = bilngPrice.replace(" ", "");
		return bilngPrice;

	}
}

package GeneralStore_POs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "android:id/text1")
	public WebElement countrySelection;

	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement nameField;

	@AndroidFindBy(xpath = "//*[@text='Female']")
	public WebElement femaleOption;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShop;

	@AndroidFindBy(xpath = "//*[@text='Argentina']")
	public WebElement countryArgentina;

}

package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageSteps extends BasePage {

    @AndroidFindBy(id = "android:id/text1")
    private MobileElement country_name_selection;

    @AndroidBy(id="com.androidsample.generalstore:id/nameField")
    private MobileElement name_field;

    @AndroidBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private MobileElement submit_btn;


    public void input_country_name(String country) {
        click(country_name_selection, "Select country name please");
        scrollToText(country);
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='" + country + "']")).click();
    }

    public void input_field_name(String name) {
        sendKeys(name_field, name);
    }

    public void click_submit_btn() {
        click(submit_btn, "Click Let's Shop button");
    }
}

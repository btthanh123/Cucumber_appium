package pages;

import io.appium.java_client.pagefactory.AndroidBy;
import org.openqa.selenium.By;

public class ItemPageSteps extends BasePage {

    public void add_item_to_card(int numberItem) {
        String xpathItem = "//android.widget.TextView[@text='ADD TO CART']";
        for (int i = 0; i < numberItem; i++) {
            getListElementByXpath(xpathItem).get(0).click();
        }
    }
}

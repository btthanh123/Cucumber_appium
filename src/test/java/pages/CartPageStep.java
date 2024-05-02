package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.swing.text.Element;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CartPageStep extends BasePage {
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private MobileElement id_Cart;

    @AndroidFindBy(xpath="//*[@resource-id='com.androidsample.generalstore:id/productName']")
    private List<WebElement> list_item_xpath;

    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    private List<WebElement> list_prices;


    public void go_to_Cart_page() {
        click(id_Cart, "Go to the Card page");
    }

    public void verify_number_item(String number_item) {
        List<WebElement> list_item = getListElementByXpath(String.valueOf(list_item_xpath));
        Assert.assertEquals(list_item.size(), parseInt(number_item));
    }

    public void verify_total_amount(Double total_amount) {
        double totalSum = getProductSum();
        total_amount = getTotalAmountDisplayed();
        if(totalSum != total_amount){
            Assert.fail("The total amount is not displayed correctly. Please verify again!");
        }
    }

    public double getProductSum() {
        List<WebElement> productList = getListElementById("com.androidsample.generalstore:id/productPrice");
        int count = productList.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++) {
            String amountString = productList.get(i).getText();
            double price = getFormattedAmount(amountString);
            totalSum = totalSum + price;
        }
        return totalSum;
    }

    public Double getTotalAmountDisplayed(){
        return getFormattedAmount(getElementById("com.androidsample.generalstore:id/totalAmountLbl").getText());
    }
}

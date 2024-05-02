package defs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPageStep;

import java.util.List;
import java.util.Map;

public class cartPageDef {
    CartPageStep cartPageStep = new CartPageStep();

    @And("I go to Cart page")
    public void iGoToCartPage() {
        cartPageStep.go_to_Cart_page();
    }

    @Then("I verify the order with information displayed as the table below")
    public void iVerifyTheOrderWithInformationDisplayedAsTheTableBelow(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String number_item = columns.get("Number item");
            String total_amount = columns.get("Total Amount");
            cartPageStep.verify_number_item(number_item);
            cartPageStep.verify_total_amount(Double.valueOf(total_amount));
        }
    }
}

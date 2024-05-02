package defs;

import io.cucumber.java.en.And;
import pages.ItemPageSteps;

public class ItemPageDefs_2 {

    ItemPageSteps itemPageSteps = new ItemPageSteps();

    @And("I want to add {string} items in the card")
    public void iWantToAddItemsInTheCard(String numberItem) {
        itemPageSteps.add_item_to_card(Integer.parseInt(numberItem));
    }
}

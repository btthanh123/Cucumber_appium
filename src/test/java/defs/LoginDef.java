package defs;

import io.cucumber.java.en.When;
import pages.LoginPageSteps;

public class LoginDef {
    LoginPageSteps loginPageSteps = new LoginPageSteps();


    @When("I login in General Store app with country {string} and name {string}")
    public void iLoginInGeneralStoreAppWithCountryAndName(String country, String name) {
        loginPageSteps.input_country_name(country);
        loginPageSteps.input_field_name(name);
        loginPageSteps.click_submit_btn();
    }
}

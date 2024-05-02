package defs;

import io.cucumber.java.en.And;
import pages.LoginWebSteps;

public class LoginWebDef {
    LoginWebSteps loginWebSteps = new LoginWebSteps();

    @And("I access the link {string}")
    public void iAccessTheLink(String link) {
        loginWebSteps.access_link(link);
    }
}

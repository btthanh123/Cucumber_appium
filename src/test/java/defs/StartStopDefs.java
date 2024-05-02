package defs;

import Basic.AppiumTestBase;
import Basic.BrowserTestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.net.MalformedURLException;

public class StartStopDefs {
    AppiumTestBase appiumTestBase = new AppiumTestBase();
    BrowserTestBase browserTestBase = new BrowserTestBase();

    @And("I stop app android")
    public void iStopAppAndroid() {
        appiumTestBase.stopServer();
    }

    @Given("I am on General Store app")
    public void iAmOnGeneralStoreApp() throws MalformedURLException {
//        AppiumTestBase.setup();
    }

    @Given("I want to open a chrome browser on mobile test")
    public void iWantToOpenAChromeBrowserOnMobileTest() throws MalformedURLException {
        browserTestBase.setup();
    }

}

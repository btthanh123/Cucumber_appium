package pages;

public class LoginWebSteps extends BasePage {
    LoginWebPageSteps loginWebPageSteps = new LoginWebPageSteps();

    public void access_link(String link) {
        loginWebPageSteps.access_link(link);
    }
}

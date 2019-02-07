package lesson6.steps;

import cucumber.api.java.en.When;
import lesson6.SelenideIndexPage;

public class ActionsSteps {
    @When("^I login as user '([^\"]*)' with password '([^\"]*)'$")
    public void iLoginAsUserWithPassword(String username, String password) {
        new SelenideIndexPage().login(username, password);
    }
}

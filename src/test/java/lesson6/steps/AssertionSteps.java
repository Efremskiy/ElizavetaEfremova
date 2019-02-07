package lesson6.steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import lesson6.SelenideIndexPage;

public class AssertionSteps {
    @Then("^User name should be '([^\"]*)'$")
    public void userNameShouldBe(String expectedUserName) {
        new SelenideIndexPage().getUserName().shouldBe(Condition.text(expectedUserName));
    }
}

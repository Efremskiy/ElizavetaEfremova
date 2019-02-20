package homeworks.hw6.ex2.steps;

import cucumber.api.java.en.Given;
import homeworks.hw6.enums.PageMainData;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {
    @Given("^I am on 'Home Page'$")
    public void openSite() {
        open(PageMainData.URL.toString());
    }
}

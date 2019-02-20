package homeworks.hw6.ex1.steps;

import cucumber.api.java.en.Given;
import homeworks.hw6.enums.PageMainData;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {
    @Given("^I open EPAM JDI site$")
    public void openSite() {
        open(PageMainData.URL.toString());
    }
}

package lesson6.steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.*;

public class NavigationSteps {

    private static final String INDEX_PAGE_URL = "https://epam.github.io/JDI/index.html";
    @Given("^I open EPAM JDI site$")
    public void iOpenEPAMJDISite() {
        open(INDEX_PAGE_URL);
    }


}

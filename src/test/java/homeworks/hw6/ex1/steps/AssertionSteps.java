package homeworks.hw6.ex1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.hw6.GherkinDifferentElementsPage;
import homeworks.hw6.GherkinIndexPage;
import homeworks.hw6.enums.PageMainData;
import homeworks.hw6.enums.ServiceDropdownElements;
import homeworks.hw6.enums.SupportOptions;
import homeworks.hw6.enums.Users;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private GherkinIndexPage indexPage = page(GherkinIndexPage.class);
    private GherkinDifferentElementsPage elementsPage = page(GherkinDifferentElementsPage.class);

    @Then("^Browser title should be '([^\"]*)'$")
    public void browserTitleShouldBe(PageMainData title) {
        indexPage.titleCheck(title.toString());
    }

    @And("^Home Page contains all needed elements$")
    public void homePageContainsAllNeededElements() {
        indexPage.mainContentCheck();
    }

    @Then("^User name should be '([^\"]*)'$")
    public void userNameShouldBe(Users user) {
        indexPage.isLogged(user);
    }

    @Then("^Header dropdown contains options:$")
    public void headerDropdownContainsOptions(List<ServiceDropdownElements> elements) {
        indexPage.headerDropdownCheck(elements);
    }

    @Then("^Left dropdown contains options:$")
    public void leftDropdownContainsOptions(List<ServiceDropdownElements> elements) {
        indexPage.leftDropdownCheck(elements);
    }

    @Then("^Different Elements Page contains all needed elements$")
    public void differentElementsPageContainsAllNeededElements() {
        elementsPage.mainInterfaceCheck();
    }

    @And("^There is right section$")
    public void thereIsRightSection() {
        elementsPage.rightSectionCheck();
    }

    @And("^There is left section$")
    public void thereIsLeftSection() {
        elementsPage.leftSectionCheck();
    }

    @Then("^Elements are marked as '([^\"]*)' on logs:$")
    public void elementsAreMarkedAsTrueOnLogs(boolean mark, List<SupportOptions> elements) {
        elementsPage.checkboxLogsCheck(mark, elements);
    }

    @Then("^Log is correct for metal '([^\"]*)'$")
    public void logIsCorrectForMetal(SupportOptions metal) {
        elementsPage.radioLogsCheck(metal);
    }

    @Then("^Log is correct for color '([^\"]*)'$")
    public void logIsCorrectForColor(SupportOptions color) {
        elementsPage.dropdownLogsCheck(color);
    }
}

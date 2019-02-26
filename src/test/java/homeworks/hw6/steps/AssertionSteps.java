package homeworks.hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.hw6.GherkinDifferentElementsPage;
import homeworks.hw6.GherkinIndexPage;
import homeworks.hw6.GherkinUserTablePage;
import homeworks.hw6.enums.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private GherkinIndexPage indexPage = page(GherkinIndexPage.class);
    private GherkinDifferentElementsPage elementsPage = page(GherkinDifferentElementsPage.class);
    private GherkinUserTablePage userTablePage = page(GherkinUserTablePage.class);

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

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void dropdownsAreDisplayed(int quantity) {
        userTablePage.dropdownsCheck(quantity);
    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayed(int quantity) {
        userTablePage.usernamesCheck(quantity);
    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayed(int quantity) {
        userTablePage.imagesCheck(quantity);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void textsUnderImagesAreDisplayed(int quantity) {
        userTablePage.descriptionTextsCheck(quantity);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayed(int quantity) {
        userTablePage.checkboxesCheck(quantity);
    }

    @And("^User table contains following values:$")
    public void userTableContainsValues(List<SuperHeroes> heroes) {
        userTablePage.superHeroesCheck(heroes);
    }

    @Then("^(\\d+) log row has \"Vip: condition changed to\" \'([^\"]*)\' text in log section$")
    public void logHasText(int logSize, boolean condition) {
        userTablePage.logCheck(logSize, condition);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(List<NumberTypeOptions> options) {
        userTablePage.droplistOptionsCheck(options);
    }
}

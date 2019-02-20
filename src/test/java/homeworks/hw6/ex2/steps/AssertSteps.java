package homeworks.hw6.ex2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.hw6.enums.NumberTypeOptions;
import homeworks.hw6.enums.ServiceDropdownElements;
import homeworks.hw6.GherkinIndexPage;
import homeworks.hw6.GherkinUserTablePage;
import homeworks.hw6.enums.SuperHeroes;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertSteps {
    private GherkinIndexPage indexPage = page(GherkinIndexPage.class);
    private GherkinUserTablePage userTablePage = page(GherkinUserTablePage.class);

    @Then("^'([^\"]*)' page is opened$")
    public void userTablePageIsOpened(ServiceDropdownElements element) {
        indexPage.titleCheck(element.toString());
    }

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayedOnUsersTableOnUserTablePage(int quantity) {
        userTablePage.dropdownsCheck(quantity);
    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage(int quantity) {
        userTablePage.usernamesCheck(quantity);
    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage(int quantity) {
        userTablePage.imagesCheck(quantity);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage(int quantity) {
        userTablePage.descriptionTextsCheck(quantity);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage(int quantity) {
        userTablePage.checkboxesCheck(quantity);
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(List<SuperHeroes> heroes) {
        userTablePage.superHeroesCheck(heroes);
    }

    @Then("^(\\d+) log row has \"Vip: condition changed to\" \'([^\"]*)\' text in log section$")
    public void logRowHasVipConditionChangedToTextInLogSection(int logSize, boolean condition) {
        userTablePage.logCheck(logSize, condition);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(List<NumberTypeOptions> options) {
        userTablePage.droplistOptionsCheck(options);
    }
}

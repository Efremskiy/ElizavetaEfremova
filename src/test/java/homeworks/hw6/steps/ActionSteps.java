package homeworks.hw6.steps;

import cucumber.api.java.en.When;
import homeworks.hw6.GherkinDifferentElementsPage;
import homeworks.hw6.GherkinIndexPage;
import homeworks.hw6.GherkinUserTablePage;
import homeworks.hw6.enums.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private GherkinIndexPage indexPage = page(GherkinIndexPage.class);
    private GherkinDifferentElementsPage elementsPage = page(GherkinDifferentElementsPage.class);
    private GherkinUserTablePage userTablePage = page(GherkinUserTablePage.class);

    @When("^I login as user '([^\"]*)'$")
    public void loginAsUser(Users user) {
        indexPage.login(user);
    }

    @When("^I click on \'([^\"]*)\' subcategory in the header$")
    public void clickOnSubcategoryInTheHeader(HeaderItemsData headerItem) {
        indexPage.headerNavigation(headerItem);
    }

    @When("^I click on \"([^\"]*)\" subcategory in the left section$")
    public void clickOnSubcategoryInTheLeftSection(HeaderItemsData headerItem) {
        indexPage.leftNavigation(headerItem);
    }

    @When("^I click on '([^\"]*)' in the header \"Service\" menu$")
    public void openServiceSubpage(ServiceDropdownElements pageName) {
        indexPage.openServicePage(pageName);
    }

    @When("^I select elements:$")
    public void selectElements(List<SupportOptions> elements) {
        elementsPage.selectElements(elements);
    }

    @When("^I select metal '([^\"]*)'$")
    public void selectMetal(SupportOptions metal) {
        elementsPage.selectMetal(metal);
    }

    @When("^I select color '([^\"]*)'$")
    public void selectColor(SupportOptions color) {
        elementsPage.selectColor(color);
    }

    @When("^I select 'vip' checkbox for \'([^\"]*)\'$")
    public void selectCheckboxFor(UserTableUsers user) {
        userTablePage.selectVip(user);
    }

    @When("^I click on dropdown in column \"NumberType\" for user \'([^\"]*)\'$")
    public void clickOnDropdown(UserTableUsers user) {
        userTablePage.numberTypeSelect(user);
    }
}

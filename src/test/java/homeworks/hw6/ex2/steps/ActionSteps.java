package homeworks.hw6.ex2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homeworks.hw6.GherkinIndexPage;
import homeworks.hw6.GherkinUserTablePage;
import homeworks.hw6.enums.HeaderItemsData;
import homeworks.hw6.enums.ServiceDropdownElements;
import homeworks.hw6.enums.UserTableUsers;
import homeworks.hw6.enums.Users;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private GherkinIndexPage indexPage = page(GherkinIndexPage.class);
    private GherkinUserTablePage userTablePage = page(GherkinUserTablePage.class);

    @And("^I login as user '([^\"]*)'$")
    public void loginAsUser(Users user) {
        indexPage.login(user);
    }

    @When("^I click on '([^\"]*)' button in Header$")
    public void iClickOnServiceButtonInHeader(HeaderItemsData headerItem) {
        indexPage.headerNavigation(headerItem);
    }

    @And("^I click on '([^\"]*)' button in Service dropdown$")
    public void iClickOnUserTableButtonInServiceDropdown(ServiceDropdownElements element) {
        indexPage.openServicePage(element);
    }

    @When("^I select 'vip' checkbox for \'([^\"]*)\'$")
    public void iSelectVipCheckboxFor(UserTableUsers user) {
        userTablePage.selectVip(user);
    }

    @When("^I click on dropdown in column \"NumberType\" for user \'([^\"]*)\'$")
    public void iClickOnDropdownInColumnNumberTypeForUserRoman(UserTableUsers user) {
        userTablePage.numberTypeSelect(user);
    }
}

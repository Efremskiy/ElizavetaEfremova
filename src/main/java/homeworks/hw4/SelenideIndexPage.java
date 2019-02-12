package homeworks.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.ServiceDropdownElements;
import homeworks.hw4.enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class SelenideIndexPage {
    @FindBy(css = "#user-icon")
    private SelenideElement loginIcon;

    @FindBy(css = "#name")
    private SelenideElement userField;

    @FindBy(css = "#password")
    private SelenideElement passwordField;

    @FindBy(css = "#login-button")
    private SelenideElement submitButton;

    @FindBy(css = "#user-name")
    private SelenideElement username;

    // TODO This locator can be improved
    //fixed
    @FindBy(css = ".m-l8 .dropdown")
    private SelenideElement headerServiceDropdown;

    @FindBy(css = ".dropdown-menu li a")
    // TODO Use ElementsCollection
    //fixed
    private ElementsCollection headerDropdownElements;

    // TODO This locator can be improved
    //fixed
    @FindBy(css = ".menu-title:nth-of-type(3)")
    private SelenideElement leftServiceDropdown;

    // TODO This locator can be improved
    // TODO Use ElementsCollection
    //fixed
    @FindBy(css = ".menu-title:nth-of-type(3) ul a")
    private ElementsCollection leftDropdownElements;

    // TODO It is not make sense to create one single element for each menu item,
    // TODO use ElementsCollection
    //fixed (headerDropdownElements)

    @FindBy(css = ".dropdown-menu li:nth-of-type(2) a")
    private SelenideElement datesLink;

    public void titleCheck(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void isLogged(Users user) {
        username.shouldBe(visible);
        username.shouldHave(text(user.fullName));
    }

    public void headerDropdownCheck(ServiceDropdownElements[] serviceDropdownElements) {
        headerServiceDropdown.click();
        for (int i = 0; i < serviceDropdownElements.length; i++) {
            headerDropdownElements.get(i).shouldHave(text(serviceDropdownElements[i].toString()));
        }
    }

    public void leftDropdownCheck(ServiceDropdownElements[] serviceDropdownElements) {
        leftServiceDropdown.click();
        for (int i = 0; i < serviceDropdownElements.length; i++) {
            leftDropdownElements.get(i).shouldHave(text(serviceDropdownElements[i].toString()));
        }
    }

    public void openDifferentElementsPage() {
        headerServiceDropdown.click();
        headerDropdownElements.get(6).click();
    }

    public void openDatesPage() {
        headerServiceDropdown.click();
        datesLink.click();
    }
}

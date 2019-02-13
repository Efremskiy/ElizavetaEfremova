package homeworks.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.ServiceDropdownElements;
import homeworks.hw4.enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homeworks.hw4.enums.HeaderItemsData.SERVICE;
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

    @FindBy(css = ".m-l8 .dropdown")
    private SelenideElement headerServiceDropdown;

    @FindBy(css = ".dropdown-menu li a")
    private ElementsCollection headerDropdownElements;

    @FindBy(css = ".sidebar-menu li")
    private ElementsCollection leftSectionElements;

    @FindBy(css = ".menu-title:nth-of-type(3) ul a")
    private ElementsCollection leftDropdownElements;

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
        leftSectionElements.findBy(text(SERVICE.toString())).click();
        for (int i = 0; i < serviceDropdownElements.length; i++) {
            leftDropdownElements.get(i).shouldHave(text(serviceDropdownElements[i].toString()));
        }
    }

    public void openServicePage(ServiceDropdownElements pageName) {
        headerServiceDropdown.click();
        headerDropdownElements.findBy(text(pageName.toString())).click();
    }
}

package homeworks.hw4;

import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.ServiceDropdownElements;
import homeworks.hw4.enums.Users;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css = "nav > ul:nth-of-type(1) > li > a[data-toggle='dropdown']")
    private  SelenideElement headerServiceDropdown;

    @FindBy(css = ".dropdown-menu li a")
    private List<SelenideElement> headerDropdownElements;

    @FindBy(css = ".sidebar-menu > li > a > div")
    private SelenideElement leftServiceDropdown;

    @FindBy(css = ".sidebar-menu > li > ul > li > a * span")
    private List<SelenideElement> leftDropdownElements;

    @FindBy(css = ".dropdown-menu li:nth-of-type(7) a")
    private SelenideElement differentElementsLink;

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
        int i = 0;
        for (SelenideElement element : headerDropdownElements) {
            element.shouldBe(text(serviceDropdownElements[i++].toString()));
        }
    }

    public void leftDropdownCheck(ServiceDropdownElements[] serviceDropdownElements) {
        leftServiceDropdown.click();
        int i = 0;
        for (SelenideElement element : leftDropdownElements) {
            element.shouldBe(text(serviceDropdownElements[i++].toString()));
        }
    }

    public void openDifferentElementsPage() {
        headerServiceDropdown.click();
        differentElementsLink.click();
    }

    public void openDatesPage() {
        headerServiceDropdown.click();
        datesLink.click();
    }
}

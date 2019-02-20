package homeworks.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw6.enums.HeaderItemsData;
import homeworks.hw6.enums.ServiceDropdownElements;
import homeworks.hw6.enums.Users;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homeworks.hw6.enums.HeaderItemsData.SERVICE;
import static org.testng.Assert.assertEquals;

public class GherkinIndexPage {
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

    @FindBy(css = ".m-l8 > li")
    private ElementsCollection headerNavigationSection;

    @FindBy(css = ".dropdown-menu li a")
    private ElementsCollection headerDropdownElements;

    @FindBy(css = ".sidebar-menu li")
    private ElementsCollection leftNavigationSection;

    @FindBy(css = ".menu-title:nth-of-type(3) li")
    private ElementsCollection leftDropdownElements;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection icons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection iconTexts;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

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

    public void headerNavigation(HeaderItemsData headerItem) {
        headerNavigationSection.find(text(headerItem.toString())).click();
    }

    public void headerDropdownCheck(List<ServiceDropdownElements> serviceDropdownElements) {
        for (int i = 0; i < serviceDropdownElements.size(); i++) {
            headerDropdownElements.get(i).shouldHave(text(serviceDropdownElements.get(i).toString()));
        }
    }

    public void leftNavigation(HeaderItemsData leftItem) {
        leftNavigationSection.find(text(leftItem.toString())).click();
    }

    public void leftDropdownCheck(List<ServiceDropdownElements> serviceDropdownElements) {
        leftNavigationSection.findBy(text(SERVICE.toString())).click();
        for (int i = 0; i < serviceDropdownElements.size(); i++) {
            leftDropdownElements.get(i).shouldHave(text(serviceDropdownElements.get(i).toString()));
        }
    }

    public void openServicePage(ServiceDropdownElements pageName) {
        headerDropdownElements.findBy(text(pageName.toString())).click();
    }

    public void mainContentCheck() {
        for (SelenideElement icon : icons) {
            icon.shouldBe(visible);
        }
        for (SelenideElement text : iconTexts) {
            text.shouldBe(visible);
        }
        mainTitle.shouldBe(visible);
        mainText.shouldBe(visible);
    }
}

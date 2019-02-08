package homeworks.hw3;

import homeworks.hw3.enums.HeaderItemsData;
import homeworks.hw3.enums.IconsData;
import homeworks.hw3.enums.PageMainData;
import homeworks.hw3.enums.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {
    @FindBy(css = "#user-icon")
    private WebElement loginIcon;

    @FindBy(css = "#name")
    private WebElement userField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#login-button")
    private WebElement submitButton;

    @FindBy(css = "#user-name")
    private WebElement username;

    // TODO This locator can be improved
    @FindBy(css = "nav > ul:nth-of-type(1) > li")
    private List<WebElement> headerItems;

    // TODO This locator can be improved
    @FindBy(css = "nav > ul:nth-of-type(1) > li > a")
    private List<WebElement> headerItemsTexts;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> icons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> iconTexts;

    @FindBy(css = "[.main-title.text-center")
    private WebElement firstMainHeader;

    @FindBy(css = "[.main-txt.text-center")
    private WebElement secondMainHeader;

    @FindBy(css = "#iframe")
    private WebElement iframe;

    @FindBy(css = ".text-center a")
    private WebElement subHeader;

    // TODO This locator can be improved
    @FindBy(css = ".sidebar-menu")
    private WebElement leftSection;

    @FindBy(css = ".footer-bg")
    private WebElement footer;

    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String URL) {
        driver.navigate().to(URL);
    }

    public void titleCheck(String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void isLogged(Users user) {
        assertEquals(username.getText(), user.fullName);
    }

    public void areHeaderItemsDisplayed() {
        for (WebElement headerItem : headerItems) {
            assertTrue(headerItem.isDisplayed());
        }
    }

    public void headerTextsCheck(HeaderItemsData[] headerItemsData) {
        int i = 0;
        for (WebElement headerItemText : headerItemsTexts) {
            assertEquals(headerItemText.getText(), headerItemsData[i++].toString());
        }
    }

    public void areIconsDisplayed() {
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }
    }

    public void iconTextsCheck(IconsData[] iconsData) {
        int i = 0;
        for (WebElement iconText : iconTexts) {
            assertEquals(iconText.getText(), iconsData[i++].toString());
        }
    }

    public void firstMainHeaderCheck(PageMainData firstMainHeaderText) {
        assertTrue(firstMainHeader.isDisplayed());
        assertEquals(firstMainHeader.getText(), firstMainHeaderText.toString());
    }

    public void secondMainHeaderCheck(PageMainData secondMainHeaderText) {
        assertTrue(secondMainHeader.isDisplayed());
        assertEquals(secondMainHeader.getText(), secondMainHeaderText.toString());
    }

    public void isIframeDisplayed() {
        assertTrue(iframe.isDisplayed());
    }

    public void iframeLogoCheck() {
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.className("epam-logo")).isDisplayed());
    }

    public void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }

    public void subHeaderTextCheck(PageMainData subHeaderText) {
        assertEquals(subHeader.getText(), subHeaderText.toString());
    }

    public void subHeaderLinkCheck(PageMainData subHeaderLink) {
        assertEquals(subHeader.getAttribute("href"), subHeaderLink.toString());
    }

    public void isLeftSectionDisplayed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void isFooterDisplayed() {
        assertTrue(footer.isDisplayed());
    }
}

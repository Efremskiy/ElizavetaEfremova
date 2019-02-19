package homeworks.hw5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw5.enums.Logs;
import homeworks.hw5.enums.SupportOptions;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

public class SelenideDifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".main-content .uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".main-content .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".logs > li")
    private ElementsCollection logs;

    @Step("Check interface")
    public void mainInterfaceCheck() {
        checkboxes.shouldHave(size(4));
        radios.shouldHave(size(4));
        dropdown.shouldBe(visible);
        buttons.shouldHave(size(2));
    }

    @Step("Check right section")
    public void isRightSectionDisplayed() {
        rightSection.shouldBe(visible);
    }

    @Step("Check left section")
    public void isLeftSectionDisplayed() {
        leftSection.shouldBe(visible);
    }

    @Step("Select elements")
    public void selectElements(SupportOptions... options) {
        for (SupportOptions option : options) {
            checkboxes.find(text(option.toString())).click();
        }
    }

    @Step("Check if logs are correct")
    public void checkboxLogsCheck(String condition, SupportOptions... options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).getText()
                    .contains(options[i].toString() + Logs.ELEMENTS + condition));
        }
    }

    @Step("Select metal")
    public void selectMetal(SupportOptions... options) {
        for (SupportOptions option : options) {
            radios.find(text(option.toString())).click();
        }
    }

    @Step("Check if logs are correct")
    public void radioLogsCheck(SupportOptions... options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).getText()
                    .contains(Logs.METAL + options[i].toString()));
        }
    }

    @Step("Select color")
    public void selectColor(SupportOptions option) {
        dropdown.click();
        dropdown.selectOption(option.toString());
    }

    @Step("Check if logs are correct")
    public void dropdownLogsCheck(SupportOptions... options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).getText()
                    .contains(Logs.COLOR + options[i].toString()));
        }
    }
}

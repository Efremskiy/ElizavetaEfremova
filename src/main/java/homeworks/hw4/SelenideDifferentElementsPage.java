package homeworks.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.Logs;
import homeworks.hw4.enums.SupportOptions;
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

    public void mainInterfaceCheck() {
        checkboxes.shouldHave(size(4));
        radios.shouldHave(size(4));
        dropdown.shouldBe(visible);
        buttons.shouldHave(size(2));
    }

    public void isRightSectionDisplayed() {
        rightSection.shouldBe(visible);
    }

    public void isLeftSectionDisplayed() {
        leftSection.shouldBe(visible);
    }

    public void selectElements(SupportOptions... options) {
        for (SupportOptions option : options) {
            checkboxes.find(text(option.toString())).click();
        }
    }

    public void checkboxLogsCheck(String condition, SupportOptions... options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).getText()
                    .contains(options[i].toString() + Logs.ELEMENTS + condition));
        }
    }

    public void selectMetal(SupportOptions... options) {
        for (SupportOptions option : options) {
            radios.find(text(option.toString())).click();
        }
    }

    public void radioLogsCheck(SupportOptions... options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).getText()
                    .contains(Logs.METAL + options[i].toString()));
        }
    }

    public void selectColor(SupportOptions option) {
        dropdown.click();
        dropdown.selectOption(option.toString());
    }

    public void dropdownLogsCheck(SupportOptions... options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).getText()
                    .contains(Logs.COLOR + options[i].toString()));
        }
    }
}

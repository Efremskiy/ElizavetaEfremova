package homeworks.hw6;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw6.enums.Logs;
import homeworks.hw6.enums.SupportOptions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

public class GherkinDifferentElementsPage {

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
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(visible);
        }
        for (SelenideElement radio : radios) {
            radio.shouldBe(visible);
        }
        dropdown.shouldBe(visible);
        for (SelenideElement button : buttons) {
            button.shouldBe(visible);
        }
    }

    public void rightSectionCheck() {
        rightSection.shouldBe(visible);
    }

    public void leftSectionCheck() {
        leftSection.shouldBe(visible);
    }

    public void selectElements(List<SupportOptions> options) {
        for (SupportOptions option : options) {
            checkboxes.find(text(option.toString())).click();
        }
    }

    public void checkboxLogsCheck(boolean condition, List<SupportOptions> options) {
        for (int i = 0; i < options.size(); i++) {
            logs.get(options.size()- 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.size() - 1 - i).getText()
                    .contains(options.get(i).toString() + Logs.ELEMENTS + condition));
        }
    }

    public void selectMetal(SupportOptions option) {
        radios.find(text(option.toString())).click();
    }

    public void radioLogsCheck(SupportOptions option) {
        logs.filter(text(Logs.METAL + option.toString())).shouldHave(sizeGreaterThan(0));
    }

    public void selectColor(SupportOptions option) {
        dropdown.click();
        dropdown.selectOption(option.toString());
    }

    public void dropdownLogsCheck(SupportOptions option) {
        logs.filter(text(Logs.COLOR + option.toString())).shouldHave(sizeGreaterThan(0));
    }
}

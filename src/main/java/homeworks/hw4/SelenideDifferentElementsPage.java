package homeworks.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.SupportOptions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SelenideDifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".main-content .uui-form-element")
    private ElementsCollection dropdowns;

    @FindBy(css = ".main-content .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    public void mainInterfaceCheck() {
        assertEquals(checkboxes.size(), 4);
        assertEquals(radios.size(), 4);
        assertEquals(dropdowns.size(), 1);
        assertEquals(buttons.size(), 2);
    }

    public void isRightSectionDisplayed() {
        rightSection.shouldBe(visible);
    }

    public void isLeftSectionDisplayed() {
        leftSection.shouldBe(visible);
    }

    public void selectCheckboxes(SupportOptions[] options) {
        for (SupportOptions option : options) {
            checkboxes.findBy(text(option.toString())).$("input").click();
        }
    }

    public void areCheckboxLogsCorrect(SupportOptions[] options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).text().toUpperCase().contains(options[i].toString()));
            if (logs.get(options.length - 1 - i).text().contains("true")) {
                checkboxes.findBy(text(options[i].toString())).$("input").shouldBe(Condition.selected);
            } else {
                checkboxes.findBy(text(options[i].toString())).$("input").shouldNotBe(Condition.selected);
            }
        }
    }

    public void selectRadios(SupportOptions[] options) {
        for (SupportOptions option : options) {
            radios.findBy(text(option.toString())).$("input").click();
        }
    }

    public void areRadioLogsCorrect(SupportOptions[] options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).text().toUpperCase().contains(options[i].toString()));
        }
    }
    public void selectDropdown(SupportOptions option) {
        String optionCaseSensitive = option.toString().charAt(0) + option.toString().substring(1).toLowerCase();
        dropdowns.get(0).click();
        dropdowns.get(0).selectOption(optionCaseSensitive);
    }

    public void areDropdownLogsCorrect(SupportOptions[] options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).text().toUpperCase().contains(options[i].toString()));
        }
    }
}

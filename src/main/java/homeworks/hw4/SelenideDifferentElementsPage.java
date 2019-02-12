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

    public void selectCheckboxes(SupportOptions... options) {
        // TODO Take a look on ElementsCollection::find method
        //fixed
        for (SupportOptions option : options) {
            checkboxes.find(text(option.toString())).click();
        }
    }

    public void areCheckboxLogsCorrect(String condition, SupportOptions... options) {
        // TODO This is not the best approach.
        // TODO You have to verify actual log rows with expected,
        // TODO verification should not depends on current element status.
        //fixed
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).getText()
                    .contains(options[i].toString() + ": condition changed to " + condition));
        }
    }

    public void selectRadios(SupportOptions... options) {
        // TODO Take a look on ElementsCollection::find method
        //fixed
        for (SupportOptions option : options) {
            radios.find(text(option.toString())).click();
        }
    }

    public void areRadioLogsCorrect(SupportOptions... options) {
        // TODO You can easily verify that the log contains expected string. This will be quite enough
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).getText()
                    .contains("metal: value changed to " + options[i].toString()));
        }
    }

    public void selectDropdown(SupportOptions option) {
        // TODO You have to create 'Utils' class in order to do this transformation
        //fixed
        dropdowns.get(0).click();
        dropdowns.get(0).selectOption(option.toString());
    }

    public void areDropdownLogsCorrect(SupportOptions... options) {
        // TODO You can easily verify that the log contains expected string. This will be quite enough
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).getText()
                    .contains("Colors: value changed to " + options[i].toString()));
        }
    }
}

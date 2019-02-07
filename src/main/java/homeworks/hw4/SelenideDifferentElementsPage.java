package homeworks.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.SupportOptions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SelenideDifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".colors")
    private ElementsCollection dropdowns;

    @FindBy(css = ".main-content .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = "[class='panel-body-list logs'] > li")
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

    public void selectCheckboxesWaterWind() {
        checkboxes.get(0).click();
        checkboxes.get(2).click();
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

    public void selectRadioSelen() {
        radios.get(3).click();
    }

    public void areRadioLogsCorrect(SupportOptions[] options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).text().toUpperCase().contains(options[i].toString()));
        }
    }

    public void selectDropdownYellow() {
        dropdowns.get(0).click();
        dropdowns.get(0).$$("option").findBy(text("Yellow")).click();
    }

    public void areDropdownLogsCorrect(SupportOptions[] options) {
        for (int i = 0; i < options.length; i++) {
            logs.get(options.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(options.length - 1 - i).text().toUpperCase().contains(options[i].toString()));
        }
    }
}

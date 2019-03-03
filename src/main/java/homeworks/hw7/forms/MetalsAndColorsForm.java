package homeworks.hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.hw7.entities.MetalsAndColorsData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {
    @FindBy(css = "#odds-selector")
    private RadioButtons oddsRadio;

    @FindBy(css = "#even-selector")
    private RadioButtons evenRadio;

    @FindBy(css = "#calculate-button")
    private Button calculate;

    @FindBy(css = "#elements-checklist label")
    private WebList elementsChecklist;

    @JDropdown(root = "#colors", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Droplist colorsDropdown;

    @JDropdown(root = "#metals", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Droplist metalsDropdown;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Droplist vegetablesDropdown;

    @FindBy(css = "#submit-button")
    private Button submit;

    @Override
    public void submit(MetalsAndColorsData data) {
        oddsRadio.select(String.valueOf(data.oddSum));
        evenRadio.select(String.valueOf(data.evenSum));
        calculate.click();
        elementsChecklist.select(data.elements);
        colorsDropdown.select(data.color);
        metalsDropdown.select(data.metal);
        String[] options = vegetablesDropdown.getSelected().split(", ");
        for (String option : options) {
            vegetablesDropdown.select(option);
        }
        for(String vegetable : data.vegetables) {
            vegetablesDropdown.select(vegetable);
        }
        submit.click();
    }
}

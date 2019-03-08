package homeworks.hw7.pages;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import homeworks.hw7.entities.Logs;
import homeworks.hw7.entities.MetalsAndColorsData;
import homeworks.hw7.forms.MetalsAndColorsForm;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class MetalsAndColorsPage extends WebPage {

    MetalsAndColorsForm metalsAndColorsForm;

    @FindBy(css = ".results li")
    private WebList logs;

    public void titleCheck() {
        assertEquals(WebDriverFactory.getDriver().getTitle(), this.title);
    }

    public void form(MetalsAndColorsData data) {
        metalsAndColorsForm.submit(data);
    }

    public void resultCheck() {
        assertEquals(logs.get(0).getText(), Logs.SUMMARY.toString() + MetalsAndColorsData.DATA.summary());
        assertEquals(logs.get(1).getText(), Logs.ELEMENTS.toString() +
               String.join(", ", MetalsAndColorsData.DATA.elements));
        assertEquals(logs.get(2).getText(), Logs.COLOR.toString() + MetalsAndColorsData.DATA.color);
        assertEquals(logs.get(3).getText(), Logs.METAL.toString() + MetalsAndColorsData.DATA.metal);
        assertEquals(logs.get(4).getText(), Logs.VEGETABLES.toString() +
                String.join(", ", MetalsAndColorsData.DATA.vegetables));
    }
}

package homeworks.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideDatesPage {
    // TODO This locator should be improved
    @FindBy(css = "[class^='ui-slider-handle']:nth-of-type(1)")
    private SelenideElement fromSlider;

    // TODO This locator should be improved
    @FindBy(css = "[class^='ui-slider-handle']:nth-of-type(2)")
    private SelenideElement toSlider;

    @FindBy(css = "[class^='uui-slider']")
    private SelenideElement sliderBase;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    // TODO You have slight similar 2 methods - moveFromSliderTo and moveToSliderTo
    // TODO It will be better to merge it in single one with two parameter (be careful about code duplication)

    public void moveFromSliderTo(int position) {
        Actions builder = new Actions(getWebDriver());
        int xOffset = (position - Integer.valueOf(fromSlider.$("span").text())) * sliderBase.getSize().width / 100 - 1;
        builder.clickAndHold(fromSlider).moveByOffset(xOffset, 0).release().build().perform();
    }

    public void moveToSliderTo(int position) {
        Actions builder = new Actions(getWebDriver());
        int xOffset = (position - Integer.valueOf(toSlider.$("span").text())) * sliderBase.getSize().width / 100 - 1;
        builder.clickAndHold(toSlider).moveByOffset(xOffset, 0).release().build().perform();
    }

    public void areLogsCorrect(int fromPosition, int toPosition) {
        logs.get(0).shouldHave(text(String.valueOf(toPosition)));
        logs.get(1).shouldHave(text(String.valueOf(fromPosition)));

    }
}

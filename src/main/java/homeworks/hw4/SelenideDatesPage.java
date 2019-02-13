package homeworks.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideDatesPage {

    @FindBy(css = ".ui-slider-handle span")
    private ElementsCollection sliders;

    @FindBy(css = "main .uui-slider")
    private SelenideElement sliderBase;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    public void moveSliderTo(int leftPosition, int rightPosition) {
        Actions builder = new Actions(getWebDriver());
        int leftOffset = (leftPosition - Integer.valueOf(sliders.get(0).text())) *
                sliderBase.getSize().width / 100 - 1;
        int rightOffset = (rightPosition - Integer.valueOf(sliders.get(1).text())) *
                sliderBase.getSize().width / 100 - 1;
        builder.clickAndHold(sliders.get(0)).moveByOffset(leftOffset, 0).release().build().perform();
        builder.clickAndHold(sliders.get(1)).moveByOffset(rightOffset, 0).release().build().perform();
    }

    public void areLogsCorrect(int fromPosition, int toPosition) {
        logs.get(0).shouldHave(text(String.valueOf(toPosition)));
        logs.get(1).shouldHave(text(String.valueOf(fromPosition)));

    }
}

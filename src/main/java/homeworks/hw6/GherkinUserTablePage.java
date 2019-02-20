package homeworks.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw6.enums.Logs;
import homeworks.hw6.enums.NumberTypeOptions;
import homeworks.hw6.enums.SuperHeroes;
import homeworks.hw6.enums.UserTableUsers;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

public class GherkinUserTablePage {
    @FindBy(css = "select")
    private ElementsCollection dropdowns;

    @FindBy(css = "td a")
    private ElementsCollection usernames;

    @FindBy(css = "td img")
    private ElementsCollection images;

    @FindBy(css = ".user-descr")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "tr")
    private ElementsCollection userTableRows;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    @FindBy(css = "select:nth-of-type(1) option")
    private ElementsCollection droplistOptions;

    public void dropdownsCheck(int quantity) {
        dropdowns.shouldHave(size(quantity));
        for (SelenideElement dropdown : dropdowns) {
            dropdown.shouldBe(visible);
        }
    }

    public void usernamesCheck(int quantity) {
        usernames.shouldHave(size(quantity));
        for (SelenideElement username : usernames) {
            username.shouldBe(visible);
        }
    }

    public void imagesCheck(int quantity) {
        images.shouldHave(size(quantity));
        for (SelenideElement image : images) {
            image.shouldBe(visible);
        }
    }

    public void descriptionTextsCheck(int quantity) {
        descriptionTexts.shouldHave(size(quantity));
        for (SelenideElement text : descriptionTexts) {
            text.shouldBe(visible);
        }
    }

    public void checkboxesCheck(int quantity) {
        checkboxes.shouldHave(size(quantity));
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(visible);
        }
    }

    public void superHeroesCheck(List<SuperHeroes> heroes) {
        for (SuperHeroes hero : heroes) {
            userTableRows.findBy(text(String.valueOf(hero.number))).shouldHave(text(hero.user), text(hero.description));
        }
    }

    public void selectVip(UserTableUsers user) {
        checkboxes.get(user.number - 1).click();
    }

    public void logCheck(int logSize, boolean condition) {
        logs.filterBy(text(Logs.VIP.toString() + condition)).shouldHave(size(logSize));
    }

    public void numberTypeSelect(UserTableUsers user) {
        dropdowns.get(user.number - 1).click();
    }

    public void droplistOptionsCheck(List<NumberTypeOptions> options) {
        for (int i = 0; i < options.size(); i++) {
            droplistOptions.get(i).shouldHave(text(options.get(i).toString()));
        }
    }
}

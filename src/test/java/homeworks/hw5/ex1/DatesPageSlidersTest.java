package homeworks.hw5.ex1;

import base.SelenideBase;
import homeworks.hw5.AllureListener;
import homeworks.hw5.SelenideDatesPage;
import homeworks.hw5.SelenideIndexPage;
import homeworks.hw5.enums.PageMainData;
import homeworks.hw5.enums.ServiceDropdownElements;
import homeworks.hw5.enums.Users;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

@Listeners(AllureListener.class)
@Feature("\"Dates\" page test")
public class DatesPageSlidersTest extends SelenideBase {
    private SelenideIndexPage indexPage;
    private SelenideDatesPage datesPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        open(PageMainData.URL.toString());
        indexPage = page(SelenideIndexPage.class);
        datesPage = page(SelenideDatesPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Story("Test main functionality and sliders")
    @Test
    public void datesPageSlidersTest() {
        //2 Assert Browser title
        indexPage.titleCheck(PageMainData.PAGE_TITLE.toString());

        //3 Perform login
        indexPage.login(Users.PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        indexPage.isLogged(Users.PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        indexPage.openServicePage(ServiceDropdownElements.DATES);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most right position
        datesPage.moveSliderTo(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.areLogsCorrect(0, 60);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most left position.
        datesPage.moveSliderTo(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.areLogsCorrect(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position,
        // right slider - the most rigth position.
        datesPage.moveSliderTo(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.areLogsCorrect(100, 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.moveSliderTo(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.areLogsCorrect(30, 70);
    }
}

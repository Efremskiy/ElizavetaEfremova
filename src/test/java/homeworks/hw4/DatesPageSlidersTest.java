package homeworks.hw4;

import base.SelenideBase;
import homeworks.hw4.enums.PageMainData;
import homeworks.hw4.enums.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

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

    @Test
    public void datesPageSlidersTest() {
        //2 Assert Browser title
        indexPage.titleCheck(PageMainData.PAGE_TITLE.toString());

        //3 Perform login
        indexPage.login(Users.PETER_C);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.isLogged(Users.PETER_C);

        //5 Open through the header menu Service -> Dates Page
        indexPage.openDatesPage();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most rigth position
        datesPage.moveSliderTo(0, "left");
        datesPage.moveSliderTo(100, "right");

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.areLogsCorrect(0, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most left position.
        datesPage.moveSliderTo(0, "left");
        datesPage.moveSliderTo(0, "right");

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.areLogsCorrect(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position,
        // right slider - the most rigth position.
        datesPage.moveSliderTo(100, "left");
        datesPage.moveSliderTo(100, "right");

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.areLogsCorrect(100, 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.moveSliderTo(30, "left");
        datesPage.moveSliderTo(70, "right");

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.areLogsCorrect(30, 70);
    }
}

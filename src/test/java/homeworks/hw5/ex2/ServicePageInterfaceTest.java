package homeworks.hw5.ex2;

import base.SelenideBase;
import homeworks.hw4.SelenideDifferentElementsPage;
import homeworks.hw4.SelenideIndexPage;
import homeworks.hw4.enums.PageMainData;
import homeworks.hw4.enums.ServiceDropdownElements;
import homeworks.hw4.enums.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.hw4.enums.SupportOptions.*;

public class ServicePageInterfaceTest extends SelenideBase {

    private SelenideIndexPage indexPage;
    private SelenideDifferentElementsPage differentElementsPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        open(PageMainData.URL.toString());
        indexPage = page(SelenideIndexPage.class);
        differentElementsPage = page(SelenideDifferentElementsPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void servicePageInterfaceTest() {
        //2 Assert Browser title
        indexPage.titleCheck(PageMainData.PAGE_TITLE.toString());

        //3 Perform login
        indexPage.login(Users.PETER_C);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.isLogged(Users.PETER_C);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.headerDropdownCheck(ServiceDropdownElements.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.leftDropdownCheck(ServiceDropdownElements.values());

        //7 Open through the header menu Service -> Different Elements Page
        indexPage.openServicePage(ServiceDropdownElements.DIFFERENT_ELEMENTS);

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.mainInterfaceCheck();

        //9 Assert that there is Right Section
        differentElementsPage.isRightSectionDisplayed();

        //10 Assert that there is Left Section
        differentElementsPage.isLeftSectionDisplayed();

        //11 Select checkboxes
        differentElementsPage.selectElements(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is
        // corresponded to the status of checkbox. 
        differentElementsPage.checkboxLogsCheck("true", WATER, WIND);

        //13 Select radio
        differentElementsPage.selectMetal(SELEN);

        //14 Assert that for radiobutton there is a log row and value is
        // corresponded to the status of radiobutton. 
        differentElementsPage.radioLogsCheck(SELEN);

        //15 Select in dropdown
        differentElementsPage.selectColor(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.dropdownLogsCheck(YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPage.selectElements(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is
        // corresponded to the status of checkbox. 
        differentElementsPage.checkboxLogsCheck("false", WATER, WIND);
    }
}

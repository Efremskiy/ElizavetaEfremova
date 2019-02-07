package homeworks.hw4;

import base.SelenideBase;
import homeworks.hw4.enums.PageMainData;
import homeworks.hw4.enums.ServiceDropdownElements;
import homeworks.hw4.enums.SupportOptions;
import homeworks.hw4.enums.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ServicePageInterfaceTest extends SelenideBase {

    private SelenideServicePage servicePage;
    private SelenideDifferentElementsPage differentElementsPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        open(PageMainData.URL.toString());
        servicePage = page(SelenideServicePage.class);
        differentElementsPage = page(SelenideDifferentElementsPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void servicePageInterfaceTest() {
        //2 Assert Browser title
        servicePage.titleCheck(PageMainData.PAGE_TITLE.toString());

        //3 Perform login
        servicePage.login(Users.PETER_C);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePage.isLogged(Users.PETER_C);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.headerDropdownCheck(ServiceDropdownElements.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        servicePage.leftDropdownCheck(ServiceDropdownElements.values());

        //7 Open through the header menu Service -> Different Elements Page
        servicePage.openDifferentElementsPage();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.mainInterfaceCheck();

        //9 Assert that there is Right Section
        differentElementsPage.isRightSectionDisplayed();

        //10 Assert that there is Left Section
        differentElementsPage.isLeftSectionDisplayed();

        //11 Select checkboxes
        differentElementsPage.selectCheckboxesWaterWind();

        //12 Assert that for each checkbox there is an individual log row and value is
        // corresponded to the status of checkbox. 
        differentElementsPage.areCheckboxLogsCorrect(new SupportOptions[]
                {SupportOptions.WATER, SupportOptions.WIND});

        //13 Select radio
        differentElementsPage.selectRadioSelen();

        //14 Assert that for radiobutton there is a log row and value is
        // corresponded to the status of radiobutton. 
        differentElementsPage.areRadioLogsCorrect(new SupportOptions[] {SupportOptions.SELEN});

        //15 Select in dropdown
        differentElementsPage.selectDropdownYellow();

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.areDropdownLogsCorrect(new SupportOptions[] {SupportOptions.YELLOW});

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckboxesWaterWind();

        //18 Assert that for each checkbox there is an individual log row and value is
        // corresponded to the status of checkbox. 
        differentElementsPage.areCheckboxLogsCorrect(new SupportOptions[]
                {SupportOptions.WATER, SupportOptions.WIND});
    }
}

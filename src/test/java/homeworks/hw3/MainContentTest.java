package homeworks.hw3;

import base.SeleniumBase;
import homeworks.hw3.enums.HeaderItemsData;
import homeworks.hw3.enums.IconsData;
import homeworks.hw3.enums.PageMainData;
import homeworks.hw3.enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainContentTest extends SeleniumBase {
    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void mainContentTest() {
        //1 Open test site by URL
        indexPage.openURL(PageMainData.URL.toString());

        //2 Assert Browser title
        indexPage.titleCheck(PageMainData.PAGE_TITLE.toString());

        //3 Perform login
        indexPage.login(Users.PETER_C);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.isLogged(Users.PETER_C);

        //5 Assert Browser title
        indexPage.titleCheck(PageMainData.PAGE_TITLE.toString());

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        indexPage.areHeaderItemsDisplayed();
        indexPage.headerTextsCheck(HeaderItemsData.values());


        //7 Assert that there are 4 images on the Index Page and they are displayed
        indexPage.areIconsDisplayed();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        indexPage.iconTextsCheck(IconsData.values());

        //9 Assert a text of the main headers
        indexPage.firstMainHeaderCheck(PageMainData.FIRST_MAIN_HEADER_TEXT);
        indexPage.secondMainHeaderCheck(PageMainData.SECOND_MAIN_HEADER_TEXT);

        //10 Assert that there is the iframe in the center of page
        indexPage.isIframeDisplayed();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        indexPage.iframeLogoCheck();

        //12 Switch to original window back
        indexPage.switchToMainFrame();

        //13 Assert a text of the sub header
        indexPage.subHeaderTextCheck(PageMainData.SUB_HEADER_TEXT);

        //14 Assert that JDI GITHUB is a link and has a proper URL
        indexPage.subHeaderLinkCheck(PageMainData.SUB_HEADER_LINK);

        //15 Assert that there is Left Section
        indexPage.isLeftSectionDisplayed();

        //16 Assert that there is Footer
        indexPage.isFooterDisplayed();
    }
}

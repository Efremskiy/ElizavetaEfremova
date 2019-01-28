package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainContentWithSoftAssertTest {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        softAssert = new SoftAssert();
    }

    @Test
    public void mainContentTest() {
        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title

        softAssert.assertEquals(driver.getTitle(),"Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
       softAssert.assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(),"Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(1)")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(1)")).getText(), "HOME");
        softAssert.assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(2)")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(2)")).getText(), "CONTACT FORM");
        softAssert.assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(3)")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(3)")).getText(), "SERVICE");
        softAssert.assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4)")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4)")).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> Images = new ArrayList<>(driver.findElements(By.className("benefit-icon")));
        softAssert.assertEquals(Images.size(),4);
        for (WebElement image: Images) {
            softAssert.assertTrue(image.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> Texts = new ArrayList<>(driver.findElements(By.className("benefit-txt")));
        softAssert.assertEquals(Texts.size(),4);
        softAssert.assertEquals(Texts.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project" );
        softAssert.assertEquals(Texts.get(1).getText(), "To be flexible and\n" +
                "customizable");
        softAssert.assertEquals(Texts.get(2).getText(),"To be multiplatform");
        softAssert.assertEquals(Texts.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        softAssert.assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > " +
                "main > div.main-content > h3.main-title.text-center")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > " +
                "main > div.main-content > h3.main-title.text-center")).getText(),
                "EPAM FRAMEWORK WISHES…");
        softAssert.assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > " +
                "main > div.main-content > p")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > " +
                "main > div.main-content > p")).getText(),"LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +
                "ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
                "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
                "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        softAssert.assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        softAssert.assertTrue(driver.findElement(By.className("epam-logo")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().parentFrame();

        //13 Assert a text of the sub header
        softAssert.assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > " +
                "div.main-content > h3:nth-child(3) > a")).getText(),"JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertFalse(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > " +
                "div.main-content > h3:nth-child(3) > a")).getAttribute("href").isEmpty());
        softAssert.assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > " +
                "div.main-content > h3:nth-child(3) > a")).getAttribute("href"),
                "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        softAssert.assertTrue(driver.findElement(By.cssSelector("body > div > " +
                "div.uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar")).isDisplayed());

        //16 Assert that there is Footer
        softAssert.assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());

        //17 Close Browser
        driver.close();
        softAssert.assertAll();
    }
}

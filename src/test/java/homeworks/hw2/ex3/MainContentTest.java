package homeworks.hw2.ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.*;

public class MainContentTest {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void mainContentTest() {
        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(),"Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
       assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(),"Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(1)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(1)")).getText(), "HOME");
        assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(2)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(2)")).getText(), "CONTACT FORM");
        assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(3)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(3)")).getText(), "SERVICE");
        assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > " +
                "ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4)")).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> Images = new ArrayList<>(driver.findElements(By.className("benefit-icon")));
        assertEquals(Images.size(),4);
        for (WebElement image: Images) {
            assertTrue(image.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = new ArrayList<>(driver.findElements(By.className("benefit-txt")));
        assertEquals(texts.size(),4);
        assertEquals(texts.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project" );
        assertEquals(texts.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(texts.get(2).getText(),"To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > " +
                "main > div.main-content > h3.main-title.text-center")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > " +
                "main > div.main-content > h3.main-title.text-center")).getText(),
                "EPAM FRAMEWORK WISHES…");
        assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > " +
                "main > div.main-content > p")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > " +
                "main > div.main-content > p")).getText(),"LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +
                "ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " +
                "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
                "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.className("epam-logo")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().parentFrame();

        //13 Assert a text of the sub header
        assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > " +
                "div.main-content > h3:nth-child(3) > a")).getText(),"JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertFalse(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > " +
                "div.main-content > h3:nth-child(3) > a")).getAttribute("href").isEmpty());
        assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > " +
                "div.main-content > h3:nth-child(3) > a")).getAttribute("href"),
                "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("body > div > " +
                "div.uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());
    }
}

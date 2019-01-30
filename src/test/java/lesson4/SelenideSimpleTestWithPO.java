package lesson4;

import base.SelenideBase;
import base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.IndexPage;
import selenide.SelenideIndexPage;

import static com.codeborne.selenide.Selenide.*;

public class SelenideSimpleTestWithPO extends SelenideBase {
    private SelenideIndexPage indexPage;

    @BeforeMethod
    public void initTest(){
        open("https://epam.github.io/JDI/index.html");
        indexPage = page(SelenideIndexPage.class);
    }

    @AfterMethod
    public void closeTest(){
       close();
    }

    @Test
    public void SimpleTest(){
        indexPage.openIndexPage();
        indexPage.login("epam", "1234");
    }
}
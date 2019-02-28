package jdi.lesson1;

import base.jdi.lesson1.JdiSite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiSimpleExample {

    //IndexPageJDI indexPageJDI;
    //private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        //driver = new ChromeDriver();
        //driver.navigate().to("https://epam.github.io/JDI/index.html");
        PageFactory.initElements(JdiSite.class);
    }

    @AfterSuite
    public void afterSuite() {
//        driver.close();
        WebDriverFactory.close();
    }

    @Test
    public void simpleJdiTest() {
        //indexPageJDI.login("epam", "1234");
        JdiSite.indexPageJDI.open();
        JdiSite.indexPageJDI.login("epam", "1234");
    }
}

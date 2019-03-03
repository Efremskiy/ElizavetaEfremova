package homeworks.hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import homeworks.hw7.entities.HeaderItemsData;
import homeworks.hw7.entities.MetalsAndColorsData;
import homeworks.hw7.entities.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MetalsAndColorsTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @Test
    public void simpleJdiTest() {
        JdiSite.indexPage.open();

        JdiSite.indexPage.login(User.PITER);
        JdiSite.indexPage.loginCheck(User.PITER);

        JdiSite.indexPage.headerNavigationTo(HeaderItemsData.METALS_AND_COLORS);
        JdiSite.metalsAndColorsPage.titleCheck();
        JdiSite.metalsAndColorsPage.form(MetalsAndColorsData.DATA);
        JdiSite.metalsAndColorsPage.resultCheck();
    }
}

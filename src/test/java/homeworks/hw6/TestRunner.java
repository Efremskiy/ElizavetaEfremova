package homeworks.hw6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(
        features = "src/test/resources/hw6",
        glue = "homeworks.hw6.steps"
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeMethod()
    public void driverSetUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5_000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }

    @AfterMethod()
    public void driverClose() {
        Selenide.close();
    }
}

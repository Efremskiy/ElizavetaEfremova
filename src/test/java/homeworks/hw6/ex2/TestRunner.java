package homeworks.hw6.ex2;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/resources/hw6/ex2",
        glue = "src/test/java/homeworks/hw6/ex2/steps"
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite()
    public void driverSetUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5_000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }
}
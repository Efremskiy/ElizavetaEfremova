package homeworks.hw6.ex1;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "classpath:homeworks.hw6.ex1",
        glue = "classpath:homeworks.hw6.ex1.steps"
)

public class Run extends AbstractTestNGCucumberTests {
    @BeforeSuite()
    public void driverSetUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5_000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }
}

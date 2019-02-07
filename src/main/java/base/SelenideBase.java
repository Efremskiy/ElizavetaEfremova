package base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class SelenideBase {
    @BeforeSuite()
    public void beforeSuite() {
        //По умолчанию:
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5_000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }
}

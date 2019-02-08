package base;

import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBase {

    @BeforeSuite
    public void beforeSuite(){
        //In case chromedriver.exe is in different directory:
        //setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}

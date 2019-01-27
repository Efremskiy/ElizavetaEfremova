package base;

import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBase {

    @BeforeSuite
    public void beforeSuite(){
        //если бы chromedriver.exe лежал в другой папке:
        //setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}

package base;

import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBase {

    @BeforeSuite
    public void beforeSuite(){
        // TODO It is completely prohibited to live comments in rus language.
        //если бы chromedriver.exe лежал в другой папке:
        //setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}

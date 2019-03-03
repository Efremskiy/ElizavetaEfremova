package jdi.lesson1.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IndexPageJDI extends WebPage {
    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(css = "[id='name']")
    private TextField userField;

    @FindBy(css = "[id='password']")
    private TextField passwordField;

    @FindBy(css = "[id='login-button']")
    private Button submitButton;

    private WebDriver driver;

    public void login(String name, String password) {
        loginIcon.click();
        userField.input(name);
        passwordField.input(password);
        submitButton.click();
    }

//    public void open() {
//        driver.get("https://epam.github.io/JDI/index.html");
//    }
}

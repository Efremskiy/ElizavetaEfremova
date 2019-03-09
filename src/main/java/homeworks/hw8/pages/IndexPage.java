package homeworks.hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.complex.Menu;
import homeworks.hw8.entities.HeaderItemsData;
import homeworks.hw8.entities.User;
import homeworks.hw8.forms.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class IndexPage extends WebPage {

    LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(css = "#user-name")
    private Text username;

    @FindBy(css = ".m-l8")
    private Menu header;

    private WebDriver driver;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void loginCheck(User user) {
        assertEquals(username.getText(),user.fullName);
    }

    public void headerNavigationTo(HeaderItemsData headerItem) {
        header.select(headerItem.toString());
    }
}

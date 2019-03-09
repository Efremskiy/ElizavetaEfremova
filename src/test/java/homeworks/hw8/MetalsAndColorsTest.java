package homeworks.hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import homeworks.hw8.entities.HeaderItemsData;
import homeworks.hw8.entities.MetalsAndColorsData;
import homeworks.hw8.entities.User;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MetalsAndColorsTest {

    @BeforeMethod
    public void beforeMethod() {
        PageFactory.initElements(JdiSite.class);
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverFactory.close();
    }

    @DataProvider()
    private Object[][] formDataProvider() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/hw8/metalsColorsDataSet.json"));
        Type token = new TypeToken<Map<String, MetalsAndColorsData>>(){}.getType();
        Map<String, MetalsAndColorsData> data = new Gson().fromJson(jsonData, token);
        List<MetalsAndColorsData> dataList = new ArrayList<>(data.values());
        Object[][] returnValue = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            returnValue[i][0] = dataList.get(i);
        }
        return returnValue;
    }

    @Test(dataProvider = "formDataProvider")
    public void simpleJdiTest(MetalsAndColorsData data) {
        JdiSite.indexPage.open();

        JdiSite.indexPage.login(User.PITER);
        JdiSite.indexPage.loginCheck(User.PITER);

        JdiSite.indexPage.headerNavigationTo(HeaderItemsData.METALS_AND_COLORS);
        JdiSite.metalsAndColorsPage.titleCheck();
        JdiSite.metalsAndColorsPage.form(data);
        JdiSite.metalsAndColorsPage.resultCheck(data);
    }
}

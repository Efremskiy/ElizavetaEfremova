package homeworks.hw8;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import homeworks.hw8.pages.IndexPage;
import homeworks.hw8.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {
    @Url("index.html")
    public static IndexPage indexPage;

    @Url("metals-colors.html")
    @Title("Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;
}

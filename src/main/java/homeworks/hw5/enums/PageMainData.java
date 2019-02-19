package homeworks.hw5.enums;

public enum PageMainData {
    URL("https://epam.github.io/JDI/"),
    PAGE_TITLE("Home Page");

    private String text;

    PageMainData(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

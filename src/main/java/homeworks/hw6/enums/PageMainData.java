package homeworks.hw6.enums;

public enum PageMainData {
    URL("https://epam.github.io/JDI/"),
    PAGE_TITLE("Home Page"),
    USER_TABLE("User Table");

    private String text;

    PageMainData(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

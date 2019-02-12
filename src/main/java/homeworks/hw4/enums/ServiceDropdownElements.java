package homeworks.hw4.enums;

// TODO Oh my, what is the reason of this naming ???
// TODO This items should be named with relation to it purpose...
//fixed
public enum ServiceDropdownElements {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGE("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    private String text;

    ServiceDropdownElements(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

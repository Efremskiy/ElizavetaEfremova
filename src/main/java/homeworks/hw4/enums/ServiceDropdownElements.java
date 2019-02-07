package homeworks.hw4.enums;

public enum ServiceDropdownElements {
    FIRST_ELEMENT("Support"),
    SECOND_ELEMENT("Dates"),
    THIRD_ELEMENT("Complex Table"),
    FOURTH_ELEMENT("Simple Table"),
    FIFTH_ELEMENT("User Table"),
    SIXTH_ELEMENT("Table with pages"),
    SEVENTH_ELEMENT("Different elements"),
    EIGHTH_ELEMENT("Performance");

    private String text;

    ServiceDropdownElements(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

package homeworks.hw3.enums;

public enum HeaderItemsData {
    HEADER_FIRST_ITEM("HOME"),
    HEADER_SECOND_ITEM("CONTACT FORM"),
    HEADER_THIRD_ITEM("SERVICE"),
    HEADER_FOURTH_ITEM("METALS & COLORS");

    private String text;

    HeaderItemsData(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

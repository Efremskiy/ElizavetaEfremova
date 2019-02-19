package homeworks.hw5.enums;

public enum HeaderItemsData {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    private String text;

    HeaderItemsData(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

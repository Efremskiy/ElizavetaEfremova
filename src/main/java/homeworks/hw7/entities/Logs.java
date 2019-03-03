package homeworks.hw7.entities;

public enum Logs {
    SUMMARY("Summary: "),
    ELEMENTS("Elements: "),
    COLOR("Color: "),
    METAL("Metal: "),
    VEGETABLES("Vegetables: ");

    public String text;

    Logs(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

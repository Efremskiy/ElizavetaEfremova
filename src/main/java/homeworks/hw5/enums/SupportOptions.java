package homeworks.hw5.enums;

public enum SupportOptions {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String text;

    SupportOptions(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

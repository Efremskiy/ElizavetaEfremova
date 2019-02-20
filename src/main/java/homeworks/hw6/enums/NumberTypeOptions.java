package homeworks.hw6.enums;

public enum NumberTypeOptions {
    ADMIN("Admin"),
    USER("User"),
    MANAGER("Manager");

    private String text;

    NumberTypeOptions(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

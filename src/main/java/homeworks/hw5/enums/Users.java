package homeworks.hw5.enums;

public enum Users {
    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String fullName;

    Users(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }
    @Override
    public String toString() {
        return fullName;
    }
}

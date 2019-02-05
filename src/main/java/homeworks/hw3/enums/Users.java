package homeworks.hw3.enums;

public enum Users {
    PETER_C("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String fullName;

    Users(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }
}

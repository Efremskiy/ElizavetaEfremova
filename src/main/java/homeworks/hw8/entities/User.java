package homeworks.hw8.entities;

public class User {
    String login;
    String password;
    public String fullName;

    public static User PITER = new User("epam", "1234", "PITER CHAILOVSKII");

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }
}

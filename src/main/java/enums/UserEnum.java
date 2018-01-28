package enums;

public enum UserEnum {
    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String name;

    UserEnum(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }
}

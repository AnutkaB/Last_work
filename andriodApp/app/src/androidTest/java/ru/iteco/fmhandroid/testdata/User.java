package ru.iteco.fmhandroid.testdata;

public enum User {

    VALID_USER("login2", "password2"),
    UNREGISTERED_USER("invalidlogin", "invalidpassword"),
    USER_WITHOUT_LOGIN("", "password2"),
    USER_WITHOUT_PASSWORD("login2", "");

    private final String login;
    private final String password;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

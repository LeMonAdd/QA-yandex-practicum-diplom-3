package model;

public class UserCred {
    private String name = "Roman";
    private String email = "rferfe12848d@yandex.ru";
    private String password = "12423442432";

    public User from() {
        return new User(name, email, password);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

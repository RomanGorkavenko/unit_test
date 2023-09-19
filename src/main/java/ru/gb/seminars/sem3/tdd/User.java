package ru.gb.seminars.sem3.tdd;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;

    }

    /**
     * 3.6.
     * @param name имя пользователя
     * @param password пароль
     * @return результат аутентификации.
     */
    public boolean authenticate(String name, String password) {
        return false;
    }

}
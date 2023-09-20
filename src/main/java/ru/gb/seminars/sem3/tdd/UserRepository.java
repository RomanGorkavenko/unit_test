package ru.gb.seminars.sem3.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {

    /**
     * Тут можно хранить аутентифицированных пользователей
     */
    List<User> data = new ArrayList<>();

    /**
     * Добавляет пользователя или пользователей.
     * @param user пользователь.
     */
    public void addUser(User... user) {
        data.addAll(Arrays.asList(user));
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов.
     */
    public void disablesAccessToAllUsersExceptAdministrators() {
        for (User user: data) {
            if (!user.isAdmin) {
                user.isAuthenticate = false;
            }
        }
    }

    /**
     * 3.6.
     * @param name имя пользователя
     * @param password пароль
     * @return результат аутентификации.
     */
    public boolean authenticate(String name, String password) {
        for (User user: data) {
            if (user.name.equals(name) && user.password.equals(password)) {
                user.isAuthenticate = true;
                return true;
            }
        }
        return false;
    }

}
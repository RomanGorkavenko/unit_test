package ru.gb.seminars.sem3.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;
    private User user1;
    private User user2Admin;
    private User user3;

    private static final String USER_NAME = "1";
    private static final String USER_NAME_FALSE = "name";
    private static final String USER_PASSWORD = "123";

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        user1 = new User("1", "123", false);
        user2Admin = new User("2", "123", true);
        user3 = new User("3", "123", false);
    }

    @Test
    void addUser_addingUsersToList_successfully() {
        List<User> expected = new ArrayList<>(List.of(user1, user2Admin, user3));

        userRepository.addUser(user1, user2Admin, user3);

        List<User> actual = userRepository.data;

        assertEquals(expected, actual);
    }

    @Test
    void findByName_findsUserByName_true() {

        userRepository.addUser(user1);

        assertTrue(userRepository.findByName(USER_NAME));
    }

    @Test
    void findByName_doesNotFindUserByName_false() {

        userRepository.addUser(user1);

        assertFalse(userRepository.findByName(USER_NAME_FALSE));
    }

    @Test
    void disablesAccessToAllUsersExceptAdministrators_successfully() {
        Boolean[] expected = new Boolean[]{false, true, false};

        userRepository.addUser(user1, user2Admin, user3);
        for (User user: userRepository.data) {
            user.isAuthenticate = true;
        }

        userRepository.disablesAccessToAllUsersExceptAdministrators();

        Boolean[] actual = userRepository.data.stream().map(a -> a.isAuthenticate).toArray(Boolean[]::new);

        assertArrayEquals(expected, actual);

    }

    @Test
    void authenticate_authenticationOfTheUserByNameAndPassword_successfully() {

        userRepository.addUser(user1, user2Admin, user3);

        assertTrue(userRepository.authenticate(USER_NAME, USER_PASSWORD));
    }

    @Test
    void authenticate_authenticationOfTheUserByNameAndPassword_failed() {

        userRepository.addUser(user1, user2Admin, user3);

        assertFalse(userRepository.authenticate(USER_NAME_FALSE, USER_PASSWORD));
    }

    @Test
    void authenticate_assigningValueFalseToFieldIsAuthenticate_successfully() {
        boolean expected = true;

        userRepository.addUser(user1, user2Admin, user3);
        userRepository.authenticate(USER_NAME, USER_PASSWORD);

        boolean actual = user1.isAuthenticate;

        assertEquals(expected, actual);
    }
}
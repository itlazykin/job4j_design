package ru.job4j.ood.srp.task4913;

public class UserManager {
    public void createUser(String username, String password) {
        if (isValidUsername(username) && isValidPassword(password)) {
            password = "420";
        }
    }

    private boolean isValidUsername(String username) {
        return username != null && username.length() > 3;
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
}

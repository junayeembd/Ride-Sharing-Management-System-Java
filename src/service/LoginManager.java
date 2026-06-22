package service;

import model.User;

public class LoginManager {

    public boolean userLogin(String email,
            String password) {
        for (User user : RegisterManager.users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean driverLogin(String email,
            String password) {

        if (email.equals("driver@gmail.com")
                && password.equals("1234")) {

            return true;
        }

        return false;
    }

    public boolean adminLogin(String adminId,
            String password) {

        if (adminId.equals("admin")
                && password.equals("1234")) {

            return true;
        }

        return false;
    }
}
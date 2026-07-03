package service;

import model.User;
import model.Driver;

public class LoginManager {

    public boolean userLogin(String email, String password) {

        for (User user : RegisterManager.users) {

            if (user.getEmail().equals(email)
                    && user.getPassword().equals(password)) {

                return true;
            }
        }

        return false;
    }

    public boolean driverLogin(String email, String password) {

        for (Driver driver : RegisterManager.drivers) {

            if (driver.getEmail().equals(email)
                    && driver.getPassword().equals(password)) {

                return true;
            }
        }

        return false;
    }

    public boolean adminLogin(String adminId, String password) {

        return adminId.equals("admin")
                && password.equals("1234");
    }
}
package service;

import model.User;
import model.Admin;
import model.Driver;

public class LoginManager {
    public static String currentDriverEmail;
    public static String currentUserEmail;

    public boolean userLogin(String email, String password) {

        for (User user : RegisterManager.users) {

            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                currentUserEmail = user.getEmail();
                return true;
            }
        }
        return false;
    }

    public boolean driverLogin(String email, String password) {

        for (Driver driver : RegisterManager.drivers) {

            if (driver.getEmail().equals(email) && driver.getPassword().equals(password)) {
                currentDriverEmail = driver.getEmail();
                return true;
            }
        }
        return false;
    }

    private final Admin admin = new Admin("System Admin",
            "01715432456",
            "admin@gmail.com",
            "Dhaka",
            "1234",
            "admin");

    public boolean adminLogin(String adminId, String password) {
        return admin.getAdminId().equals(adminId) && admin.getPassword().equals(password);
    }
}
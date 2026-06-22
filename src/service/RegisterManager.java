package service;

import model.User;
import model.Driver;

import java.util.ArrayList;

public class RegisterManager {

    public static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<Driver> drivers = new ArrayList<>();

    public void registerUser(User user) {

        users.add(user);

        System.out.println(
                "User Registration Successful");
    }

    public void registerDriver(Driver driver) {

        drivers.add(driver);

        System.out.println(
                "Driver Registration Successful");
    }
}
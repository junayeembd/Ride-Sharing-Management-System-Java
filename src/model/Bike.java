package model;

public class Bike extends Vehicle {

    public Bike(String vehicleNumber) {
        super(vehicleNumber, "Bike");
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 15;
    }
}
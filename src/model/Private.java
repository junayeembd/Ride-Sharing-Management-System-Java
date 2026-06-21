package model;

public class Private extends Vehicle {

    public Private(String vehicleNumber) {
        super(vehicleNumber, "Private");
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 30;
    }
}
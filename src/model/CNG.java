package model;

public class CNG extends Vehicle {

    public CNG(String vehicleNumber) {
        super(vehicleNumber, "CNG");
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 20;
    }
}
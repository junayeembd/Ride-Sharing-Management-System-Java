package model;

public class Rental {

    private int rentalId;
    private String userEmail;
    private String vehicleType;
    private int hours;
    private double rentalFare;

    public Rental(int rentalId, String userEmail, String vehicleType, int hours) {
        this.rentalId = rentalId;
        this.userEmail = userEmail;
        this.vehicleType = vehicleType;
        this.hours = hours;
        this.rentalFare = calculateRentalFare();
    }

    public int getRentalId() {
        return rentalId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getHours() {
        return hours;
    }

    public double getRentalFare() {
        return rentalFare;
    }

    public double calculateRentalFare() {

        double ratePerHour;

        if (vehicleType.equals("Bike")) {
            ratePerHour = 100;
        } else if (vehicleType.equals("CNG")) {
            ratePerHour = 200;
        } else {
            ratePerHour = 500;
        }
        return hours * ratePerHour;
    }

    public void displayRentalInfo() {

        System.out.println("\n===== Rental Details =====");
        System.out.println("Rental ID: " + rentalId);
        System.out.println("User: " + userEmail);
        System.out.println("Vehicle: " + vehicleType);
        System.out.println("Hours: " + hours);
        System.out.println("Fare: " + rentalFare + " BDT");
    }
}
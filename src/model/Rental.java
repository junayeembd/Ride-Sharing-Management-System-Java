package model;

public class Rental {

    private int rentalId;
    private String vehicleType;
    private int hours;

    public Rental(int rentalId,
                  String vehicleType,
                  int hours) {

        this.rentalId = rentalId;
        this.vehicleType = vehicleType;
        this.hours = hours;
    }

    public double calculateRentalFare() {

        return hours * 200;
    }
}
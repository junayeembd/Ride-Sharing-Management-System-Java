package model;

public class Ride {

    private int rideId;
    private String pickupLocation;
    private String destination;
    private String vehicleType;
    private double distance;
    private double fare;
    private String status;

    public Ride(int rideId,
            String pickupLocation,
            String destination,
            String vehicleType,
            double distance,
            double fare,
            String status) {

        this.rideId = rideId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.vehicleType = vehicleType;
        this.distance = distance;
        this.fare = fare;
        this.status = status;
    }

    // Getters

    public int getRideId() {
        return rideId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }

    public String getStatus() {
        return status;
    }

    // Display

    public void displayRideInfo() {

        System.out.println("\n===== Ride Details =====");

        System.out.println("Ride ID: " + rideId);
        System.out.println("Pickup: " + pickupLocation);
        System.out.println("Destination: " + destination);
        System.out.println("Vehicle: " + vehicleType);
        System.out.println("Distance: " + distance + " KM");
        System.out.println("Fare: " + fare + " BDT");
        System.out.println("Status: " + status);
    }

}
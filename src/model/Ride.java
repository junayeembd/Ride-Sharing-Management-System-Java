package model;

public class Ride {

    private int rideId;
    private String pickupLocation;
    private String destination;
    private double distance;
    private double fare;
    private String status;

    public Ride(int rideId,
                String pickupLocation,
                String destination,
                double distance,
                double fare,
                String status) {

        this.rideId = rideId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.distance = distance;
        this.fare = fare;
        this.status = status;
    }

    public void displayRideInfo() {

        System.out.println("\n===== Ride Details =====");

        System.out.println("Ride ID: " + rideId);
        System.out.println("Pickup: " + pickupLocation);
        System.out.println("Destination: " + destination);
        System.out.println("Distance: " + distance + " KM");
        System.out.println("Fare: " + fare + " BDT");
        System.out.println("Status: " + status);
    }
}
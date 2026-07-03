package model;

public class Ride {

    private int rideId;
    private String pickupLocation;
    private String destination;
    private String vehicleType;
    private double distance;
    private double fare;
    private String status;
    private String userEmail;
    private String driverEmail;

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

        this.userEmail = null;
        this.driverEmail = null;
    }

    public int getRideId() {
        return rideId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getPickup() {
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDriverEmail() {
        return driverEmail;
    }

    public void setDriverEmail(String driverEmail) {
        this.driverEmail = driverEmail;
    }

    public void displayRideInfo() {

        System.out.println("\n===== Ride Details =====");

        System.out.println("Ride ID: " + rideId);
        System.out.println("User: " + userEmail);

        if (driverEmail == null) {

            System.out.println("Driver: Not Assigned");

        } else {

            System.out.println("Driver: " + driverEmail);
        }

        System.out.println("Pickup: " + pickupLocation);
        System.out.println("Destination: " + destination);
        System.out.println("Vehicle: " + vehicleType);
        System.out.println("Distance: " + distance + " KM");
        System.out.println("Fare: " + fare + " BDT");
        System.out.println("Status: " + status);
    }
}
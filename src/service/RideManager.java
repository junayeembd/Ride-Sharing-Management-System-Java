package service;

import model.Ride;

public class RideManager {

    public void bookRide(Ride ride) {

        System.out.println("Ride Booked Successfully!");

        ride.displayRideInfo();

    }

}
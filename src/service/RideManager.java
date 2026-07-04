package service;

import model.Ride;
import java.util.ArrayList;

public class RideManager {

    public static ArrayList<Ride> rides = new ArrayList<>();
    private static int nextRideId = 1;

    public static int generateRideId() {

        return nextRideId++;
    }

    public void bookRide(Ride ride) {

        rides.add(ride);
        System.out.println("Ride Booked Successfully!");
        ride.displayRideInfo();
    }
}
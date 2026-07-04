package service;

import model.Rental;
import java.util.ArrayList;

public class RentalManager {

    public static ArrayList<Rental> rentals = new ArrayList<>();
    private static int nextRentalId = 1;

    public static int generateRentalId() {

        return nextRentalId++;
    }

    public void rentVehicle(Rental rental) {

        rentals.add(rental);
        System.out.println("Vehicle Rental Successful!");
        rental.displayRentalInfo();
    }
}
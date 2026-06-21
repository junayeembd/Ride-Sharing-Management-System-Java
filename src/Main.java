import model.*;

public class Main {

    public static void main(String[] args) {

        Vehicle bike = new Bike("BIKE-101");
        Vehicle cng = new CNG("CNG-202");
        Vehicle car = new Private("CAR-303");

        double distance = 10;

        System.out.println("Bike Fare: " +
                bike.calculateFare(distance));

        System.out.println("CNG Fare: " +
                cng.calculateFare(distance));

        System.out.println("Private Fare: " +
                car.calculateFare(distance));
    }
}
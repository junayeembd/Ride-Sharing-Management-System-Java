package ui;

import model.Ride;
import service.RideManager;
import javax.swing.*;

public class AdminRidePage {
    public static void main(String[] args) {

        JFrame frame = new JFrame("All Rides");
        frame.setSize(750, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("All Ride Information");
        title.setBounds(290, 20, 200, 30);

        JTextArea rideArea = new JTextArea();
        rideArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(rideArea);
        scrollPane.setBounds(50, 70, 650, 360);

        String rideData = "";

        for (Ride ride : RideManager.rides) {

            rideData += "Ride ID : " + ride.getRideId()
                    + "\nUser : " + ride.getUserEmail()
                    + "\nDriver : "
                    + getDriverInformation(ride)
                    + "\nPickup : "
                    + ride.getPickupLocation()
                    + "\nDestination : "
                    + ride.getDestination()
                    + "\nVehicle : "
                    + ride.getVehicleType()
                    + "\nDistance : "
                    + ride.getDistance()
                    + " KM"
                    + "\nFare : "
                    + ride.getFare()
                    + " BDT"
                    + "\nStatus : "
                    + ride.getStatus()
                    + "\n----------------------------------\n";
        }

        if (rideData.isEmpty()) {
            rideArea.setText(
                    "No ride information available.");

        } else {
            rideArea.setText(rideData);
        }

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(310, 450, 120, 35);

        btnBack.addActionListener(e -> {
            frame.dispose();
            AdminDashboard.main(null);
        });

        frame.add(title);
        frame.add(scrollPane);
        frame.add(btnBack);
        frame.setVisible(true);
    }

    private static String getDriverInformation(Ride ride) {

        if (ride.getDriverEmail() == null) {
            return "Not Assigned";
        }
        return ride.getDriverEmail();
    }
}
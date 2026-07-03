package ui;

import model.Ride;
import service.RideManager;
import service.LoginManager;

import javax.swing.*;

public class DriverRideHistoryPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Driver Ride History");

        frame.setSize(700, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Completed Ride History");

        title.setBounds(
                270,
                20,
                200,
                30);

        JTextArea historyArea = new JTextArea();

        historyArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historyArea);

        scrollPane.setBounds(
                50,
                70,
                580,
                300);

        String rideHistory = "";

        for (Ride ride : RideManager.rides) {

            if (ride.getStatus().equals("Completed") && LoginManager.currentDriverEmail.equals(ride.getDriverEmail())) {

                rideHistory += "Ride ID : " + ride.getRideId()
                        + "\nPickup : " + ride.getPickupLocation()
                        + "\nDestination : " + ride.getDestination()
                        + "\nVehicle : " + ride.getVehicleType()
                        + "\nDistance : " + ride.getDistance() + " KM"
                        + "\nFare : " + ride.getFare() + " BDT"
                        + "\nStatus : " + ride.getStatus()
                        + "\n-----------------------------\n";
            }
        }

        if (rideHistory.isEmpty()) {

            historyArea.setText(
                    "No completed ride history available.");

        } else {

            historyArea.setText(rideHistory);
        }

        JButton btnBack = new JButton("Back");

        btnBack.setBounds(
                290,
                400,
                120,
                35);

        btnBack.addActionListener(e -> {

            frame.dispose();

            DriverDashboard.main(null);
        });

        frame.add(title);
        frame.add(scrollPane);
        frame.add(btnBack);

        frame.setVisible(true);
    }
}
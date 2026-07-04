package ui;

import model.Ride;
import service.RideManager;
import service.LoginManager;
import javax.swing.*;

public class RideRequestPage {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Ride Requests");
        frame.setSize(750, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Pending Ride Requests");
        title.setBounds(290, 20, 200, 30);

        JTextArea rideArea = new JTextArea();
        rideArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(rideArea);
        scrollPane.setBounds(50, 70, 630, 280);

        String rideRequests = "";
        for (Ride ride : RideManager.rides) {
            if (ride.getStatus().equals("Pending")) {
                rideRequests += "Ride ID : " + ride.getRideId()
                        + "\nPickup : " + ride.getPickupLocation()
                        + "\nDestination : " + ride.getDestination()
                        + "\nVehicle : " + ride.getVehicleType()
                        + "\nDistance : " + ride.getDistance() + " KM"
                        + "\nFare : " + ride.getFare() + " BDT"
                        + "\nStatus : " + ride.getStatus()
                        + "\n-----------------------------\n";
            }
        }

        if (rideRequests.isEmpty()) {
            rideArea.setText("No pending ride requests.");
        } else {
            rideArea.setText(rideRequests);
        }
        JLabel rideIdLabel = new JLabel("Ride ID");
        rideIdLabel.setBounds(180, 380, 100, 30);

        JTextField txtRideId = new JTextField();
        txtRideId.setBounds(260, 380, 150, 30);

        JButton btnAccept = new JButton("Accept Ride");

        btnAccept.setBounds(430, 380, 130, 35);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(300, 440, 120, 35);

        btnAccept.addActionListener(e -> {
            try {
                int rideId = Integer.parseInt(
                        txtRideId.getText());
                boolean found = false;
                for (Ride ride : RideManager.rides) {
                    if (ride.getRideId() == rideId && ride.getStatus().equals("Pending")) {
                        ride.setStatus("Accepted");
                        ride.setDriverEmail(LoginManager.currentDriverEmail);
                        found = true;
                        JOptionPane.showMessageDialog(frame, "Ride Accepted Successfully!");
                        frame.dispose();
                        RideRequestPage.main(null);
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(frame, "Pending Ride Not Found!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid Ride ID!");
            }
        });
        btnBack.addActionListener(e -> {
            frame.dispose();
            DriverDashboard.main(null);
        });

        frame.add(title);
        frame.add(scrollPane);
        frame.add(rideIdLabel);
        frame.add(txtRideId);
        frame.add(btnAccept);
        frame.add(btnBack);
        frame.setVisible(true);
    }
}
package ui;

import model.Ride;
import service.LoginManager;
import service.RideManager;

import javax.swing.*;

public class ActiveRidePage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Active Ride");

        frame.setSize(750, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Active Ride");

        title.setBounds(
                320,
                20,
                150,
                30);

        JTextArea rideArea = new JTextArea();

        rideArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(rideArea);

        scrollPane.setBounds(
                50,
                70,
                630,
                280);

        String activeRides = "";

        for (Ride ride : RideManager.rides) {

            if ((ride.getStatus().equals("Accepted")
                    || ride.getStatus().equals("Started"))
                    && LoginManager.currentDriverEmail.equals(ride.getDriverEmail())) {

                activeRides += "Ride ID : " + ride.getRideId()
                        + "\nPickup : " + ride.getPickupLocation()
                        + "\nDestination : " + ride.getDestination()
                        + "\nVehicle : " + ride.getVehicleType()
                        + "\nDistance : " + ride.getDistance() + " KM"
                        + "\nFare : " + ride.getFare() + " BDT"
                        + "\nStatus : " + ride.getStatus()
                        + "\n-----------------------------\n";
            }
        }

        if (activeRides.isEmpty()) {

            rideArea.setText(
                    "No active ride available.");

        } else {

            rideArea.setText(activeRides);
        }

        JLabel rideIdLabel = new JLabel("Ride ID");

        rideIdLabel.setBounds(
                100,
                380,
                80,
                30);

        JTextField txtRideId = new JTextField();

        txtRideId.setBounds(
                170,
                380,
                100,
                30);

        JButton btnStart = new JButton("Start Ride");

        btnStart.setBounds(
                290,
                380,
                120,
                35);

        JButton btnComplete = new JButton("Complete Ride");

        btnComplete.setBounds(
                430,
                380,
                140,
                35);

        JButton btnBack = new JButton("Back");

        btnBack.setBounds(
                300,
                450,
                120,
                35);

        btnStart.addActionListener(e -> {

            try {

                int rideId = Integer.parseInt(
                        txtRideId.getText());

                boolean found = false;

                for (Ride ride : RideManager.rides) {

                    if (ride.getRideId() == rideId
                            && ride.getStatus().equals("Accepted")
                            && LoginManager.currentDriverEmail.equals(ride.getDriverEmail())) {

                        ride.setStatus("Started");

                        found = true;

                        JOptionPane.showMessageDialog(
                                frame,
                                "Ride Started Successfully!");

                        frame.dispose();

                        ActiveRidePage.main(null);

                        break;
                    }
                }

                if (!found) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Accepted Ride Not Found!");
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid Ride ID!");
            }
        });

        btnComplete.addActionListener(e -> {

            try {

                int rideId = Integer.parseInt(
                        txtRideId.getText());

                boolean found = false;

                for (Ride ride : RideManager.rides) {

                    if (ride.getRideId() == rideId
                            && ride.getStatus().equals("Started")
                            && LoginManager.currentDriverEmail.equals(ride.getDriverEmail())) {

                        ride.setStatus("Completed");

                        found = true;

                        JOptionPane.showMessageDialog(
                                frame,
                                "Ride Completed Successfully!");

                        frame.dispose();

                        ActiveRidePage.main(null);

                        break;
                    }
                }

                if (!found) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Started Ride Not Found!");
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid Ride ID!");
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

        frame.add(btnStart);
        frame.add(btnComplete);
        frame.add(btnBack);

        frame.setVisible(true);
    }
}
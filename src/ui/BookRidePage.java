package ui;

import model.*;
import service.RideManager;
import service.LoginManager;

import javax.swing.*;

public class BookRidePage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Book Ride");

        frame.setSize(650, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Book Ride");
        title.setBounds(280, 20, 150, 30);

        JLabel pickupLabel = new JLabel("Pickup Location");
        pickupLabel.setBounds(60, 80, 120, 30);

        JTextField txtPickup = new JTextField();
        txtPickup.setBounds(220, 80, 250, 30);

        JLabel destinationLabel = new JLabel("Destination");
        destinationLabel.setBounds(60, 130, 120, 30);

        JTextField txtDestination = new JTextField();
        txtDestination.setBounds(220, 130, 250, 30);

        JLabel vehicleLabel = new JLabel("Vehicle Type");
        vehicleLabel.setBounds(60, 180, 120, 30);

        String[] vehicles = {
                "Bike",
                "CNG",
                "Private"
        };

        JComboBox<String> vehicleBox = new JComboBox<>(vehicles);

        vehicleBox.setBounds(220, 180, 250, 30);

        JLabel distanceLabel = new JLabel("Distance (KM)");
        distanceLabel.setBounds(60, 230, 120, 30);

        JTextField txtDistance = new JTextField();
        txtDistance.setBounds(220, 230, 250, 30);

        JLabel fareLabel = new JLabel("Fare : 0.00 BDT");
        fareLabel.setBounds(220, 280, 250, 30);

        JButton btnFare = new JButton("Calculate Fare");
        btnFare.setBounds(150, 330, 150, 35);

        JButton btnConfirm = new JButton("Confirm Ride");
        btnConfirm.setBounds(320, 330, 150, 35);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(235, 390, 150, 35);

        // Calculate Fare Event
        btnFare.addActionListener(e -> {

            try {

                double distance = Double.parseDouble(
                        txtDistance.getText());

                if (distance <= 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Distance must be greater than 0!");

                    return;
                }

                String vehicleType = (String) vehicleBox.getSelectedItem();

                Vehicle vehicle;

                if (vehicleType.equals("Bike")) {

                    vehicle = new Bike("BIKE-101");

                } else if (vehicleType.equals("CNG")) {

                    vehicle = new CNG("CNG-202");

                } else {

                    vehicle = new Private("CAR-303");
                }

                double fare = vehicle.calculateFare(distance);

                fareLabel.setText(
                        "Fare : " + fare + " BDT");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid distance!");
            }
        });

        // Confirm Ride Event
        btnConfirm.addActionListener(e -> {

            try {

                String pickup = txtPickup.getText().trim();

                String destination = txtDestination.getText().trim();

                String vehicleType = (String) vehicleBox.getSelectedItem();

                if (pickup.isEmpty()
                        || destination.isEmpty()
                        || txtDistance.getText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please fill all fields!");

                    return;
                }

                double distance = Double.parseDouble(
                        txtDistance.getText());

                if (distance <= 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Distance must be greater than 0!");

                    return;
                }

                Vehicle vehicle;

                if (vehicleType.equals("Bike")) {

                    vehicle = new Bike("BIKE-101");

                } else if (vehicleType.equals("CNG")) {

                    vehicle = new CNG("CNG-202");

                } else {

                    vehicle = new Private("CAR-303");
                }

                double fare = vehicle.calculateFare(distance);

                Ride ride = new Ride(

                        RideManager.generateRideId(),

                        pickup,

                        destination,

                        vehicleType,

                        distance,

                        fare,

                        "Pending");

                ride.setUserEmail(
                        LoginManager.currentUserEmail);

                RideManager manager = new RideManager();

                manager.bookRide(ride);

                JOptionPane.showMessageDialog(
                        frame,
                        "Ride Booked Successfully!\n\n"
                                + "Ride ID : "
                                + ride.getRideId()
                                + "\nFare : "
                                + ride.getFare()
                                + " BDT");

                txtPickup.setText("");
                txtDestination.setText("");
                txtDistance.setText("");

                fareLabel.setText(
                        "Fare : 0.00 BDT");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid distance!");
            }
        });

        // Back Button Event
        btnBack.addActionListener(e -> {

            frame.dispose();

            UserDashboard.main(null);
        });

        frame.add(title);

        frame.add(pickupLabel);
        frame.add(txtPickup);

        frame.add(destinationLabel);
        frame.add(txtDestination);

        frame.add(vehicleLabel);
        frame.add(vehicleBox);

        frame.add(distanceLabel);
        frame.add(txtDistance);

        frame.add(fareLabel);

        frame.add(btnFare);
        frame.add(btnConfirm);
        frame.add(btnBack);

        frame.setVisible(true);
    }
}
package ui;

import model.Rental;
import service.RentalManager;
import service.LoginManager;

import javax.swing.*;

public class RentalPage {

        public static void main(String[] args) {

                JFrame frame = new JFrame("Vehicle Rental");

                frame.setSize(600, 500);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JLabel title = new JLabel("Vehicle Rental");

                title.setBounds(
                                250,
                                30,
                                150,
                                30);

                JLabel vehicleLabel = new JLabel("Vehicle Type");

                vehicleLabel.setBounds(
                                100,
                                100,
                                120,
                                30);

                String[] vehicles = {
                                "Bike",
                                "CNG",
                                "Private"
                };

                JComboBox<String> vehicleBox = new JComboBox<>(vehicles);

                vehicleBox.setBounds(
                                230,
                                100,
                                220,
                                30);

                JLabel hoursLabel = new JLabel("Rental Hours");

                hoursLabel.setBounds(
                                100,
                                160,
                                120,
                                30);

                JTextField txtHours = new JTextField();

                txtHours.setBounds(
                                230,
                                160,
                                220,
                                30);

                JLabel fareLabel = new JLabel("Rental Fare : 0.00 BDT");

                fareLabel.setBounds(
                                230,
                                220,
                                250,
                                30);

                JButton btnCalculate = new JButton("Calculate Fare");

                btnCalculate.setBounds(
                                160,
                                280,
                                140,
                                35);

                JButton btnConfirm = new JButton("Confirm Rental");

                btnConfirm.setBounds(
                                320,
                                280,
                                140,
                                35);

                JButton btnBack = new JButton("Back");

                btnBack.setBounds(
                                240,
                                350,
                                120,
                                35);

                btnCalculate.addActionListener(e -> {

                        try {

                                int hours = Integer.parseInt(
                                                txtHours.getText());

                                if (hours <= 0) {

                                        JOptionPane.showMessageDialog(
                                                        frame,
                                                        "Rental hours must be greater than 0!");

                                        return;
                                }

                                String vehicleType = (String) vehicleBox.getSelectedItem();

                                Rental rental = new Rental(
                                                0,
                                                LoginManager.currentUserEmail,
                                                vehicleType,
                                                hours);

                                double fare = rental.calculateRentalFare();

                                fareLabel.setText(
                                                "Rental Fare : "
                                                                + fare
                                                                + " BDT");

                        } catch (NumberFormatException ex) {

                                JOptionPane.showMessageDialog(
                                                frame,
                                                "Please enter valid rental hours!");
                        }
                });

                btnConfirm.addActionListener(e -> {

                        try {

                                int hours = Integer.parseInt(
                                                txtHours.getText());

                                if (hours <= 0) {

                                        JOptionPane.showMessageDialog(
                                                        frame,
                                                        "Rental hours must be greater than 0!");

                                        return;
                                }

                                String vehicleType = (String) vehicleBox.getSelectedItem();

                                Rental rental = new Rental(

                                                RentalManager.generateRentalId(),
                                                LoginManager.currentUserEmail,

                                                vehicleType,

                                                hours);

                                RentalManager manager = new RentalManager();

                                manager.rentVehicle(rental);

                                JOptionPane.showMessageDialog(
                                                frame,
                                                "Vehicle Rental Successful!\n"
                                                                + "Rental ID: "
                                                                + rental.getRentalId()
                                                                + "\nFare: "
                                                                + rental.calculateRentalFare()
                                                                + " BDT");

                        } catch (NumberFormatException ex) {

                                JOptionPane.showMessageDialog(
                                                frame,
                                                "Please enter valid rental hours!");
                        }
                });

                btnBack.addActionListener(e -> {

                        frame.dispose();

                        UserDashboard.main(null);
                });

                frame.add(title);

                frame.add(vehicleLabel);
                frame.add(vehicleBox);

                frame.add(hoursLabel);
                frame.add(txtHours);

                frame.add(fareLabel);

                frame.add(btnCalculate);
                frame.add(btnConfirm);
                frame.add(btnBack);

                frame.setVisible(true);
        }
}
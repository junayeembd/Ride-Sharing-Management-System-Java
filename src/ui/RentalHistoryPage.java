package ui;

import model.Rental;

import service.LoginManager;
import service.RentalManager;

import javax.swing.*;

public class RentalHistoryPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Rental History");

        frame.setSize(700, 500);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("My Rental History");

        title.setBounds(
                280,
                20,
                180,
                30);

        JTextArea rentalArea = new JTextArea();

        rentalArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(rentalArea);

        scrollPane.setBounds(
                50,
                70,
                580,
                300);

        String rentalData = "";

        for (Rental rental : RentalManager.rentals) {

            if (LoginManager.currentUserEmail.equals(
                    rental.getUserEmail())) {

                rentalData += "Rental ID : "
                        + rental.getRentalId()

                        + "\nVehicle : "
                        + rental.getVehicleType()

                        + "\nRental Hours : "
                        + rental.getHours()

                        + "\nRental Fare : "
                        + rental.getRentalFare()
                        + " BDT"

                        + "\n-----------------------------\n";
            }
        }

        if (rentalData.isEmpty()) {

            rentalArea.setText(
                    "No rental history available.");

        } else {

            rentalArea.setText(rentalData);
        }

        JButton btnBack = new JButton("Back");

        btnBack.setBounds(
                290,
                400,
                120,
                35);

        btnBack.addActionListener(e -> {

            frame.dispose();

            UserDashboard.main(null);
        });

        frame.add(title);
        frame.add(scrollPane);
        frame.add(btnBack);

        frame.setVisible(true);
    }
}
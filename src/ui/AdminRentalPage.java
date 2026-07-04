package ui;

import model.Rental;
import service.RentalManager;
import javax.swing.*;

public class AdminRentalPage {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Rental Records");
        frame.setSize(700, 520);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("All Rental Records");
        title.setBounds(280, 20, 180, 30);

        JTextArea rentalArea = new JTextArea();
        rentalArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(rentalArea);
        scrollPane.setBounds(50, 70, 580, 320);

        String rentalData = "";

        for (Rental rental : RentalManager.rentals) {
            rentalData += "Rental ID : "
                    + rental.getRentalId()
                    + "\nUser : "
                    + rental.getUserEmail()
                    + "\nVehicle : "
                    + rental.getVehicleType()
                    + "\nRental Hours : "
                    + rental.getHours()
                    + "\nRental Fare : "
                    + rental.getRentalFare()
                    + " BDT"
                    + "\n----------------------------------\n";
        }

        if (rentalData.isEmpty()) {
            rentalArea.setText(
                    "No rental records available.");

        } else {

            rentalArea.setText(rentalData);
        }
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(290, 420, 120, 35);

        btnBack.addActionListener(e -> {
            frame.dispose();
            AdminDashboard.main(null);
        });

        frame.add(title);
        frame.add(scrollPane);
        frame.add(btnBack);
        frame.setVisible(true);
    }
}
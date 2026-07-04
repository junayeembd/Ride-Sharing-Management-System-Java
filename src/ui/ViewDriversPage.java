package ui;

import model.Driver;
import service.RegisterManager;

import javax.swing.*;

public class ViewDriversPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("View Drivers");
        frame.setSize(700, 520);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Registered Drivers");
        title.setBounds(280, 20, 180, 30);

        JTextArea driverArea = new JTextArea();
        driverArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(driverArea);
        scrollPane.setBounds(50, 70, 580, 320);

        String driverData = "";
        int driverNumber = 1;
        for (Driver driver : RegisterManager.drivers) {
            driverData += "Driver No : " + driverNumber
                    + "\nName : " + driver.getName()
                    + "\nPhone : " + driver.getPhone()
                    + "\nEmail : " + driver.getEmail()
                    + "\nAddress : " + driver.getAddress()
                    + "\nVehicle Type : "
                    + driver.getVehicleType()
                    + "\nDriving License : "
                    + driver.getDrivingLicense()
                    + "\nVehicle No : "
                    + driver.getVehicleNo()
                    + "\n-----------------------------\n";

            driverNumber++;
        }
        if (driverData.isEmpty()) {
            driverArea.setText("No registered drivers available.");
        } else {
            driverArea.setText(driverData);
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
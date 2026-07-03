package ui;

import model.Ride;
import service.RideManager;
import service.LoginManager;

import javax.swing.*;

public class EarningsPage {

        public static void main(String[] args) {

                JFrame frame = new JFrame("Driver Earnings");

                frame.setSize(600, 450);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JLabel title = new JLabel("Driver Earnings");

                title.setBounds(
                                240,
                                30,
                                150,
                                30);

                int completedRides = 0;

                double totalEarnings = 0;

                for (Ride ride : RideManager.rides) {

                        if (ride.getStatus().equals("Completed")
                                        && LoginManager.currentDriverEmail.equals(ride.getDriverEmail())) {

                                completedRides++;

                                totalEarnings += ride.getFare();
                        }
                }

                JLabel rideLabel = new JLabel(
                                "Completed Rides : " + completedRides);

                rideLabel.setBounds(
                                180,
                                110,
                                250,
                                30);

                JLabel earningsLabel = new JLabel(
                                "Total Earnings : "
                                                + totalEarnings
                                                + " BDT");

                earningsLabel.setBounds(
                                180,
                                170,
                                250,
                                30);

                JButton btnBack = new JButton("Back");

                btnBack.setBounds(
                                230,
                                250,
                                120,
                                35);

                btnBack.addActionListener(e -> {

                        frame.dispose();

                        DriverDashboard.main(null);
                });

                frame.add(title);
                frame.add(rideLabel);
                frame.add(earningsLabel);
                frame.add(btnBack);

                frame.setVisible(true);
        }
}
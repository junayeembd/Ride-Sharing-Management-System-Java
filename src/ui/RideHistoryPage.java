package ui;

import model.Ride;
import service.RideManager;
import service.LoginManager;
import javax.swing.*;

public class RideHistoryPage {

        public static void main(String[] args) {

                JFrame frame = new JFrame("Ride History");
                frame.setSize(700, 500);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JLabel title = new JLabel("Ride History");
                title.setBounds(300, 20, 150, 30);

                JTextArea history = new JTextArea();
                history.setEditable(false);
                JScrollPane scroll = new JScrollPane(history);
                scroll.setBounds(50, 70, 580, 280);

                String rideHistory = "";
                for (Ride ride : RideManager.rides) {
                        if (LoginManager.currentUserEmail.equals(ride.getUserEmail())) {
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
                        history.setText("No ride history available.");
                } else {
                        history.setText(rideHistory);
                }

                JButton back = new JButton("Back");
                back.setBounds(280, 380, 120, 35);
                back.addActionListener(e -> {
                        frame.dispose();
                        UserDashboard.main(null);
                });

                frame.add(title);
                frame.add(scroll);
                frame.add(back);
                frame.setVisible(true);
        }
}
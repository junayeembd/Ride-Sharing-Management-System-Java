package ui;

import javax.swing.*;

public class DriverDashboard {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Driver Dashboard");

        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Welcome Driver");
        title.setBounds(240, 30, 150, 30);

        JButton rideRequest = new JButton("Ride Requests");
        rideRequest.setBounds(200, 100, 180, 40);

        JButton activeRide = new JButton("Active Ride");
        activeRide.setBounds(200, 160, 180, 40);

        JButton rideHistory = new JButton("Ride History");
        rideHistory.setBounds(200, 220, 180, 40);

        JButton earnings = new JButton("Earnings");
        earnings.setBounds(200, 280, 180, 40);

        JButton logout = new JButton("Logout");
        logout.setBounds(200, 340, 180, 40);

        logout.addActionListener(e -> {

            frame.dispose();

            LoginPage.main(null);
        });

        frame.add(title);
        frame.add(rideRequest);
        frame.add(activeRide);
        frame.add(rideHistory);
        frame.add(earnings);
        frame.add(logout);

        frame.setVisible(true);
    }
}
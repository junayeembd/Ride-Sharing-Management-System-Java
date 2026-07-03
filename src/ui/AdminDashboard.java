package ui;

import javax.swing.*;

public class AdminDashboard {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Admin Dashboard");

        frame.setSize(600, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Welcome Admin");

        title.setBounds(
                240,
                30,
                150,
                30);

        JButton viewUsers = new JButton("View Users");

        viewUsers.setBounds(
                200,
                100,
                180,
                40);

        JButton viewDrivers = new JButton("View Drivers");

        viewDrivers.setBounds(
                200,
                160,
                180,
                40);

        JButton viewRides = new JButton("View All Rides");

        viewRides.setBounds(
                200,
                220,
                180,
                40);

        JButton viewPayments = new JButton("View Payments");

        viewPayments.setBounds(
                200,
                280,
                180,
                40);
        JButton viewRentals = new JButton("View Rentals");
        viewRentals.setBounds(200, 340, 180, 40);
        viewRentals.addActionListener(e -> {

            frame.dispose();

            AdminRentalPage.main(null);
        });

        JButton logout = new JButton("Logout");

        logout.setBounds(
                200,
                400,
                180,
                40);

        viewUsers.addActionListener(e -> {

            frame.dispose();

            ViewUsersPage.main(null);
        });

        viewDrivers.addActionListener(e -> {

            frame.dispose();

            ViewDriversPage.main(null);
        });

        viewRides.addActionListener(e -> {

            frame.dispose();

            AdminRidePage.main(null);
        });

        viewPayments.addActionListener(e -> {

            frame.dispose();

            AdminPaymentPage.main(null);
        });

        logout.addActionListener(e -> {

            frame.dispose();

            LoginPage.main(null);
        });

        frame.add(title);

        frame.add(viewUsers);
        frame.add(viewDrivers);
        frame.add(viewRides);
        frame.add(viewPayments);
        frame.add(viewRentals);
        frame.add(logout);

        frame.setVisible(true);
    }
}
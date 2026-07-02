package ui;

import javax.swing.*;

public class UserDashboard {

        public static void main(String[] args) {

                JFrame frame = new JFrame("User Dashboard");

                frame.setSize(600, 400);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JLabel title = new JLabel("Welcome User");

                title.setBounds(
                                240,
                                30,
                                150,
                                30);

                JButton bookRide = new JButton("Book Ride");

                bookRide.setBounds(
                                200,
                                100,
                                150,
                                40);

                JButton rental = new JButton("Rental");

                rental.setBounds(
                                200,
                                160,
                                150,
                                40);

                JButton payment = new JButton("Payment");

                payment.setBounds(
                                200,
                                220,
                                150,
                                40);
                payment.addActionListener(e -> {
                        frame.dispose();
                        PaymentPage.main(null);
                });

                JButton rating = new JButton("Rating");

                rating.setBounds(
                                200,
                                280,
                                150,
                                40);
                JButton history = new JButton("Ride History");
                history.setBounds(200, 340, 150, 40);
                history.addActionListener(e -> {

                        frame.dispose();

                        RideHistoryPage.main(null);

                });

                JButton logout = new JButton("Logout");
                logout.setBounds(200, 400, 150, 40);

                logout.addActionListener(
                                e -> {
                                        frame.dispose();
                                        LoginPage.main(null);
                                });

                frame.add(title);
                frame.add(bookRide);
                frame.add(rental);
                frame.add(payment);
                frame.add(rating);
                frame.add(history);
                frame.add(logout);

                frame.setVisible(true);
        }
}
package ui;

import model.Payment;
import model.Ride;
import service.LoginManager;
import service.PaymentManager;
import service.RideManager;
import javax.swing.*;

public class PaymentPage {
        public static void main(String[] args) {

                JFrame frame = new JFrame("Payment");
                frame.setSize(600, 500);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JLabel title = new JLabel("Ride Payment");
                title.setBounds(250, 30, 150, 30);

                JLabel rideIdLabel = new JLabel("Ride ID");
                rideIdLabel.setBounds(100, 100, 120, 30);

                JTextField txtRideId = new JTextField();
                txtRideId.setBounds(230, 100, 220, 30);

                JLabel methodLabel = new JLabel("Payment Method");
                methodLabel.setBounds(100, 160, 120, 30);

                String[] methods = { "Cash", "bKash", "Nagad", "Card" };
                JComboBox<String> paymentBox = new JComboBox<>(methods);
                paymentBox.setBounds(230, 160, 220, 30);

                JLabel amountLabel = new JLabel("Amount : 0.00 BDT");
                amountLabel.setBounds(230, 220, 250, 30);

                JButton btnFind = new JButton("Find Ride");
                btnFind.setBounds(150, 290, 120, 35);

                JButton btnPay = new JButton("Pay Now");
                btnPay.setBounds(290, 290, 120, 35);

                JButton btnBack = new JButton("Back");
                btnBack.setBounds(220, 360, 120, 35);

                btnFind.addActionListener(e -> {
                        try {
                                int rideId = Integer.parseInt(txtRideId.getText());
                                Ride foundRide = null;
                                for (Ride ride : RideManager.rides) {
                                        if (ride.getRideId() == rideId && ride.getStatus().equals("Completed")
                                                        && LoginManager.currentUserEmail.equals(ride.getUserEmail())) {
                                                foundRide = ride;
                                                break;
                                        }
                                }

                                if (foundRide == null) {
                                        JOptionPane.showMessageDialog(frame, "Ride Not Found!");
                                        return;
                                }
                                amountLabel.setText("Amount : " + foundRide.getFare() + " BDT");

                        } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(frame, "Please enter a valid Ride ID!");
                        }
                });

                btnPay.addActionListener(e -> {
                        try {
                                int rideId = Integer.parseInt(txtRideId.getText());
                                Ride foundRide = null;
                                for (Ride ride : RideManager.rides) {
                                        if (ride.getRideId() == rideId
                                                        && LoginManager.currentUserEmail.equals(ride.getUserEmail())) {
                                                foundRide = ride;
                                                break;
                                        }
                                }

                                if (foundRide == null) {
                                        JOptionPane.showMessageDialog(frame, "Ride Not Found!");
                                        return;
                                }
                                PaymentManager manager = new PaymentManager();
                                if (manager.isRideAlreadyPaid(rideId)) {
                                        JOptionPane.showMessageDialog(frame, "This Ride is Already Paid!");
                                        return;
                                }
                                String paymentMethod = (String) paymentBox.getSelectedItem();
                                Payment payment = new Payment(
                                                PaymentManager.generatePaymentId(), rideId,
                                                LoginManager.currentUserEmail,
                                                foundRide.getFare(), paymentMethod, "Paid");

                                manager.makePayment(payment);
                                JOptionPane.showMessageDialog(frame, "Payment Successful!\n\n"
                                                + "Payment ID: "
                                                + payment.getPaymentId()
                                                + "\nRide ID: "
                                                + payment.getRideId()
                                                + "\nAmount: "
                                                + payment.getAmount()
                                                + " BDT"
                                                + "\nMethod: "
                                                + payment.getPaymentMethod());

                                txtRideId.setText("");
                                amountLabel.setText("Amount : 0.00 BDT");

                        } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(frame, "Please enter a valid Ride ID!");
                        }
                });
                btnBack.addActionListener(e -> {
                        frame.dispose();
                        UserDashboard.main(null);
                });

                frame.add(title);
                frame.add(rideIdLabel);
                frame.add(txtRideId);
                frame.add(methodLabel);
                frame.add(paymentBox);
                frame.add(amountLabel);
                frame.add(btnFind);
                frame.add(btnPay);
                frame.add(btnBack);
                frame.setVisible(true);
        }
}
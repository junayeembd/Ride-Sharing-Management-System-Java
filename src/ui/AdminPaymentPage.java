package ui;

import model.Payment;
import service.PaymentManager;

import javax.swing.*;

public class AdminPaymentPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Payment Records");

        frame.setSize(700, 520);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("All Payment Records");

        title.setBounds(
                280,
                20,
                200,
                30);

        JTextArea paymentArea = new JTextArea();

        paymentArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(paymentArea);

        scrollPane.setBounds(
                50,
                70,
                580,
                320);

        String paymentData = "";

        for (Payment payment : PaymentManager.payments) {

            paymentData += "Payment ID : "
                    + payment.getPaymentId()
                    + "\nRide ID : "
                    + payment.getRideId()
                    + "\nUser : "
                    + payment.getUserEmail()
                    + "\nAmount : "
                    + payment.getAmount()
                    + " BDT"
                    + "\nPayment Method : "
                    + payment.getPaymentMethod()
                    + "\nPayment Status : "
                    + payment.getPaymentStatus()
                    + "\n----------------------------------\n";
        }

        if (paymentData.isEmpty()) {

            paymentArea.setText(
                    "No payment records available.");

        } else {

            paymentArea.setText(paymentData);
        }

        JButton btnBack = new JButton("Back");

        btnBack.setBounds(
                290,
                420,
                120,
                35);

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
package ui;

import javax.swing.*;

public class PaymentPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Payment");

        frame.setSize(600, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Payment");
        title.setBounds(260, 20, 150, 30);

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(80, 80, 100, 30);

        JTextField txtAmount = new JTextField();
        txtAmount.setBounds(220, 80, 220, 30);

        JLabel methodLabel = new JLabel("Payment Method");
        methodLabel.setBounds(80, 140, 120, 30);

        String[] methods = {
                "Cash",
                "bKash",
                "Nagad",
                "Card"
        };

        JComboBox<String> paymentBox = new JComboBox<>(methods);

        paymentBox.setBounds(220, 140, 220, 30);

        JButton btnPay = new JButton("Pay Now");

        btnPay.setBounds(220, 220, 120, 35);

        JButton btnBack = new JButton("Back");

        btnBack.setBounds(360, 220, 80, 35);

        btnPay.addActionListener(e -> {

            String amount = txtAmount.getText();

            String method = (String) paymentBox.getSelectedItem();

            if (amount.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Enter Amount!");

            }

            else {

                JOptionPane.showMessageDialog(

                        frame,

                        "Payment Successful!\n\n"
                                + "Amount : " + amount
                                + "\nMethod : " + method

                );

            }

        });

        btnBack.addActionListener(e -> {

            frame.dispose();

            UserDashboard.main(null);

        });

        frame.add(title);

        frame.add(amountLabel);
        frame.add(txtAmount);

        frame.add(methodLabel);
        frame.add(paymentBox);

        frame.add(btnPay);
        frame.add(btnBack);

        frame.setVisible(true);

    }

}
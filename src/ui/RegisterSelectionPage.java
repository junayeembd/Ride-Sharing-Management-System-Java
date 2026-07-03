package ui;

import javax.swing.*;

public class RegisterSelectionPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Registration");

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Select Registration Type");
        title.setBounds(170, 40, 200, 30);

        JButton btnUser = new JButton("Register as User");
        btnUser.setBounds(150, 110, 200, 45);

        JButton btnDriver = new JButton("Register as Driver");
        btnDriver.setBounds(150, 180, 200, 45);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(190, 260, 120, 40);

        btnUser.addActionListener(e -> {

            frame.dispose();

            RegisterPage.main(null);
        });

        btnDriver.addActionListener(e -> {

            frame.dispose();

            DriverRegisterPage.main(null);
        });

        btnBack.addActionListener(e -> {

            frame.dispose();

            LoginPage.main(null);
        });

        frame.add(title);
        frame.add(btnUser);
        frame.add(btnDriver);
        frame.add(btnBack);

        frame.setVisible(true);
    }
}
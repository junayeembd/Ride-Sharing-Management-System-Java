package ui;

import javax.swing.*;

import service.LoginManager;

public class LoginPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Ride Sharing System");

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        JLabel title = new JLabel("Ride Sharing System");
        title.setBounds(220, 30, 200, 30);

        // Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(80, 100, 100, 30);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(180, 100, 180, 30);

        // Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(80, 150, 100, 30);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 150, 180, 30);

        // Login Button
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(180, 220, 100, 35);

        // Register Button
        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(290, 220, 100, 35);

        // Login Event
        btnLogin.addActionListener(e -> {

            String email = txtEmail.getText();
            String password = String.valueOf(txtPassword.getPassword());

            if (email.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter Email and Password!");

            } else {

                LoginManager manager = new LoginManager();

                boolean success = manager.userLogin(email, password);

                if (success) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    frame.dispose();
                    UserDashboard.main(null);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Email or Password!");
                }
            }
        });

        // Register Event
        btnRegister.addActionListener(e -> {
            frame.dispose();
            RegisterPage.main(null);
        });

        // Add Components
        frame.add(title);
        frame.add(emailLabel);
        frame.add(txtEmail);
        frame.add(passLabel);
        frame.add(txtPassword);
        frame.add(btnLogin);
        frame.add(btnRegister);

        frame.setVisible(true);
    }
}
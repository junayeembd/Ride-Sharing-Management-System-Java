package ui;

import javax.swing.*;

import service.LoginManager;

public class LoginPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Ride Sharing System");

        frame.setSize(500, 420);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        JLabel title = new JLabel("Ride Sharing System");
        title.setBounds(180, 30, 200, 30);

        // Role
        JLabel roleLabel = new JLabel("Login As");
        roleLabel.setBounds(80, 90, 100, 30);

        String[] roles = {
                "User",
                "Driver",
                "Admin"
        };

        JComboBox<String> roleBox = new JComboBox<>(roles);
        roleBox.setBounds(180, 90, 180, 30);

        // Email
        JLabel emailLabel = new JLabel("Email / Admin ID");
        emailLabel.setBounds(80, 140, 100, 30);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(180, 140, 180, 30);

        // Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(80, 190, 100, 30);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 190, 180, 30);

        // Login Button
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 260, 100, 35);

        // Register Button
        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(270, 260, 100, 35);

        // Login Event
        btnLogin.addActionListener(e -> {

            String email = txtEmail.getText();

            String password = String.valueOf(
                    txtPassword.getPassword());

            String role = (String) roleBox.getSelectedItem();

            if (email.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter Email and Password!");

                return;
            }

            LoginManager manager = new LoginManager();

            boolean success = false;

            if (role.equals("User")) {

                success = manager.userLogin(
                        email,
                        password);

            } else if (role.equals("Driver")) {

                success = manager.driverLogin(
                        email,
                        password);

            } else if (role.equals("Admin")) {

                success = manager.adminLogin(
                        email,
                        password);
            }

            if (success) {

                JOptionPane.showMessageDialog(
                        frame,
                        role + " Login Successful!");

                frame.dispose();

                if (role.equals("User")) {

                    UserDashboard.main(null);

                } else if (role.equals("Driver")) {

                    DriverDashboard.main(null);

                } else {

                    AdminDashboard.main(null);
                }

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid " + role
                                + " Login Information!");
            }
        });

        // Register Event
        btnRegister.addActionListener(e -> {

            frame.dispose();

            RegisterSelectionPage.main(null);
        });

        // Add Components
        frame.add(title);

        frame.add(roleLabel);
        frame.add(roleBox);

        frame.add(emailLabel);
        frame.add(txtEmail);

        frame.add(passLabel);
        frame.add(txtPassword);

        frame.add(btnLogin);
        frame.add(btnRegister);

        frame.setVisible(true);
    }
}
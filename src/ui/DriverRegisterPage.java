package ui;

import model.Driver;
import service.RegisterManager;

import javax.swing.*;

public class DriverRegisterPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Driver Registration");

        frame.setSize(650, 650);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Driver Registration");
        title.setBounds(250, 20, 200, 30);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(80, 70, 130, 30);

        JTextField txtName = new JTextField();
        txtName.setBounds(230, 70, 250, 30);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(80, 120, 130, 30);

        JTextField txtPhone = new JTextField();
        txtPhone.setBounds(230, 120, 250, 30);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(80, 170, 130, 30);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(230, 170, 250, 30);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(80, 220, 130, 30);

        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(230, 220, 250, 30);

        JLabel vehicleLabel = new JLabel("Vehicle Type");
        vehicleLabel.setBounds(80, 270, 130, 30);

        String[] vehicles = {
                "Bike",
                "CNG",
                "Private"
        };

        JComboBox<String> vehicleBox = new JComboBox<>(vehicles);

        vehicleBox.setBounds(230, 270, 250, 30);

        JLabel licenseLabel = new JLabel("Driving License");
        licenseLabel.setBounds(80, 320, 130, 30);

        JTextField txtLicense = new JTextField();
        txtLicense.setBounds(230, 320, 250, 30);

        JLabel vehicleNoLabel = new JLabel("Vehicle No");
        vehicleNoLabel.setBounds(80, 370, 130, 30);

        JTextField txtVehicleNo = new JTextField();
        txtVehicleNo.setBounds(230, 370, 250, 30);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(80, 420, 130, 30);

        JPasswordField txtPassword = new JPasswordField();

        txtPassword.setBounds(230, 420, 250, 30);

        JLabel confirmLabel = new JLabel("Confirm Password");

        confirmLabel.setBounds(80, 470, 130, 30);

        JPasswordField txtConfirm = new JPasswordField();

        txtConfirm.setBounds(230, 470, 250, 30);

        JButton btnRegister = new JButton("Register");

        btnRegister.setBounds(230, 530, 120, 35);

        JButton btnBack = new JButton("Back");

        btnBack.setBounds(360, 530, 120, 35);

        btnRegister.addActionListener(e -> {

            String name = txtName.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();

            String vehicleType = (String) vehicleBox.getSelectedItem();

            String drivingLicense = txtLicense.getText();

            String vehicleNo = txtVehicleNo.getText();

            String password = String.valueOf(
                    txtPassword.getPassword());

            String confirmPassword = String.valueOf(
                    txtConfirm.getPassword());

            if (name.isEmpty()
                    || phone.isEmpty()
                    || email.isEmpty()
                    || address.isEmpty()
                    || drivingLicense.isEmpty()
                    || vehicleNo.isEmpty()
                    || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please fill all fields!");

                return;
            }

            if (!password.equals(confirmPassword)) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Passwords do not match!");

                return;
            }

            Driver driver = new Driver(
                    name,
                    phone,
                    email,
                    address,
                    vehicleType,
                    drivingLicense,
                    vehicleNo,
                    password);

            RegisterManager manager = new RegisterManager();

            manager.registerDriver(driver);

            JOptionPane.showMessageDialog(
                    frame,
                    "Driver Registration Successful!");

            frame.dispose();

            LoginPage.main(null);
        });

        btnBack.addActionListener(e -> {

            frame.dispose();

            RegisterSelectionPage.main(null);
        });

        frame.add(title);

        frame.add(nameLabel);
        frame.add(txtName);

        frame.add(phoneLabel);
        frame.add(txtPhone);

        frame.add(emailLabel);
        frame.add(txtEmail);

        frame.add(addressLabel);
        frame.add(txtAddress);

        frame.add(vehicleLabel);
        frame.add(vehicleBox);

        frame.add(licenseLabel);
        frame.add(txtLicense);

        frame.add(vehicleNoLabel);
        frame.add(txtVehicleNo);

        frame.add(passwordLabel);
        frame.add(txtPassword);

        frame.add(confirmLabel);
        frame.add(txtConfirm);

        frame.add(btnRegister);
        frame.add(btnBack);

        frame.setVisible(true);
    }
}
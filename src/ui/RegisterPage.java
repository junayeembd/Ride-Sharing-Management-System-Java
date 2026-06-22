package ui;

import javax.swing.*;

import model.User;
import service.RegisterManager;

public class RegisterPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("GOMON Register");

        frame.setSize(600, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("User Registration");
        title.setBounds(240, 20, 150, 30);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(80, 80, 120, 30);

        JTextField txtName = new JTextField();
        txtName.setBounds(220, 80, 250, 30);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(80, 130, 120, 30);

        JTextField txtPhone = new JTextField();
        txtPhone.setBounds(220, 130, 250, 30);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(80, 180, 120, 30);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(220, 180, 250, 30);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(80, 230, 120, 30);

        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(220, 230, 250, 30);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(80, 280, 120, 30);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(220, 280, 250, 30);

        JLabel confirmLabel = new JLabel("Confirm Password");
        confirmLabel.setBounds(80, 330, 120, 30);

        JPasswordField txtConfirm = new JPasswordField();
        txtConfirm.setBounds(220, 330, 250, 30);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(220, 400, 120, 35);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(350, 400, 120, 35);

        btnRegister.addActionListener(e -> {

            String name = txtName.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();

            String password = String.valueOf(txtPassword.getPassword());
            String confirmPassword = String.valueOf(txtConfirm.getPassword());

            if (!password.equals(confirmPassword)) {

                JOptionPane.showMessageDialog(frame, "Passwords do not match!");

                return;
            }

            User user = new User(name, phone, email, address, password);

            RegisterManager manager = new RegisterManager();
            manager.registerUser(user);

            JOptionPane.showMessageDialog(frame, "Registration Successful!");
        });

        btnBack.addActionListener(e -> {

            frame.dispose();
            LoginPage.main(null);

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

        frame.add(passLabel);
        frame.add(txtPassword);

        frame.add(confirmLabel);
        frame.add(txtConfirm);

        frame.add(btnRegister);
        frame.add(btnBack);

        frame.setVisible(true);
    }

}
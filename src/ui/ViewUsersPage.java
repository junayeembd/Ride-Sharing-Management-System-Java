package ui;

import model.User;
import service.RegisterManager;

import javax.swing.*;

public class ViewUsersPage {

    public static void main(String[] args) {
        JFrame frame = new JFrame("View Users");
        frame.setSize(700, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Registered Users");
        title.setBounds(290, 20, 150, 30);
        JTextArea userArea = new JTextArea();
        userArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(userArea);
        scrollPane.setBounds(50, 70, 580, 300);

        String userData = "";
        int userNumber = 1;
        for (User user : RegisterManager.users) {
            userData += "User No : " + userNumber
                    + "\nName : " + user.getName()
                    + "\nPhone : " + user.getPhone()
                    + "\nEmail : " + user.getEmail()
                    + "\nAddress : " + user.getAddress()
                    + "\n-----------------------------\n";

            userNumber++;
        }

        if (userData.isEmpty()) {
            userArea.setText(
                    "No registered users available.");

        } else {
            userArea.setText(userData);
        }

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(290, 400, 120, 35);

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
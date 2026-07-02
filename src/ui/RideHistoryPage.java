package ui;

import javax.swing.*;

public class RideHistoryPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Ride History");

        frame.setSize(700, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Ride History");

        title.setBounds(
                300,
                20,
                150,
                30);

        JTextArea history = new JTextArea();

        history.setEditable(false);

        history.setText(

                "Ride ID : 1\n"

                        + "Pickup : Uttara\n"

                        + "Destination : Dhanmondi\n"

                        + "Vehicle : Bike\n"

                        + "Fare : 150 BDT\n"

                        + "Status : Completed"

        );

        JScrollPane scroll = new JScrollPane(history);

        scroll.setBounds(
                50,
                70,
                580,
                280);

        JButton back = new JButton("Back");

        back.setBounds(
                280,
                380,
                120,
                35);

        back.addActionListener(e -> {

            frame.dispose();

            UserDashboard.main(null);

        });

        frame.add(title);
        frame.add(scroll);
        frame.add(back);

        frame.setVisible(true);

    }

}
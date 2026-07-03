package ui;

import model.Rating;
import model.Ride;

import service.LoginManager;
import service.RatingManager;
import service.RideManager;

import javax.swing.*;

public class RatingPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Ride Rating");

        frame.setSize(650, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Rate Your Ride");

        title.setBounds(
                270,
                20,
                150,
                30);

        JLabel rideIdLabel = new JLabel("Ride ID");

        rideIdLabel.setBounds(
                100,
                90,
                100,
                30);

        JTextField txtRideId = new JTextField();

        txtRideId.setBounds(
                230,
                90,
                250,
                30);

        JLabel ratingLabel = new JLabel("Rating");

        ratingLabel.setBounds(
                100,
                150,
                100,
                30);

        String[] ratingValues = {
                "1",
                "2",
                "3",
                "4",
                "5"
        };

        JComboBox<String> ratingBox = new JComboBox<>(ratingValues);

        ratingBox.setBounds(
                230,
                150,
                250,
                30);

        JLabel reviewLabel = new JLabel("Review");

        reviewLabel.setBounds(
                100,
                210,
                100,
                30);

        JTextArea txtReview = new JTextArea();

        JScrollPane reviewScroll = new JScrollPane(txtReview);

        reviewScroll.setBounds(
                230,
                210,
                250,
                100);

        JButton btnSubmit = new JButton("Submit Rating");

        btnSubmit.setBounds(
                200,
                350,
                140,
                35);

        JButton btnBack = new JButton("Back");

        btnBack.setBounds(
                360,
                350,
                100,
                35);

        btnSubmit.addActionListener(e -> {

            try {

                int rideId = Integer.parseInt(
                        txtRideId.getText());

                int ratingValue = Integer.parseInt(
                        (String) ratingBox.getSelectedItem());

                String review = txtReview.getText();

                Ride completedRide = null;

                for (Ride ride : RideManager.rides) {

                    if (ride.getRideId() == rideId
                            && ride.getStatus().equals("Completed")
                            && LoginManager.currentUserEmail.equals(
                                    ride.getUserEmail())) {

                        completedRide = ride;

                        break;
                    }
                }

                if (completedRide == null) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Completed Ride Not Found!");

                    return;
                }

                RatingManager manager = new RatingManager();

                if (manager.isRideAlreadyRated(rideId)) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "This Ride is Already Rated!");

                    return;
                }

                Rating rating = new Rating(

                        RatingManager.generateRatingId(),

                        rideId,

                        LoginManager.currentUserEmail,

                        ratingValue,

                        review);

                manager.addRating(rating);

                JOptionPane.showMessageDialog(
                        frame,
                        "Rating Submitted Successfully!");

                txtRideId.setText("");

                txtReview.setText("");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid Ride ID!");
            }
        });

        btnBack.addActionListener(e -> {

            frame.dispose();

            UserDashboard.main(null);
        });

        frame.add(title);

        frame.add(rideIdLabel);
        frame.add(txtRideId);

        frame.add(ratingLabel);
        frame.add(ratingBox);

        frame.add(reviewLabel);
        frame.add(reviewScroll);

        frame.add(btnSubmit);
        frame.add(btnBack);

        frame.setVisible(true);
    }
}
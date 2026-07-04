package service;

import model.Rating;

import java.util.ArrayList;

public class RatingManager {
    public static ArrayList<Rating> ratings = new ArrayList<>();
    private static int nextRatingId = 1;

    public static int generateRatingId() {

        return nextRatingId++;
    }

    public void addRating(Rating rating) {

        ratings.add(rating);
        System.out.println("Rating Submitted Successfully!");
        rating.displayRating();
    }

    public boolean isRideAlreadyRated(int rideId) {

        for (Rating rating : ratings) {

            if (rating.getRideId() == rideId) {

                return true;
            }
        }
        return false;
    }
}
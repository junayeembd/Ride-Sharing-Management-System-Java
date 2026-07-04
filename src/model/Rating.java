package model;

public class Rating {
    private int ratingId;
    private int rideId;
    private String userEmail;
    private int ratingValue;
    private String review;

    public Rating(int ratingId, int rideId, String userEmail, int ratingValue, String review) {
        this.ratingId = ratingId;
        this.rideId = rideId;
        this.userEmail = userEmail;
        this.ratingValue = ratingValue;
        this.review = review;
    }

    public int getRatingId() {
        return ratingId;
    }

    public int getRideId() {
        return rideId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public String getReview() {
        return review;
    }

    public void displayRating() {

        System.out.println("\n===== Rating Details =====");
        System.out.println("Rating ID: " + ratingId);
        System.out.println("Ride ID: " + rideId);
        System.out.println("User: " + userEmail);
        System.out.println("Rating: " + ratingValue + "/5");
        System.out.println("Review: " + review);
    }
}
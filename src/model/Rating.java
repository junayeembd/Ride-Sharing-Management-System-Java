package model;

public class Rating {

    private int ratingValue;
    private String review;

    public Rating(int ratingValue,
                  String review) {

        this.ratingValue = ratingValue;
        this.review = review;
    }

    public void displayRating() {

        System.out.println("\n===== Rating =====");

        System.out.println("Rating: " + ratingValue + "/5");
        System.out.println("Review: " + review);
    }
}
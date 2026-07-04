package model;

public class Payment {
    private int paymentId;
    private int rideId;
    private String userEmail;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    public Payment(int paymentId, int rideId, String userEmail, double amount, String paymentMethod,
            String paymentStatus) {
        this.paymentId = paymentId;
        this.rideId = rideId;
        this.userEmail = userEmail;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getRideId() {
        return rideId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void displayPaymentInfo() {

        System.out.println("\n===== Payment Details =====");

        System.out.println("Payment ID: " + paymentId);
        System.out.println("Ride ID: " + rideId);
        System.out.println("User: " + userEmail);
        System.out.println("Amount: " + amount + " BDT");
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Status: " + paymentStatus);
    }
}
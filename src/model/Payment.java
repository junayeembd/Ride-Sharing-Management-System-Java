package model;

public class Payment {

    private int paymentId;
    private double amount;
    private String paymentMethod;

    public Payment(int paymentId,
                   double amount,
                   String paymentMethod) {

        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void paymentInfo() {

        System.out.println("\n===== Payment =====");

        System.out.println("Payment ID: " + paymentId);
        System.out.println("Amount: " + amount);
        System.out.println("Method: " + paymentMethod);
    }
}
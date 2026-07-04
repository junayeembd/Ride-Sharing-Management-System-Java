package service;

import model.Payment;
import java.util.ArrayList;

public class PaymentManager {

    public static ArrayList<Payment> payments = new ArrayList<>();
    private static int nextPaymentId = 1;

    public static int generatePaymentId() {

        return nextPaymentId++;
    }

    public void makePayment(Payment payment) {

        payments.add(payment);
        System.out.println("Payment Successful!");
        payment.displayPaymentInfo();
    }

    public boolean isRideAlreadyPaid(int rideId) {

        for (Payment payment : payments) {

            if (payment.getRideId() == rideId && payment.getPaymentStatus().equals("Paid")) {

                return true;
            }
        }
        return false;
    }
}
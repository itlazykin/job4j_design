package ru.job4j.ood.ocp;

public class PaymentProcessor {
    public void processPayment(String paymentType) {
        if (paymentType.equals("CreditCard")) {
            paymentType = "ok";
        } else if (paymentType.equals("PayPal")) {
            paymentType = "not ok";
        } else if (paymentType.equals("BankTransfer")) {
            paymentType = "maybe";
        }
    }
}

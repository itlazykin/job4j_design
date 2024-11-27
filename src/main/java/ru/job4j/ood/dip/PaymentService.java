package ru.job4j.ood.dip;

public class PaymentService {
    private final PayPalPayment payPalPayment;

    public PaymentService(PayPalPayment payPalPayment) {
        this.payPalPayment = payPalPayment;
    }

    public void pay(double amount) {
        payPalPayment.processPayment(amount);
    }
}

class PayPalPayment {
    public void processPayment(double amount) {
        System.out.println("Processing payment via PayPal: $" + amount);
    }
}

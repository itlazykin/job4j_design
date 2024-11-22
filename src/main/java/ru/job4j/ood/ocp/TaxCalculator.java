package ru.job4j.ood.ocp;

public class TaxCalculator {
    public double calculateTax(String country, double amount) {
        if (country.equals("USA")) {
            return amount * 0.07;
        } else if (country.equals("UK")) {
            return amount * 0.2;
        } else if (country.equals("Germany")) {
            return amount * 0.19;
        } else {
            return 0;
        }
    }
}

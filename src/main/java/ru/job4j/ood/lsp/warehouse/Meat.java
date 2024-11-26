package ru.job4j.ood.lsp.warehouse;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, LocalDate createDate, LocalDate expiryDate, double price) {
        super(name, createDate, expiryDate, price);
    }
}

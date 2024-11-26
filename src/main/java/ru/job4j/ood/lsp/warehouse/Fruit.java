package ru.job4j.ood.lsp.warehouse;

import java.time.LocalDate;

public class Fruit extends Food {
    public Fruit(String name, LocalDate createDate, LocalDate expiryDate, double price) {
        super(name, createDate, expiryDate, price);
    }
}

package ru.job4j.ood.lsp.warehouse;

import java.time.LocalDate;

public class Food {
    private final String name;
    private final LocalDate expiryDate;
    private final LocalDate createDate;
    private double price;
    private final double discount = 0.20;

    public Food(String name, LocalDate createDate, LocalDate expiryDate, double price) {
        this.price = price;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    /**
     * Вычисляет процент истечения срока годности продукта.
     * Метод определяет, сколько времени прошло с момента создания продукта
     * относительно полного срока годности. Процент рассчитывается как
     * отношение прошедших дней к общему сроку годности.
     *
     * @return процент истечения срока годности, где 0 означает, что
     * продукт только что создан, а 100 — что срок годности полностью истек.
     */
    public double getPercentOfExpiry() {
        long totalLife = expiryDate.toEpochDay() - createDate.toEpochDay();
        long daysPassed = LocalDate.now().toEpochDay() - createDate.toEpochDay();
        return (double) daysPassed / totalLife * 100;
    }
}

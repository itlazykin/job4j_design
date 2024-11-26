package ru.job4j.ood.lsp.parking;

/**
 * Интерфейс задаёт обязательный метод park(), который определяет, можно ли припарковать транспортное средство.
 */
public interface ParkingSpot {
    boolean park(Vehicle vehicle);
}

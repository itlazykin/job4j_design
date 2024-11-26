package ru.job4j.ood.lsp.parking;

/**
 * Реализует интерфейс Vehicle и задает размеры для легкового авто.
 */
public class Car implements Vehicle {
    private int carSize;
    private static final int SIZE = 1;

    public Car() {
        carSize = SIZE;
    }

    @Override
    public int getVehicleSize() {
        return carSize;
    }
}

package ru.job4j.ood.lsp.parking;

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

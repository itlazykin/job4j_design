package ru.job4j.ood.lsp.parking;

/**
 * Реализует интерфейс Vehicle и задает размеры для грузовика.
 */
public class Truck implements Vehicle {
    private int truckSize;

    public Truck(int truckSize) {
        if (!validate(truckSize)) {
            throw new IllegalArgumentException("Truck size must be greater than 1!");
        }
        this.truckSize = truckSize;
    }

    @Override
    public int getVehicleSize() {
        return truckSize;
    }

    private boolean validate(int size) {
        return size > 1;
    }
}

package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingSpot {
    private int carPlace;
    private int truckPlace;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Parking(int carPlace, int truckPlace) {
        this.carPlace = carPlace;
        this.truckPlace = truckPlace;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }
}

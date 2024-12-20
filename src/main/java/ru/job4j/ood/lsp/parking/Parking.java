package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует логику парковки. Есть два типа мест: для легковых машин (carPlace) и для грузовиков (truckPlace).
 * Если не хватает места для грузовика, его можно поставить на несколько мест для легковых машин.
 */
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
        int vehicleSize = vehicle.getVehicleSize();
        boolean parked = false;
        if (vehicleSize == 1 && carPlace > 0) {
            carPlace--;
            vehicles.add(vehicle);
            parked = true;
        } else if (vehicleSize > 1 && truckPlace > 0) {
            truckPlace--;
            vehicles.add(vehicle);
            parked = true;
        } else if (vehicleSize > 1 && vehicleSize <= carPlace) {
            carPlace -= vehicleSize;
            vehicles.add(vehicle);
            parked = true;
        }
        return parked;
    }
}

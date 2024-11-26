package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class ParkingTest {
    @Test
    public void whenParkedCarAndTruck() {
        ParkingSpot parking = new Parking(1, 1);
        Vehicle car = new Car();
        Truck truck = new Truck(2);
        assertTrue(parking.park(car));
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenNoPlacesForTruck() {
        ParkingSpot parking = new Parking(1, 0);
        Truck truck = new Truck(2);
        assertFalse(parking.park(truck));
    }

    @Test
    public void whenEnoughPlacesOnCarPlaceForCarAndTruck() {
        ParkingSpot parking = new Parking(3, 0);
        Car car = new Car();
        Vehicle truck = new Truck(2);
        assertTrue(parking.park(car));
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenNoPlaceForCar() {
        ParkingSpot parking = new Parking(0, 0);
        Vehicle car = new Car();
        assertFalse(parking.park(car));
    }

    @Test
    public void whenNoCarPlacesEvenWithOneTruckPlaceThanCarIsNotParked() {
        ParkingSpot parking = new Parking(0, 1);
        Vehicle car = new Car();
        assertFalse(parking.park(car));
    }
}
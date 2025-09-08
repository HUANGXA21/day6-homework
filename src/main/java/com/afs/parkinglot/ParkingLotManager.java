package com.afs.parkinglot;

import java.util.List;

public class ParkingLotManager {
    private final List<ParkingLot> parkingLots;

    public ParkingLotManager(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket helpParkCar(Car car) {
        for (ParkingLot lot : parkingLots) {
            try {
                return lot.parking(car);
            } catch (IllegalStateException e) {
                continue;
            }
        }
        throw new IllegalStateException("No available position in all parking lots.");
    }

    public Car helpFetchCar(Ticket ticket) {
        for (ParkingLot lot : parkingLots) {
            try {
                return lot.fetch(ticket);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        throw new IllegalArgumentException("Unrecognized parking ticket.");
    }

}

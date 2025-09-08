package com.afs.parkinglot;


public class ParkingBoy {
    private final ParkingLot parkingLot;


    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    public Ticket helpParkCar(Car car) {
        return parkingLot.parking(car);
    }

/*    public Car helpFetchCar(Ticket ticket) {
        return parkingLot.fetch(ticket);
    }*/
}
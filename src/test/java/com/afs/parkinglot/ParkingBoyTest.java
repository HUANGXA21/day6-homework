package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    public void should_return_ticket_when_parking_boy_helps_park_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("parking number 1");

        Ticket ticketResult = parkingBoy.helpParkCar(car);
        Ticket ticket = new Ticket(car, 1, parkingLot);
        assertEquals(car, ticket.car());
        assertEquals(ticketResult, ticket);
    }

    @Test
    public void should_return_car_when_parking_boy_helps_fetch_with_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("parking number 1");
        Ticket validTicket = parkingBoy.helpParkCar(car);

        Car fetchedCar = parkingBoy.helpFetchCar(validTicket);
        assertEquals(car, fetchedCar);
    }
}
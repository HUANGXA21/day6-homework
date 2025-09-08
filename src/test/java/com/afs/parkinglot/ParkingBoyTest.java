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

    @Test
    public void should_return_all_car_when_parking_boy_helps_fetch_with_two_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car("parking number 1");
        Car car2 = new Car("parking number 2");
        Ticket validTicket1 = parkingBoy.helpParkCar(car1);
        Ticket validTicket2 = parkingBoy.helpParkCar(car2);

        Car fetchedCar = parkingBoy.helpFetchCar(validTicket1);
        Car fetchedCar2 = parkingBoy.helpFetchCar(validTicket2);
        assertEquals(car1, fetchedCar);
        assertEquals(car2, fetchedCar2);
    }

}
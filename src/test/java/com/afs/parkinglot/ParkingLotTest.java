package com.afs.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_ticket_when_parking() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("parking number 1");
        Ticket ticket = new Ticket(car, 1, parkingLot);
        Ticket ticketResult = parkingLot.parking(car);
        assertEquals(ticketResult, ticket);
    }

    @Test
    public void should_return_car_when_given_parking_lot_and_one_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("parking number 1");
        Ticket ticketResult = parkingLot.parking(car);
        Car carResult = parkingLot.fetch(ticketResult);
        assertEquals(carResult, car);
    }

    @Test
    public void should_return_allCar_when_given_parking_lot_and_two_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car("parking number 1");
        Car car2 = new Car("parking number 2");
        parkingLot.parking(car1);
        parkingLot.parking(car2);
        Ticket ticket1 = new Ticket(new Car("parking number 1"), 1, parkingLot);
        Ticket ticket2 = new Ticket(new Car("parking number 2"), 2, parkingLot);
        Car carResult1 = parkingLot.fetch(ticket1);
        Car carResult2 = parkingLot.fetch(ticket2);
        assertEquals(carResult1, car1);
        assertEquals(carResult2, car2);
    }

    @Test
    public void should_return_message_when_given_parking_lot_and_one_wrong_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("parking number 1");
        parkingLot.parking(car);
        Ticket ticket = new Ticket(new Car("parking number 3"), 1, parkingLot);
       /*    Car carResult = parkingLot.fetch(ticket);
        assertNull(carResult,car);*/
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> parkingLot.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_message_when_given_parking_lot_and_one_used_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("parking number 1");
        parkingLot.parking(car);
        Ticket ticketResult = parkingLot.parking(car);
        parkingLot.fetch(ticketResult);
    /*    Car carResult = parkingLot.fetch(ticketResult);
        assertNull(carResult,car);*/
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> parkingLot.fetch(ticketResult));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_message_when_given_full_parking_lot_and_parking() {
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car("parking number 1");
    /*    Ticket ticket = parkingLot.parking(car);
        assertNull(ticket);*/
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> parkingLot.parking(car));
        assertEquals("No available position.", exception.getMessage());
    }

}

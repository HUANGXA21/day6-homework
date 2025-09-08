package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotManagerTest {

    @Test
    public void should_park_in_first_lot_when_first_has_space() {
        ParkingLot lot1 = new ParkingLot(1);
        ParkingLot lot2 = new ParkingLot(1);
        ParkingLotManager manager = new ParkingLotManager(Arrays.asList(lot1, lot2));
        Car car = new Car("car1");

        Ticket ticket = manager.helpParkCar(car);
        assertEquals(lot1, ticket.parkingLot());
    }

    @Test
    public void should_park_in_second_lot_when_first_is_full() {
        ParkingLot lot1 = new ParkingLot(0);
        ParkingLot lot2 = new ParkingLot(1);
        ParkingLotManager manager = new ParkingLotManager(Arrays.asList(lot1, lot2));
        Car car = new Car("car2");

        Ticket ticket = manager.helpParkCar(car);
        assertEquals(lot2, ticket.parkingLot());
    }

    @Test
    public void should_throw_exception_when_all_lots_are_full() {
        ParkingLot lot1 = new ParkingLot(0);
        ParkingLot lot2 = new ParkingLot(0);
        ParkingLotManager manager = new ParkingLotManager(Arrays.asList(lot1, lot2));
        Car car = new Car("car3");

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> manager.helpParkCar(car)
        );
        assertEquals("No available position in all parking lots.", exception.getMessage());
    }

    @Test
    public void should_fetch_from_lot() {
        ParkingLot lot1 = new ParkingLot(1);
        ParkingLot lot2 = new ParkingLot(1);
        ParkingLotManager manager = new ParkingLotManager(Arrays.asList(lot1, lot2));
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        manager.helpParkCar(car1);
        Ticket ticket = manager.helpParkCar(car2);
        Car carResult = manager.helpFetchCar(ticket);
        assertEquals(car2, carResult);
    }

    @Test
    public void should_throw_exception_with_invalid_ticket() {
        ParkingLot lot1 = new ParkingLot(1);
        ParkingLot lot2 = new ParkingLot(1);
        ParkingLotManager manager = new ParkingLotManager(Arrays.asList(lot1, lot2));
        manager.helpParkCar(new Car("car1"));
        Ticket invalidTicket = new Ticket(new Car("invalid"), 1, lot1);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manager.helpFetchCar(invalidTicket)
        );
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

}

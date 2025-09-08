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
}

package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParkingLot {
    private Integer capacity;
    private static final Integer CAPACITY = 10;
    private Map<Ticket, Car> ticketCars = new HashMap<Ticket, Car>();

    public ParkingLot() {
        this.capacity = CAPACITY;
    }

    ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    public Ticket parking(Car car) {
        return IntStream.rangeClosed(1, capacity).boxed()
                .filter(position -> ticketCars
                        .keySet()
                        .stream()
                        .noneMatch(ticket -> ticket.position() == position))
                .findFirst()
                .map(position -> {
                    Ticket ticket = new Ticket(car, position, this);
                    ticketCars.put(ticket, car);
                    return ticket;
                }).orElseThrow(() -> new IllegalStateException("No available position."));
    }

    public Car fetch(Ticket ticket) {
        if (!ticketCars.containsKey(ticket)) {
            throw new IllegalArgumentException("Unrecognized parking ticket.");
        }
        return ticketCars.remove(ticket);
    }
}

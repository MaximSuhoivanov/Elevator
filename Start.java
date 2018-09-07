package org.oracle.Elevator;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        int minFloor = 1;
        int maxFloor = 12;
        Passenger passenger = new Passenger(minFloor, maxFloor);
        passenger.callElevator();
    }
}

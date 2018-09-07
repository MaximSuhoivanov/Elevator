package org.oracle.Elevator;

public class Elevator {

    protected void openDoor() {
        System.out.println("The doors are open");
    }

    protected void closeDoor() {
        System.out.println("The doors are closed");
    }

    protected int elevatorGoUp(int currentElevatorFloor, int requiredFloor) {
        System.out.println(currentElevatorFloor);
        while (currentElevatorFloor < requiredFloor) {
            currentElevatorFloor++;
            System.out.println(currentElevatorFloor);

        }
        return currentElevatorFloor;
    }

    protected int elevatorGoDown(int currentElevatorFloor, int requiredFloor) {
        System.out.println(currentElevatorFloor);
        while (currentElevatorFloor > requiredFloor) {
            currentElevatorFloor--;
            System.out.println(currentElevatorFloor);
        }
        return currentElevatorFloor;
    }
}

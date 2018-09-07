package org.oracle.Elevator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Passenger {
    private final int MIN_FLOOR;
    private final int MAX_FLOOR;
    private int currentElevatorFloor;
    private int requiredFloor;
    Elevator elevator;
    BufferedReader br;

    public Passenger(int MIN_FLOOR, int MAX_FLOOR) {
        this.MIN_FLOOR = MIN_FLOOR;
        this.MAX_FLOOR = MAX_FLOOR;
    }

    {
        setCurrentElevatorFloor(1);
        setRequiredFloor(0);
        this.elevator = new Elevator();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void callElevator() throws IOException {
        while (getRequiredFloor() < MIN_FLOOR || getRequiredFloor() > MAX_FLOOR) {
            System.out.print("Input your current floor: ");
            setRequiredFloor(Integer.parseInt(br.readLine()));
        }
        if (getRequiredFloor() < getCurrentElevatorFloor()) {
            setCurrentElevatorFloor(elevator.elevatorGoDown(getCurrentElevatorFloor(), getRequiredFloor()));
        } else if (getRequiredFloor() > getCurrentElevatorFloor()) {
            setCurrentElevatorFloor(elevator.elevatorGoUp(getCurrentElevatorFloor(), getRequiredFloor()));
        } else {
            elevator.openDoor();
        }
        choiceOfFloor();
    }

    private void choiceOfFloor() throws IOException {
        do {
            System.out.print("Select the required floor: ");
            setRequiredFloor(Integer.parseInt(br.readLine()));
        } while (getRequiredFloor() < MIN_FLOOR || getRequiredFloor() > MAX_FLOOR ||
                getRequiredFloor() == getCurrentElevatorFloor());
        if (getRequiredFloor() < getCurrentElevatorFloor()) {
            elevator.closeDoor();
            setCurrentElevatorFloor(elevator.elevatorGoDown(getCurrentElevatorFloor(), getRequiredFloor()));
            elevator.openDoor();
        } else if (getRequiredFloor() > getCurrentElevatorFloor()){
            elevator.closeDoor();
            setCurrentElevatorFloor(elevator.elevatorGoUp(getCurrentElevatorFloor(), getRequiredFloor()));
            elevator.openDoor();
        }
        choiceOfAction();
    }

    private void choiceOfAction() throws IOException {
        String choice;
        do {
            System.out.println("Go out - 'o', Select floor - 's'");
            choice = br.readLine();
        } while (!choice.equals("o") && !choice.equals("s"));
        if (choice.equals("s")) {
            choiceOfFloor();
        }
    }

    public int getCurrentElevatorFloor() {
        return currentElevatorFloor;
    }

    public void setCurrentElevatorFloor(int currentElevatorFloor) {
        this.currentElevatorFloor = currentElevatorFloor;
    }

    public int getRequiredFloor() {
        return requiredFloor;
    }

    public void setRequiredFloor(int requiredFloor) {
        this.requiredFloor = requiredFloor;
    }
}

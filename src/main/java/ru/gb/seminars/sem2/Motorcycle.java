package ru.gb.seminars.sem2;

public class Motorcycle extends Vehicle {

    public Motorcycle(String company, String model, int year) {
        this.company = company;
        this.model = model;
        this.yearRelease = year;
        this.setNumWheels(2);
        this.setSpeed(0);
    }

    public void testDrive() {
        this.setSpeed(75);
    }

    public void park() {
        this.setSpeed(0);
    }

    public String toString() {
        return "This motorcycle is a " + yearRelease + " " + company + " " + model + ";";
    }
}
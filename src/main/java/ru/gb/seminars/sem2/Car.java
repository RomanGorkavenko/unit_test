package ru.gb.seminars.sem2;

public class Car extends Vehicle {
    public Car(String company, String model, int year) {
        this.company = company;
        this.model = model;
        this.yearRelease = year;
        this.numWheels = 4;
        this.speed = 0;
    }

    public void testDrive() {
        this.speed = 60;
    }

    public void park() {
        this.speed = 0;
    }

    public String toString() {
        return "This car is a " + yearRelease + " " + company + " " + model + ";";
    }
}
package ru.gb.seminars.sem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("FORD", "Focus", 2006);
        motorcycle = new Motorcycle("Jawa", "RVM 500", 2020);
    }

    /**
     * Проверка того, что экземпляр объекта Car также является
     * экземпляром транспортного средства; (instanceof)
     */
    @Test
    void car_instanceofVehicle_successfully(){
        assertInstanceOf(Vehicle.class, car);
    }

    /**
     * Проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    void car_numberOfWheelsIs4_successfully() {
        int expected = 4;
        int actual = car.getNumWheels();
        assertEquals(expected, actual);
    }

    /**
     * Проверка того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    void motorcycle_numberOfWheelsIs2_successfully() {
        int expected = 2;
        int actual = motorcycle.getNumWheels();
        assertEquals(expected, actual);
    }

    /**
     * Проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     */
    @Test
    void testDrive_speedOfTheCarIs60_successfully() {
        int expected = 60;

        car.testDrive();

        int actual = car.getSpeed();

        assertEquals(expected, actual);
    }

    /**
     * Проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
     */
    @Test
    void testDrive_speedOfTheMotorcycleIs75_successfully() {
        int expected = 75;

        motorcycle.testDrive();

        int actual = motorcycle.getSpeed();

        assertEquals(expected, actual);
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта)
     * машина останавливается (speed = 0)
     */
    @Test
    void park_speedOfTheCarIs0_successfully() {
        int expected = 0;

        car.testDrive();
        car.park();

        int actual = car.getSpeed();

        assertEquals(expected, actual);
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта)
     * мотоцикл останавливается (speed = 0)
     */
    @Test
    void park_speedOfTheMotorcycleIs0_successfully() {
        int expected = 0;

        motorcycle.testDrive();
        motorcycle.park();

        int actual = motorcycle.getSpeed();

        assertEquals(expected, actual);
    }
}
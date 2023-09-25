package ru.gb.seminars.sem3.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.ConstructorParameters;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {

    private MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @Test
    void evenOddNumber_numberIsEven_true() {
        boolean expected = true;

        boolean actual = mainHW.evenOddNumber(2);

        assertEquals(expected, actual);
    }

    @Test
    void evenOddNumber_numberIsNotEven_false() {
        boolean expected = false;

        boolean actual = mainHW.evenOddNumber(3);

        assertEquals(expected, actual);
    }

    @Test
    void numberInInterval_numberFallsInTheRangeFrom25To100_true() {
        boolean expected = true;

        boolean actual = mainHW.evenOddNumber(26);

        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @ValueSource(ints = {10, 15, 24, 101, 110, 200})
    void numberInInterval_numberDoesNotFallInTheRangeFrom25To100_false(int i) {
        boolean expected = false;

        boolean actual = mainHW.numberInInterval(i);

        assertEquals(expected, actual);
    }


}
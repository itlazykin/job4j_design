package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoolTest {
    @Test
    void whenGetFizzBuzzIsOk() {
        assertEquals("1", Fool.getFizzBuzzValue(1));
        assertEquals("Fizz", Fool.getFizzBuzzValue(3));
        assertEquals("Buzz", Fool.getFizzBuzzValue(5));
        assertEquals("FizzBuzz", Fool.getFizzBuzzValue(15));
        assertEquals("Fizz", Fool.getFizzBuzzValue(9));
        assertEquals("Buzz", Fool.getFizzBuzzValue(10));
        assertEquals("FizzBuzz", Fool.getFizzBuzzValue(30));
    }

    @Test
    void whenCheckUserAnswerTrue() {
        assertTrue(Fool.checkUserAnswer(1, "1"));
        assertTrue(Fool.checkUserAnswer(3, "Fizz"));
        assertTrue(Fool.checkUserAnswer(5, "Buzz"));
        assertTrue(Fool.checkUserAnswer(15, "FizzBuzz"));
        assertTrue(Fool.checkUserAnswer(9, "Fizz"));
        assertTrue(Fool.checkUserAnswer(10, "Buzz"));
    }

    @Test
    void whenCheckUserAnswerFalse() {
        assertFalse(Fool.checkUserAnswer(1, "Fizz"));
        assertFalse(Fool.checkUserAnswer(3, "Buzz"));
        assertFalse(Fool.checkUserAnswer(5, "Fizz"));
        assertFalse(Fool.checkUserAnswer(15, "Buzz"));
        assertFalse(Fool.checkUserAnswer(9, "9"));
        assertFalse(Fool.checkUserAnswer(10, "FizzBuzz"));
    }
}
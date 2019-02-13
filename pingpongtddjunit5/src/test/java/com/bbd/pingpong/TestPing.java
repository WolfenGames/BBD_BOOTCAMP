package com.bbd.pingpong;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPing {
    @Test
    public void whenTestPassedIReturn1() {
        assertEquals(1, RomanConverter.convert("I"));
    }

    @Test
    public void whenTestPassedIVReturn4() {
        assertEquals(4, RomanConverter.convert("IV"));
    }

    @Test
    public void whenTestPasseXIReturn10() {
        assertEquals(10, RomanConverter.convert("X"));
    }


    @Test
    public void whenTestPassedCReturn100() {
        assertEquals(100, RomanConverter.convert("C"));
    }

    @Test
    public void whenTestPassedMReturn1000() {
        assertEquals(1000, RomanConverter.convert("M"));
    }


    @Test
    public void whenTestPassedMMCDLXIIShouldReturn2463() {
        assertEquals(2463, RomanConverter.convert("MMCDLXIII"));
    }

    @Test
    public void whenTestPassedANullStringReturnNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> RomanConverter.convert(null));
        assertEquals("Reference String can't be null", ex.getMessage());
    }

    @Test
    public void whenTestPassedEmptyStringReturn0() {
        assertEquals(0, RomanConverter.convert(""));
    }

    @Test
    public void whenTestPassedRoman1MillReturn1Million() {
        String million = "";
        for (int i = 0; i < 1000; i++) {
            million += "M";
        }
        assertEquals(1000000, RomanConverter.convert(million));
    }

    @Test
    public void whenTestPassedInvalidShitReturnIllegalArgumentException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> RomanConverter.convert("ABCD"));
        assertEquals("Invalid characters in input", ex.getMessage());
    }

    @Test
    public void whenTestPassedHUGEnumberReturnITSVALUE() {
        assertEquals(99999, RomanConverter.convert("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMCMXCIX"));
    }

    @Test
    public void whenPassedMReturn1000() {
        assertEquals(1000, RomanConverter.convert("M"));
    }

    @ParameterizedTest
    @CsvSource({"i, 1", "iv, 4", "m,1000"})
    public void testWithCsvSource(String roman, int expected) {
        assertEquals(expected, RomanConverter.convert(roman));
    }

    @ParameterizedTest
    @CsvSource({"ild, Invalid Character Order", "mim, Invalid Character Order", "IXIX, Invalid Character Order"})
    public void testWithCsvSource(String roman, String expectedErrorMessage) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> RomanConverter.convert(roman));
        assertEquals(expectedErrorMessage, ex.getMessage());
    }

}

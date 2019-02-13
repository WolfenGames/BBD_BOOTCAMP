package za.co.bbd.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplierTest {

    @Test
    public void multiply() {
        Multiplier times = new Multiplier();
        assertEquals("Should be equal", times.multiply(3, 3), 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyNegativeNumbers() {
        Multiplier times = new Multiplier();
        times.multiply(-1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyNegativeNumbersTheSecond() {
        Multiplier times = new Multiplier();
        times.multiply(1, -1);
    }

    @Test
    public void whenMultiplyingEvenNumbersThenReturnZero() {
        Multiplier times = new Multiplier();
        assertEquals(0, times.multiply(4,2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMultiplyingOnlyAcceptLessThan100ElseReturnNegativeOne(){
        Multiplier times = new Multiplier();
        times.multiply(100, 1);
    }
}
package org.springboot;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator;
    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }
    @Test
    public void inputWithEmptyString(){
        assertEquals(0,stringCalculator.add(""));
    }
    @Test
    public void inputWithOnlyOneNumberReturnsOneNumber(){
        assertEquals(1,stringCalculator.add("1"));
        assertEquals(100,stringCalculator.add("100"));
    }
    @Test
    public void inputWithTwoNumberReturnsAddedNumber(){
        assertEquals(3,stringCalculator.add("1,2"));
    }
    @Test
    public void inputWithMultipleNumbersReturnsTheirSum(){
        assertEquals(6,stringCalculator.add("1,2,3"));
    }
}

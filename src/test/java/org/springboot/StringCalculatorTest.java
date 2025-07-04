package org.springboot;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Unit test for simple App.
 */
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
}

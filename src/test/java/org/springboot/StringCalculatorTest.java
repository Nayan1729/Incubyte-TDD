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
    public void inputWithUnkownNumbersReturnsTheirSum(){
        assertEquals(6,stringCalculator.add("1,2,3"));
        assertEquals(21,stringCalculator.add("1,2,3,4,5,6"));
        assertEquals(0,stringCalculator.add(""));
    }
    @Test
    public void inputWithNewLinesBetweenNumbersReturnsTheirSum(){
        assertEquals(6,stringCalculator.add("1,2\n3"));
    }

    @Test
    public void inputWithUserDefinedDelimiters(){
        assertEquals(6,stringCalculator.add("//;\n1,2;3"));
    }

    @Test
    public void inputWithNegativeNumber(){
        assertThrows(Exception.class,()->stringCalculator.add("//;\n1,-2;3"));
    }
    @Test
    public void inputWithMultipleNegativeNumbers(){
        Exception exception = assertThrows(Exception.class,()->stringCalculator.add("//;\n1,-2;-3"));
        assertEquals(exception.getMessage(),"negatives not allowed [-2, -3]");
    }

    @Test
    public void testToCountNumberOfTimesAddWasInvoked(){
        assertThrows(IllegalArgumentException.class,()->stringCalculator.add("//;\n1,-2;3"));
        assertEquals(3,stringCalculator.add("1,2"));
        assertEquals(2,stringCalculator.getCalledCount());
    }
    @Test
    public void testThatIgnoresNumbersGreaterThanThousand(){
        assertEquals(3,stringCalculator.add("1,1001,2"));
    }
    @Test
    public void testThatTakesASingleDelimiterOfAnyLength(){
        assertEquals(6,stringCalculator.add("//[***]\n1***2,3"));
    }
    @Test
    public void  testThatTakesMultipleDelimitersOfSingleLength(){
        assertEquals(6,stringCalculator.add("//[*][%]\n1*2%3"));
    }
    @Test
    public void testThatTakesMultipleDelimitersOfMultipleLengths(){
        assertEquals(6,stringCalculator.add("//[**][%%]\\n1**2%%3"));
    }
}

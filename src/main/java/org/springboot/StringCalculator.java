package org.springboot;


import java.util.Arrays;

public class StringCalculator
{
    public int sumOfNumbers(String [] numbers){
        int sumOfNumbers = 0;
        for(String num : numbers){
            sumOfNumbers += Integer.parseInt(num);
        }
        return sumOfNumbers;
    }
    public String processDelimiter(char newDelimiter,String mainDelimiter ){
        int closingBracketIndex = mainDelimiter.indexOf(']');
        mainDelimiter = mainDelimiter.substring(0, closingBracketIndex) + newDelimiter +']';
        return mainDelimiter;
    }
    public int add(String stringInputNums){
        if(stringInputNums.isEmpty()){ // To handle empty string as an input
            return 0;
        }
        String DELIMITER = "[,\\n]"; // DELIMITER as Regex
        if(stringInputNums.startsWith("//")){
            stringInputNums = stringInputNums.substring(2); // Remove // from input string
            char newDelimiter = stringInputNums.charAt(0);
            stringInputNums = stringInputNums.substring(2); // Remove ;\n
            DELIMITER = processDelimiter(newDelimiter , DELIMITER);
        }
        String numbers[] = stringInputNums.split(DELIMITER); // Split the numbers with DELIMITER as a regex
        int sumOfNums = sumOfNumbers(numbers);
        return sumOfNums;
    }
}

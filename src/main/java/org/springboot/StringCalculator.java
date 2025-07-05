package org.springboot;


import java.util.ArrayList;

public class StringCalculator
{
    private  int count = 0;
    public int sumOfNumbers(String [] numbers){
        int sumOfNumbers = 0;
        ArrayList<Integer> negativateNumbers = new ArrayList<>();
        for(String num : numbers){
            int parsedNum = Integer.parseInt(num);
            if(parsedNum < 0){
                negativateNumbers.add(parsedNum);
            }
            sumOfNumbers += parsedNum;
        }
        if(negativateNumbers.size() > 0){
            throw new IllegalArgumentException("negatives not allowed "+negativateNumbers);
        }
        return sumOfNumbers;
    }
    public String processDelimiter(char newDelimiter,String mainDelimiter ){
        int closingBracketIndex = mainDelimiter.indexOf(']');
        mainDelimiter = mainDelimiter.substring(0, closingBracketIndex) + newDelimiter +']';
        return mainDelimiter;
    }
    public int add(String stringInputNums) {
        count++;
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

    public int getCalledCount() {
        return this.count;
    }
}

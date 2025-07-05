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
            }else if(parsedNum > 1000){
                continue;
            }
            sumOfNumbers += parsedNum;
        }
        if(negativateNumbers.size() > 0){
            throw new IllegalArgumentException("negatives not allowed "+negativateNumbers);
        }
        return sumOfNumbers;
    }
    public String processDelimiter(String newDelimiter,String mainDelimiter ){
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
            String newDelimiter = String.valueOf(stringInputNums.charAt(0));
            if(newDelimiter.equals("[")){
                System.out.println("Hello");
                int delimiterEndIndex = stringInputNums.indexOf(']');
                String multipleLengthDelimiter = stringInputNums.substring(1,delimiterEndIndex);
                System.out.println(multipleLengthDelimiter);
                multipleLengthDelimiter = multipleLengthDelimiter.replaceAll("([\\\\*+\\[\\](){}|.^$?])", "\\\\$1");
                StringBuilder updatedDelimiters = new StringBuilder();

                updatedDelimiters.append(",|\\n");
                updatedDelimiters.append("|").append(multipleLengthDelimiter);
                DELIMITER = updatedDelimiters.toString();
                //Shorten the delimiter
                stringInputNums = stringInputNums.substring(stringInputNums.indexOf("\n")+1);
            }else{
                stringInputNums = stringInputNums.substring(2); // Remove ;\n
                DELIMITER = processDelimiter(newDelimiter , DELIMITER);
            }
        }

        String numbers[] = stringInputNums.split(DELIMITER); // Split the numbers with DELIMITER as a regex

        int sumOfNums = sumOfNumbers(numbers);
        return sumOfNums;
    }

    public int getCalledCount() {
        return this.count;
    }
}

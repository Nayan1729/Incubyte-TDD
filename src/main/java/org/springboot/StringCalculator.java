package org.springboot;

import java.util.ArrayList;

public class StringCalculator
{
    private  int count = 0;
    public int sumOfNumbers(String [] numbers){
        int sumOfNumbers = 0;
        ArrayList<Integer> negativateNumbers = new ArrayList<>();
        ArrayList<String> delimiters = new ArrayList<>();
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
        StringBuilder updatedDelimiters;
        String delimiterSection = "";
        if(stringInputNums.startsWith("//")){
            stringInputNums = stringInputNums.substring(2); // Remove // from input string
            int newlineIndex = stringInputNums.indexOf("\n");
           delimiterSection = stringInputNums.substring(0, newlineIndex);
            if(delimiterSection.charAt(0) == '['){
                delimiterSection = delimiterSection.substring(1, delimiterSection.length()-1);
                   String [] delimiters = delimiterSection.split("]\\[");
                updatedDelimiters = new StringBuilder();
                updatedDelimiters.append(",|\\n");
                for(String delimiter : delimiters){
                       delimiter = delimiter.replaceAll("([\\\\*+\\[\\](){}|.^$?])", "\\\\$1");
                       updatedDelimiters.append("|").append(delimiter);
                   }
                    DELIMITER = updatedDelimiters.toString();
                System.out.println(DELIMITER);
                    //Shorten the delimiter
                    stringInputNums = stringInputNums.substring(stringInputNums.indexOf("\n")+1);
                }
            else{
                delimiterSection = String.valueOf(stringInputNums.charAt(0));
                stringInputNums = stringInputNums.substring(2); // Remove ;\n
                DELIMITER = processDelimiter(delimiterSection, DELIMITER);
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
package org.springboot;


public class StringCalculator
{
    public int add(String stringInputNums){
        if(stringInputNums.isEmpty()){ // To handle empty string as an input
            return 0;
        }
        String DELIMITER = "[,\\n]"; // DELIMITER as Regex
        String nums[] = stringInputNums.split(DELIMITER); // Split the numbers with DELIMITER as a regex
        int sum = 0;
        for(String num : nums){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}

package org.springboot;


public class StringCalculator
{
    public int add(String stringInputNums){
        if(stringInputNums.isEmpty()){ // To handle empty string as an input
            return 0;
        }
        String nums[] = stringInputNums.split(","); // Split the numbers with delimiter as ','
        int sum = 0;
        for(String num : nums){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}

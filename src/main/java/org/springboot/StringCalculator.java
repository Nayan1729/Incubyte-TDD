package org.springboot;


public class StringCalculator
{
    public int add(String stringInputNums){
        if(stringInputNums.isEmpty()){
            return 0;
        }
        String nums[] = stringInputNums.split(",");
        int sum = 0;
        if(nums.length == 1){
            sum = Integer.parseInt(nums[0]);
        }
        if(nums.length == 2){
            sum = Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
        }
        return sum;
    }
}

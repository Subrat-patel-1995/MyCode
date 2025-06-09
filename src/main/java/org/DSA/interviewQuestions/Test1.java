package org.DSA.interviewQuestions;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        String s=null;
        char[] charArray = s.toCharArray();



        List<Integer> nums= Arrays.asList(5,4,4,6,1,2);

        Optional<Integer> second = nums.stream().distinct().sorted().skip(1).findFirst();
        System.out.println((second.get()));

        System.out.println(findSecond(nums));




    }
    public static int findSecond(List<Integer> nums){
        int min=Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        for( Integer num:nums){
            if(num<min){
                secondMin=min;
                min=num;


            }else {
                if (num < secondMin) {
                    secondMin = num;
                }
            }
        }
        return secondMin;
    }

}

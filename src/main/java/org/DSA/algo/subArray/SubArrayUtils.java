package org.DSA.algo.subArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayUtils {
    public static void main(String[] args) {
        List input=Arrays.asList(1,-2,3);
        System.out.println(getAllPossibleSubArray(input));
        System.out.println(getMaxSumAmongAllPossibleSubArray(input));
        System.out.println(getMaxSumAmongAllPossibleSubArrayUsingKedanesAlgo(input));
    }
    //brute force method to get All SubArray
    private static List<List<Integer>> getAllPossibleSubArray(List<Integer> num){
        int length= num.size();
        List<List<Integer>> resultList=new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                List<Integer> subArray=new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArray.add(num.get(k));
                }
                resultList.add(subArray);
            }
        }
        return resultList;
    }


    //get Max Sum where List May Have contains -ve number also
    private static int getMaxSumAmongAllPossibleSubArray(List<Integer> num){
        int maxSum=Integer.MIN_VALUE;
        for (int i = 0; i < num.size(); i++) {
            for (int j = i; j < num.size(); j++) {
                int currentCount=0;
                for (int k = i; k <=j ; k++) {
                    currentCount+=num.get(k);
                }
                maxSum=Math.max(maxSum,currentCount);
            }
        }
        return maxSum;
    }

    //Now Kedanes Algo to get Max count;
    private static int getMaxSumAmongAllPossibleSubArrayUsingKedanesAlgo(List<Integer> num){
        int maxSum=Integer.MIN_VALUE;
        int prefixSum=num.get(0);
        for (int i = 1; i < num.size(); i++) {
            prefixSum=Math.max(num.get(i),prefixSum+num.get(i));
            maxSum=Math.max(maxSum,prefixSum);
        }
        return maxSum;
    }
}

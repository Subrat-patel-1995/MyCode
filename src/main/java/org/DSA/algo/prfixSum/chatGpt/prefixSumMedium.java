package org.DSA.algo.prfixSum.chatGpt;

import org.test.InterviewTest;

import java.util.*;

public class prefixSumMedium {
    public static void main(String[] args) {
        getSubArray(new int[]{1,2,3},3);
    }
    /**
     * Problem: Subarray Sum Equals K
     * Description:
     * Given an array of integers nums and an integer k, find the number of subarrays whose sum equals k.
     *
     * Example:
     * Input:
     * nums = [1, 2, 3], k = 3
     * Output:
     * 2
     * Explanation: The subarrays [1, 2] and [3] both sum to 3.
     */

    public static int getSubArray(int[] nums,int target){
        int prefixSum=0;
        int count=0;
        Map<Integer, Integer> checkMap=new HashMap<>();
        checkMap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum+=nums[i];
            if(checkMap.containsKey(prefixSum-target)){
              count+=checkMap.get(prefixSum-target);
            }
            checkMap.put(prefixSum,checkMap.getOrDefault(prefixSum,0)+1);
        }
        System.out.println(count);
        return count;
    }
    /**
     * Find Equilibrium Index
     * Problem:
     * An index is called an equilibrium index if the sum of elements on its left is equal to the sum of elements on its right. Write a function to find all equilibrium indices in an array.
     *
     * Example:
     * Input: nums = {-7, 1, 5, 2, -4, 3, 0}
     * Output: [3, 6]
     * Explanation: At index 3, left sum = -1 and right sum = -1.
     */
    public static List<Integer> findEquilibriumIndices(int[] nums){

            List<Integer> result = new ArrayList<>();
            int totalSum = 0;
            int leftSum = 0;

            // Calculate the total sum of the array
            for (int num : nums) {
                totalSum += num;
            }

            // Iterate through the array and check for equilibrium indices
            for (int i = 0; i < nums.length; i++) {
                // Check if left sum equals right sum
                if (leftSum == totalSum - leftSum - nums[i]) {
                    result.add(i);
                }
                // Update left sum
                leftSum += nums[i];
            }

            return result;
    }
}

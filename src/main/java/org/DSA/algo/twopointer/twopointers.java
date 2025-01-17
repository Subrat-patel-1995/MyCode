package org.DSA.algo.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twopointers {
    public static void main(String[] args) {
       int array[]=new int[]{2,3,4};
        System.out.println(Arrays.toString(twoSum(array, 6)));
    }
    //167
    public  static int[] twoSum1(int[] numbers, int target) {
        Map map=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{(int)map.get(target-numbers[i]),i+1};
            }
            map.put(numbers[i],i+1);

        }
        return new int[0];
    }
    //using two pointer
    public  static int[] twoSum(int[] numbers, int target) {
        int sum=0;
        int right= numbers.length-1,left=0;

        while (left<right){
            int total = numbers[left] + numbers[right];

            if (total == target) {
                return new int[]{left + 1, right + 1};
            } else if (total > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}

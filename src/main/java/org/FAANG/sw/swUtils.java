package org.FAANG.sw;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class swUtils {
    public static void main(String[] args) {
        System.out.println(findMaxSubArray(new int[]{10, 5, 2, 7, 1, 10},15));
        System.out.println(findLongestSubStringWithNonRepeatingChar("dvdf"));
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));

    }
    //https://www.geeksforgeeks.org/dsa/longest-sub-array-sum-k/
//    Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
//Output: 6
    public static int findMaxSubArray(int[] arr,int k){
        int left=0;
        int right=0;
        int maxLength=Integer.MIN_VALUE;
        int sum=0;
        while(right<arr.length){
            sum+=arr[right];
            right++;
            while (sum>k){
                sum-=arr[left];
                left++;
            }
            maxLength=Math.max(maxLength,right-left);
        }
        return maxLength;
    }

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2&envId=sliding-window

    public static int findLongestSubStringWithNonRepeatingChar(String string){
        int left=0;
        int right=0,maxLength=Integer.MIN_VALUE;
        Set<Character> seen=new HashSet<>();
        while(right<string.length()){
            if(!seen.contains(string.charAt(right))){
                seen.add(string.charAt(right));
                right++;
            }else {
                while (seen.contains(string.charAt(left))){
                    seen.remove(string.charAt(left));
                    left++;
                }

            }
            maxLength=Math.max(maxLength,right-left);


        }
        return maxLength;
    }
    //https://leetcode.com/problems/max-consecutive-ones-iii/
    public static int longestOnes(int[] nums, int k) {
        int left=0,right=0;
        int maxLength=Integer.MIN_VALUE;
        int zeroCount=0;
        for(int i=0;right<nums.length;right++){
            if(nums[right]==0) zeroCount++;
            while(zeroCount>2){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;

            }
            if(zeroCount==k){
                maxLength=Math.max(maxLength,right-left);
            }
        }
        return maxLength+1;

    }
    //https://leetcode.com/problems/fruit-into-baskets/
    public int totalFruit(int[] fruits) {
        int left=0,maxLength=Integer.MIN_VALUE;
        Map<Integer,Integer> map=new HashMap();
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);

            while(map.size()>2){
                int ele=map.get(fruits[left]);
                if(ele==1){
                    map.remove(fruits[left]);
                }else{
                    ele--;
                    map.put(fruits[left],ele);
                }
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);


        }
        return maxLength;

    }

}


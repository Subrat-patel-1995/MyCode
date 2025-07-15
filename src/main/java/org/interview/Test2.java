package org.interview;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
//        You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//        Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//        You may assume that you have an infinite number of each kind of coin.

        //[1,2,3,4] 8

//        Example 1:
//
//        Input: coins = [1,2,4,5], amount = 8
//        Output: 3
//        Explanation: 11 = 5 + 5 + 1

//        Example 2:
//
//        Input: coins = [2], amount = 3
//
//        Output: -1
//
//        Example 3:
//
//        Input: coins = [1], amount = 0
//
//        Output: 0


        //1->5->6
        //2->5->1
        //1

         //
//        1 <= coins.length <= 12
//        1 <= coins[i] <= 231 - 1
//        0 <= amount <= 104

        System.out.println(longestSubString1("eceba",2));
    }
    public static int minCoin(int[] coins,int target,int[] memo){
        if(target==0) return 0;
        if(target<0) return -1;
        if(memo[target]!=-2) return memo[target];
        int minRes=Integer.MAX_VALUE;
        for (int coin:coins){
            int res=minCoin(coins,target-coin,memo);
            if(res>=0){
                minRes=Math.min(minRes,res+1);
            }
        }
        memo[target]=(minRes==Integer.MAX_VALUE)?-1:minRes;
        return  memo[target];

    }

//    Given a string s and an integer k, find the length of the longest substring that contains at most k distinct characters
//
//Input:
//String s = "eceba";
//int k = 2;
//Explanation:
//The substrings with at most 2 distinct characters are:
//
//"ec" (distinct characters: e, c)
//
//"ece" (distinct characters: e, c)
//
//"ec" (distinct characters: e, c)
//
//"eba" (distinct characters: e, b, a) → Invalid (has 3 distinct characters)
//
//The longest valid substring is "ece", which has a length of 3.

    //e
    //ec-->ece-->eceb

    //aaaa
    //1
    //

    //a-1
    //aa-1

    //dosipiyush888@gmail.com

    public static String longestSubString1(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            right++;

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            if (right - left > maxLen) {
                maxLen = right - left;
                startIndex = left;
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }




    public static String longestSubString(String string, int k) {
            int left = 0;
            int right = k;
            int maxCount = Integer.MIN_VALUE;
            int startIndex = 0;

            while (right <= string.length()) {
                String subString = string.substring(left, right);
                int noOfDistChar = findDistChar(subString);

                if (noOfDistChar <= k) {
                    if (right - left > maxCount) {
                        maxCount = right - left;
                        startIndex = left;
                    }
                    right++;
                } else {
                    left++;
                    right = left + k;
                }
            }

            return maxCount > 0 ? string.substring(startIndex, startIndex + maxCount) : "";
        }

        static int findDistChar(String string) {
            Set<Character> charSet = new HashSet<>();
            for (char c : string.toCharArray()) {
                charSet.add(c);
            }
            return charSet.size();
        }



}

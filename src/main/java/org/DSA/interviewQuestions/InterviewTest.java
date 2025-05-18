package org.DSA.interviewQuestions;

import java.util.HashMap;
import java.util.HashSet;

public class InterviewTest {

    public static void main(String[] args) {
       // Find the maximum loss you could incur by making the worst possible trade
        // in the given array of prices. Example:
        // Input: int[] prices = {100, 180, 260, 310, 40, 535, 695, 30};
        // Output: Maximum possible loss: -665

        System.out.println(findMaxLoss(new int[]{100, 180, 260, 310, 40, 535, 695, 30,10,700}));

    }

    private static int  findMaxLoss(int [] prices){
        int maxPrice=0;
        int loss=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]>maxPrice){
                maxPrice=prices[i];
            }
            if(prices[i]-maxPrice<loss){
                loss=prices[i]-maxPrice;
            }

        }
        return loss;
    }
}

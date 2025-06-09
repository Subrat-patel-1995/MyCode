package org.DSA.interviewQuestions;

import java.util.*;

public class InterviewTest {

    public static void main1(String[] args) {
       // Find the maximum loss you could incur by making the worst possible trade
        // in the given array of prices. Example:
        // Input: int[] prices = {100, 180, 260, 310, 40, 535, 695, 30};
        // Output: Maximum possible loss: -665

        System.out.println(findMaxLoss(new int[]{100, 180, 260, 310, 40, 535, 695, 30,10,700}));

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "b", "c", "d", "e"));

        for (String item : list) {
            if (item.equals("b") || item.equals("c")) {
                list.remove(item);  // This will likely throw ConcurrentModificationException
            }
        }
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        for(Map.Entry<String,String> entry:map.entrySet())

        for (String key : map.keySet()) {
            if (key.equals("b")) {
                map.remove(key);  // ❌ ConcurrentModificationException
            }
        }
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

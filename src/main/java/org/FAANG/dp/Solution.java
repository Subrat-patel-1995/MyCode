package org.FAANG.dp;

class Solution {
    int minCost(int[] height) {
        // code here
        return (minCost(height.length-1,height,new int[height.length]));
    }
    int minCost(int n,int[] height,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=0) return dp[n];
        int left=minCost(n-1,height,dp)+Math.abs(height[n]-height[n-1]);
         int right=Integer.MAX_VALUE;
         if(n>1){
            right=minCost(n-2,height,dp)+Math.abs(height[n]-height[n-2]);
         }
        dp[n]= Math.min(left,right);
         return dp[n];
    }
    
}
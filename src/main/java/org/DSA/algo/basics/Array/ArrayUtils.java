package org.DSA.algo.basics.Array;

import java.util.Arrays;

public class ArrayUtils {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf1(new int[]{1, 2, 3, 4})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Prefix product
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }

        return answer;
    }
    public static int[] productExceptSelf1(int[] nums) {
        int n=nums.length;
        int[] prefixMul=new int[n];
        prefixMul[0]=1;
        for(int i=1;i<n;i++){
            prefixMul[i]=prefixMul[i-1]*nums[i-1];
        }

        int[] suffixMul=new int[n];
        suffixMul[n-1]=1;
        for(int i=n-2;i>=0;i--){
            suffixMul[i]=suffixMul[i+1]*nums[i+1];
        }

        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=suffixMul[i]*prefixMul[i];
        }
        return result;

    }
}

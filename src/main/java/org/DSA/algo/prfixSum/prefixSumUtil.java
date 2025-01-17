package org.DSA.algo.prfixSum;

import java.util.HashMap;
import java.util.Map;

public class prefixSumUtil {
    public static void main(String[] args) {
       int[] array={2,3,-1,8,4};
        //int[] array={1,0,1,1,0,0,1,1,0};
        //System.out.println(findContigeousLength(array));
        System.out.println(findMiddleIndex(array));
    }
    //525
    public static int findContigeousLength(int[] arr){
       int maxLength=0;
       Map<Integer,Integer> map=new HashMap<>();
       int count=0;
        for (int i = 0; i < arr.length; i++) {
            count += (arr[i] == 0) ? -1 : 1;
            if(count==0){
                if(i>maxLength){
                    maxLength=i+1;
                }
            }
            if(!map.containsKey(count)){
                map.put(count,i);
            }else {
                int newLength=i-map.get(count);
                if(newLength>maxLength){
                    maxLength=newLength;
                }
            }

        }
        return maxLength;
    }
    //560
    //1191
    public static int findMiddleIndex(int[] nums) {
        int[] preSum = new int[nums.length];
        int[] postSum = new int[nums.length];
        preSum[0] = 0;
        postSum[nums.length-1] = 0;
        for (int i = 0; i < nums.length-1; i++) {
           preSum[i+1]=preSum[i]+nums[i]; 
        }
        for (int i = nums.length-1; i > 0; i--) {
            postSum[i-1]=postSum[i]+nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(preSum[i]==postSum[i]){
                return i;
            }
        }
        return -1;
    }
}
//303
class NumArray1 {
    private int[] nums=null;
    public NumArray1(int[] nums) {
       this.nums=nums;
    }

    public int sumRange(int left, int right) {
      int sum=0;
        for (int i = left; i <= right; i++) {
            sum+=this.nums[i];
        }
      return sum;
    }

}
//303 optimised prefix sum


class NumArray {
    private int[] preFixSumNums=null;
    public NumArray(int[] nums) {
       if(nums==null)
           return;
        preFixSumNums=nums;
        for (int i = 1; i < nums.length; i++) {
            preFixSumNums[i]+=nums[i-1];
        }

    }

    public int sumRange(int left, int right) {
      return  left==0? preFixSumNums[right]:preFixSumNums[right]-preFixSumNums[left-1];
    }

}

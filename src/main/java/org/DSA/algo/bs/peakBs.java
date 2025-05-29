package org.DSA.algo.bs;

public class peakBs {
    public static void main(String[] args) {
        int[] num=new int[]{1,2,1,2,1};
       // System.out.println(findPeakElement(num));
       // System.out.println(findCorrectPeakElement(num));
        System.out.println(findSSquareRoot(36));
    }
    //This will fail for 1,2,1,2,1
    public static int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;

        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        int low=1,high=n-2;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) return mid;

            if(nums[mid]>nums[mid-1]) low=mid+1;

            if(nums[mid]>nums[mid+1]) high=mid-1;


        }
        return -1;

    }
    public static int findCorrectPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;

        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        int low=1,high=n-2;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) return mid;

            if(nums[mid]>nums[mid-1]) low=mid+1;

            else high=mid-1;


        }
        return -1;

    }

    //Find Square Root of element.
    public static int findSSquareRoot(int num){
        int start=1;
        int end=num;
        int ans=1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if((long)mid*mid>num){
                end=mid-1;
            }else {
                start=mid+1;
                ans=mid;
            }
        }
        return ans;
    }
}

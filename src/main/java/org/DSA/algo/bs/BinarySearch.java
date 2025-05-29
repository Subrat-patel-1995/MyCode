package org.DSA.algo.bs;

public class BinarySearch {

    public static void main(String[] args) {
        //System.out.println(123/10);

        System.out.println(lower_bound(new int[]{6,7,8,9,10},11));
        System.out.println(floor(new int[]{6,7,18,19,20},10));

    }
    //Binary Search.
    private static int binarySearch(int[] nums,int target){
        int first=0;
        int last=nums.length-1;
        while(first<last){
            int mid=last+(first-last)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                last=mid-1;
            }else{
                first=mid+1;
            }

        }
        return -1;
    }
    //lower bound first num>=n//same as ceil
    private static int lower_bound(int [] nums,int num){
        int first=0;
        int end=nums.length-1;
        int ans=num;
        while (first<end){
            int mid=first+ (end-first)/2;
            if (nums[mid] >= num) {
                end = mid - 1;
                ans=mid;
            } else {
                first = mid+1;
            }
        }
        return ans;
    }
    //upper bound first num>n
    private static int upper_bound(int [] nums,int num){
        int first=0;
        int end=nums.length-1;
        int ans=num;
        while (first<end){
            int mid=first+ (end-first)/2;
            if (nums[mid] > num) {
                end = mid - 1;
                ans=mid;
            } else {
                first = mid+1;
            }
        }
        return ans;
    }

    //floor largest in array <=n
    private static int floor(int [] nums,int num){
        int first=0;
        int end=nums.length-1;
        int ans=-1;
        while (first<=end){
            int mid=first+ (end-first)/2;
            if (nums[mid] <= num) {
                first = mid+1;
                ans=nums[mid];
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

}

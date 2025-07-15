package org.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Kantar {
    public static void main(String[] args) {
        traverse(new int[]{1,2,3,4});

        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        String s="i am a boy";
        System.out.println(s.trim());
        System.out.println(freqCal("I am a Boyb"));
        System.out.println(twoSum(new int[]{2,3,5,4,2,5},7));
    }
    public static void traverse(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    System.out.println(arr[i]+"=>"+arr[j]+"=>"+arr[k]);
                }
            }
        }
    }
    public  static List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> result=new HashSet<>();
            Arrays.sort(nums);
            for(int i=0;i<nums.length-2;i++){

                int left=i+1,right=nums.length-1;
                while(left<right){
                    int sum=nums[i]+nums[left]+nums[right];
                    if(sum==0){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                    }else if(sum<0){
                        left++;
                    }else{
                        right--;
                    }
                }

            }
            return new ArrayList(result);

        }
    public int threeSumClosest(int[] nums, int target) {
        int result=0;
        int difference=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){

            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target){
                    return result;
                }else if(sum<target){
                    if(Math.abs(sum-target)<difference){
                        result=sum;
                        difference=sum-target;
                    }
                    left++;
                }else{
                    if(Math.abs(sum-target)<difference){
                        result=sum;
                        difference=sum-target;
                    }
                    right--;
                }
            }

        }
        return (result);

    }
    public  static List<List<Integer>> twoSum(int[] nums,int target){
        Set<List<Integer>> result=new HashSet<>();
        Map<Integer,Integer> seen =new HashMap<>();
        for (int i = 0; i < nums.length;i++) {
            int difference=target-nums[i];
            if(seen.containsKey(difference)){
                List<Integer> list=new ArrayList<>();
                list.add(nums[i]);
                list.add(difference);
                result.add(list);
            }
            seen.put(nums[i],i);
        }
        return new ArrayList<>(result);

    }
    public static Map freqCal(String string){
        return string.chars().mapToObj(e->(char)e).filter(e->!e.equals(' ')).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

}


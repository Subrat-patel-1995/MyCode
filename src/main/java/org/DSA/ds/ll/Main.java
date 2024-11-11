package org.DSA.ds.ll;

import org.DSA.ds.ll.DoubleLL;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    int [] arr=new int[]{10,2,3,3,4,5};
        System.out.println(findDuplicate(arr));

    }
    public static int findDuplicate(int[] nums) {
        if(nums.length > 1){
            int slow= nums[0];
            int fast = nums[nums[0]];
            while(slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(fast != slow){
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}

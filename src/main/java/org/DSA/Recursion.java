package org.DSA;

public class Recursion {
    public static void main(String[] args) {
        //increment(0);
        //System.out.println(fbncNo(5));
       // print(5);
       // System.out.println(factorial(50));
        //System.out.println(reverse(4321,0));
        //System.out.println(countNoOfZeroes(101000,0));
        //System.out.println(countOfSteps(14,0));
        System.out.println(checkForSortedArray(new int[]{1, 3, 2},0));
    }
    private static void increment(int i){
        System.out.println(i);
        if(i==2) {
            return;
        }
            increment(i+1);
            increment(i+1);
    }
    private static  int fbncNo(int start){
        if(start==1){
            return 1;
        } else if (start==0) {
            return 0;
        }
        start= fbncNo(start-1)+fbncNo(start-2);
        System.out.println("=====>>>"+start);
        return start;
    }
    private static void  print(int num){
        if (num==0){
            return;
        }
        //System.out.println(num);
        print(num-1);
        System.out.println(num);
    }
    //factorial
    private static long factorial(long num){
        if(num==0 ){
            return 1;
        }
        return num*factorial(num-1);
    }
    //reverse a number
    private static int reverse(int num,int rem){
        if(num==0){
            return rem;
        }
        rem=(rem*10)+(num%10);
        return reverse(num/10,rem);
    }
    //Number of zeroes in a number

    private static int countNoOfZeroes(int num, int count){

        if(num%10==0){
            count ++;
        }
        if(num%10==num){
            return  count;
        }
        return countNoOfZeroes(num/10,count);
    }

    //count number of steps using recursion

    private static int countOfSteps(int num,int count){
        if(num==0){
            return count;
        }
        count++;
         return (num%2==0)?countOfSteps(num/2,count):countOfSteps(num-1,count);
    }

    //find the array is sorted or not?
    private static boolean checkForSortedArray(int[] arr,int firstIndex){
        if(firstIndex== arr.length-1){
            return true;
        }
        if(arr[firstIndex]>arr[firstIndex+1]){
            return false;
        }
        return checkForSortedArray(arr,++firstIndex);
    }
}

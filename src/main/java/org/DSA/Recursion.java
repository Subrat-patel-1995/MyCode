package org.DSA;

public class Recursion {
    public static void main(String[] args) {
        increment(0);
    }
    private static void increment(int i){
        System.out.println(i);
        if(i==2) {
            return;
        }
            increment(i+1);
            increment(i+1);
    }
}

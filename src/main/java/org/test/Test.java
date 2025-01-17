package org.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int max=10;
        List<Integer>result=new ArrayList<>();
        result.add(0);
        for (int i = 1; i <max ; i++) {
            int element=result.get(i-1)-i;
            if(element>0 && !result.contains(element)){
                result.add(element);
            }else {
                result.add(result.get(i-1)+i);
            }
        }
        System.out.println(result);

    }
    public static void main1(String[] args) {
        int nMax = 10; // Maximum index
        List<Integer> a = new ArrayList<>();
        a.add(0); // Initialize a(0) = 0

        // Generate the array based on the given rules
        for (int n = 1; n < nMax; n++) {
            int candidate = a.get(n - 1) - n;
            if (candidate > 0 && !a.contains(candidate)) {
                a.add(candidate);
            } else {
                a.add(a.get(n - 1) + n);
            }
        }

        // Print the array
        System.out.println(a);
    }

}

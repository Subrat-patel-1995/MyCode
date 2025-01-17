package org.test;

import java.util.ArrayList;
import java.util.List;

public class InterviewTest {

    //Create an array with criteria inside screenshot.
    //where:
    //a(0)=0
    //n is index of the array,0<n<10
    //a(n-1)-n>0 and is new
    //else a(n-1)+n
    public static void main(String[] args) {

        List<Integer> resultList=new ArrayList<>();
        //a(0)=0
        resultList.add(0);

        for (int n = 1; n <10 ; n++) {
           int element=resultList.get(n-1)-n;

           if(element>0 && !resultList.contains(element)){
               //a(n-1)-n>0 and is new
               resultList.add(element);
           }else {
               //else a(n-1)+n
               resultList.add(resultList.get(n-1)+n);
           }
        }
        System.out.println(resultList);
    }
}

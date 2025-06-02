package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InterviewTest {

    //Create an array with criteria inside screenshot.
    //where:
    //a(0)=0
    //n is index of the array,0<n<10
    //a(n-1)-n>0 and is new
    //else a(n-1)+n
    public static void main1(String[] args) {

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

    //comparable Comparator

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(31);
        list.add(29);
        list.add(38);

        Collections.sort(list);
        System.out.println(list);

        Comparator<Integer> comparator= (o1, o2) -> o1%10>o2%10?1:-1;
        list.sort(comparator);
        System.out.println(list);


    }
}

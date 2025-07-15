package org.test;

import java.util.*;

public class InterviewTest {

    //Create an array with criteria inside screenshot.
    //where:
    //a(0)=0
    //n is index of the array,0<n<10
    //a(n-1)-n>0 and is new
    //else a(n-1)+n
    public static void main1(String[] args) {

        List<Integer> resultList = new ArrayList<>();
        //a(0)=0
        resultList.add(0);

        for (int n = 1; n < 10; n++) {
            int element = resultList.get(n - 1) - n;

            if (element > 0 && !resultList.contains(element)) {
                //a(n-1)-n>0 and is new
                resultList.add(element);
            } else {
                //else a(n-1)+n
                resultList.add(resultList.get(n - 1) + n);
            }
        }
        System.out.println(resultList);
    }

    //comparable Comparator

    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(31);
        list.add(29);
        list.add(38);

        Collections.sort(list);
        System.out.println(list);

        Comparator<Integer> comparator = (o1, o2) -> o1 % 10 > o2 % 10 ? 1 : -1;
        list.sort(comparator);
        System.out.println(list);


    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(reverse(123));
        print6Palindrome();





    }
    private static void print6Palindrome(){
        for (int i = 100; i <1000 ; i++) {
            int num=i*1000+reverse(i);
            System.out.println(num);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freqMap = new HashMap();
        for (String str : strs) {
            String sortStr = sortString(str);
            if (freqMap.containsKey(sortStr)) {
                freqMap.get(sortStr).add(str);
            } else {
                List list=new ArrayList<>();
                list.add(str);
                freqMap.put(sortStr,list );
            }

        }
        return new ArrayList(freqMap.values());
    }

    private static String sortString(String string){
        char[] array=string.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    private static int reverse(int num){
        int result=0;
        while (num>0){
            int rem=num%10;
            result=result*10+rem;
            num=num/10;
        }
        return  result;
    }





}
class B{
    public static void main(String[] args){
    }
}

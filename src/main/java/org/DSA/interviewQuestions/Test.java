package org.DSA.interviewQuestions;

import java.util.*;

public class Test {
    public static void main(String[] args) {

    }
    public static  void main1(String[] args) {
            List<String> list = new ArrayList<String>();
            list.add("String");
            list.add("String1");
            list.add("String12");
            list.add("String123");

            String minLength = list.stream().min(Comparator.comparingInt(String::length)).orElse(null);
            System.out.println(minLength);

        System.out.println(firstUniqChar("SSUBRAT"));

    }
    public static int getIndex(String s){

        Set<Character> seen=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(!seen.contains(c)  && s.indexOf(c)== s.lastIndexOf(c)){

              return i;
            }
            seen.add(c);
        }
        return -1;
    }
    public  static int firstUniqChar(String s) {
        int[] seen=new int[26];
        for(char c:s.toCharArray()){
            seen[c - 'a']+=1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(seen[s.charAt(i) - 'a']==1){
                return i;
            }
        }
        return -1;
    }
}

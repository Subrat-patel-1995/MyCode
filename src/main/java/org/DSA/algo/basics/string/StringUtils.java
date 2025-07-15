package org.DSA.algo.basics.string;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private final static String a="a";

    public static void main(String[] args) {
        //System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println( new String("dabc").indexOf("abc"));
    }
    private static List<String> words(String s){
        List<String> words=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String word="";

            while(i<s.length() && s.charAt(i) !=' '){
                word+=s.charAt(i);
                i++;
            }
            words.add(word);
        }

        System.out.println(words);
        return words;
    }
    public  static String longestCommonPrefix(String[] strs) {

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j <strs.length ; j++) {
                if(i>=strs[j].length() || strs[j].charAt(i)!=ch){
                    return strs[0].substring(0,i);
                }
            }
        }
        return "";
    }

    //https://leetcode.com/problems/longest-palindromic-substring/
   /* public static String longestPalindrome(String s) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){

        }


    }*/

}

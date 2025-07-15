package org.test;

import java.util.*;
import java.util.function.Function;

public class Test1 {
    public static void main(String[] args) {

    }
    public static String findCommonSubString(String first,String second){
        String result="";
        List<String> firstSubStrings=generateAllPossibleSubStrings(first);
        List<String> secondSubStrings=generateAllPossibleSubStrings(second);
        for (int i = 0; i < firstSubStrings.size(); i++) {
            for (int j = 0; j < secondSubStrings.size(); j++) {
                if(firstSubStrings.get(i).equals(secondSubStrings.get(j))){
                    if(firstSubStrings.get(i).length()>result.length()){
                        result=firstSubStrings.get(i);
                    }
                }
            }
        }
        return result;
    }
    public static List<String> generateAllPossibleSubStrings(String string){
        List<String> result=new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i+1; j <= string.length(); j++) {
                result.add(string.substring(i,j));
            }
        }
        System.out.println(result);
        return result;
    }

}

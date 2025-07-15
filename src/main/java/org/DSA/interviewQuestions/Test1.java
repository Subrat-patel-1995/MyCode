package org.DSA.interviewQuestions;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {



        List<Integer> nums= Arrays.asList(5,4,4,6,1,2);

        Optional<Integer> second = nums.stream().distinct().sorted().skip(1).findFirst();
        System.out.println((second.get()));

        System.out.println(findSecond(nums));
        System.out.println(getList(new String[]{"eat","tea","tan","ate","nat","bat"}));

        String a="abcdde";
        System.out.println(minWindow("ADOBECODEBANC","ABC"));






    }


    public static int findSecond(List<Integer> nums){
        int min=Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        for( Integer num:nums){
            if(num<min){
                secondMin=min;
                min=num;


            }else {
                if (num < secondMin) {
                    secondMin = num;
                }
            }
        }
        return secondMin;
    }

    public static List<List<String>> getList( String [] input){
        Map<String,List<String>>freqMap=new HashMap<>();
      for(String string:input){
          String freqString=freqCal(string);
          if(freqMap.containsKey(freqString)){
              freqMap.get(freqString).add(string);
          }else {
              ArrayList list=new ArrayList<>();
              list.add(string);
              freqMap.put(freqString,list);
          }
      }
      return new ArrayList<>(freqMap.values());
    }
    private static String freqCal(String string){
        int [] array=new int[26];
        for(char c :string.toCharArray()){
            array[c-'a']++;
        }
        StringBuilder stringBuilder=new StringBuilder();
        char base ='a';
        for(int i :array){
           if(i>0){
                stringBuilder.append(base).append(i);
           }
           base++;
        }
        return stringBuilder.toString();
    }
    public  static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] map = new int[128]; // ASCII map
        int count = t.length();   // Characters still needed
        int start = 0, end = 0;   // Window pointers
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        // Fill frequency map with characters in t
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        while (end < s.length()) {
            char endChar = s.charAt(end);

            // If this character was needed (positive count), decrease count
            if (map[endChar] > 0) {
                count--;
            }

            // Decrease frequency for current end character
            map[endChar]--;

            // Move end forward
            end++;

            // When all characters are matched
            while (count == 0) {
                // Check if the current window is smaller
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }

                char startChar = s.charAt(start);

                // Increase frequency for start character since it's being removed from the window
                map[startChar]++;

                // If it was a necessary character (we had exactly enough before), increment count
                if (map[startChar] > 0) {
                    count++;
                }

                // Move start forward to shrink the window
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    class Solution {
        public String minWindow(String s, String t) {
            if(s.length()<t.length()) return "";
            int start=0,end=0,minStart=0,minLength=Integer.MAX_VALUE,count=s.length();

            int [] arr=new int[256];
            for(char c:t.toCharArray()) arr[c]++;
            while(end<s.length()){
                char endchar=s.charAt(end);
                if(arr[endchar]>0){
                    count--;
                }
                arr[endchar]--;
                end++;
                while(count==0){
                    if(end-start<minLength){
                        minLength=end-start;
                        minStart=start;
                    }
                    char startchar=s.charAt(start);
                    if(arr[startchar]>0){
                        count++;
                    }
                    arr[startchar]++;
                    start++;
                }

            }
            return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);

        }

    }


}

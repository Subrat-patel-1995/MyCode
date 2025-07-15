package org.DSA.algo.basics.stream8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamUtils {
    public static void main1(String[] args) {
        List<String> list=List.of("abc","abc1","abc12","abc123");

        String[] strArray=new String[]{"abc","abc1","abc12","abc123"};

        String s = list.stream().min(Comparator.comparing(String::length)).orElse(null);
        System.out.println(s);
        Comparator<String> com=(String a,String b)->a.length();

        List<String> collect = list.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void main(String[] args) {
        //1. Find the second highest number in a list

        List<Integer> list = Arrays.asList(10, 20, 40, 30, 20, 40);
        Integer i = list.stream().distinct().sorted().skip(1).findFirst().get();


        //2. Group elements by length
        List<String> names = List.of("Ram", "Shyam", "Amit", "Sunil");
        Map<Integer,List<String>> result=names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result);

        Map<String, List<String>> collect = names.stream().collect(Collectors.groupingBy(e -> String.valueOf(e.charAt(0))));
        System.out.println(collect);


        //3. Count frequency of each character
        String input = "banana";
        Map<Character, Long> collect1 = input.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);

        //4. Find the first non-repeating character
        Character c = collect1.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        //5. Sort a list of strings by their length and then alphabetically

        List<String> names1 = List.of("Bob","Ram", "Alex", "Christopher", "Daniel");
        List<String> collect2 = names1.stream()
                .sorted(Comparator.comparingInt(String::length))
                //It will Override.
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(collect2);

        List<String> collect3 = names1.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println(collect3);

        //6. Partition numbers into even and odd
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> predicate=(n)->n % 2 == 0;
        Map<Boolean, List<Integer>> partitioned = nums.stream()
                .collect(Collectors.partitioningBy(predicate));
        System.out.println(partitioned);



       // 7. Convert list to comma-separated string
        String collect4 = nums.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println(collect4);

        //8. Map of word to its length
        List<String> names2 = List.of("Bob","Ram" ,"Alex", "Christopher", "Daniel");
        Map<Integer, List<String>> collect5 = names2.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(collect5);
        Map<String, Integer> collect6 =
                names2.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(collect6);


        //9. Remove duplicates and sort
        List<Integer> nums1 = List.of(1, 2, 3, 4, 5, 6);
        nums1.stream().distinct().sorted().collect(Collectors.toList());

        //10. Flatten a list of lists

        List<List<String>> nested = List.of(
                List.of("A", "B"),
                List.of("C", "D")
        );
        List<String> collect7 = nested.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect7);

        //11. Filter even numbers from a list
        List<Integer> list1 = nums1.stream().filter(e -> e % 2 == 0).toList();
        System.out.println(list1);

        //2. Convert list of strings to uppercase

        List<Integer> list2=List.of(1,2,3,4,5,6,6,7,7);
        Set<Integer> set=new HashSet<>();
        list2.stream().filter(e->!set.add(e)).collect(Collectors.toList());
        System.out.println(list2);

           list2.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(k->k.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

           new HashMap<>().entrySet().stream().collect(Collectors.toList());







    }
    public boolean isPalindrome(String s) {
        char[] arr=s.toCharArray();
        reverseHElper(arr,0,s.length());
        String reverse=new String(arr);
        return s.equals(reverse);
    }
    public void reverseHElper(char[] s,int start,int end){
        if(start>=end) return;
        char temp=s[start];
        s[start]=s[end];
        s[end]=temp;

        reverseHElper(s,start+1,end-1);
    }


}

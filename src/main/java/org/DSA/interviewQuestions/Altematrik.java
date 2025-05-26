package org.DSA.interviewQuestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Altematrik {

    /**
     * . Trees (Binary Tree, BST, Segment Tree, Trie, etc.)
     * LeetCode 98 – Validate Binary Search Tree (Medium)
     *
     * LeetCode 105 – Construct Binary Tree from Preorder and Inorder Traversal (Medium)
     *
     * LeetCode 124 – Binary Tree Maximum Path Sum (Hard)
     *
     * LeetCode 208 – Implement Trie (Prefix Tree) (Medium)
     *
     * LeetCode 307 – Range Sum Query - Mutable (Segment Tree) (Medium)
     *
     * b. Heaps / Priority Queues
     * LeetCode 295 – Find Median from Data Stream (Hard)
     *
     * LeetCode 347 – Top K Frequent Elements (Medium)
     *
     * LeetCode 703 – Kth Largest Element in a Stream (Easy)
     *
     * c. Tries (String Matching, Prefix Filtering)
     * LeetCode 208 – Implement Trie (Medium)
     *
     * LeetCode 211 – Design Add and Search Words Data Structure (Medium)
     *
     * LeetCode 676 – Implement Magic Dictionary (Medium)
     */
    public static void main(String[] args) {
     /* String s="My name";
        String collect = s.chars().filter(e -> !Character.isWhitespace(e))
                .mapToObj(e->String.valueOf((char) e))
                .collect(Collectors.joining());
        System.out.println(collect);


        System.out.println(Arrays.stream(s.split(" ")).collect(Collectors.joining()));

        String collect1 = Arrays.stream(s.split(" ")).collect(Collectors.joining());
        System.out.println(collect1);*/

        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(2,1);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){

        }
        map.forEach((k,v)-> System.out.println(k+v));



    }
   // https://leetcode.com/problems/longest-substring-without-repeating-characters/
   //Sliding window technique
    public static int lengthOfLongestSubstring(String s) {
       return 0;
    }


    private static class LRUCache{
        private int capacity;
        private Map<Integer,Integer> cache;
        private LinkedList<Integer> list;

        LRUCache(int capacity){
            this.capacity=capacity;
            this.cache=new HashMap<>(capacity);
            this.list=new LinkedList<>();
        }

        private void put(int key ,int value){
            if(cache.containsKey(key)){
                list.remove(key);
            }else {
                if(cache.size()==capacity){
                    int last=list.removeLast();
                    cache.remove(last);
                }
            }
            cache.put(key,value);
            list.addFirst(key);

        }
        private int get(int key){
            if(cache.containsKey(key)){
                list.remove(key);
                list.addFirst(key);
                return cache.get(key);
            }
            return -1;
        }
    }
}

package org.DSA.algo.random;

import java.util.HashSet;
import java.util.Set;

public class RandomLeetCode {
    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
    public static void main1(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        //System.out.println((1 / 3) * 3 + (1 / 3));

        char[][] board = {
                {'5', '6', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Is Sudoku valid? " + isValidSudoko(board)); // Output: true

    }


    //https://leetcode.com/problems/jump-game/
    //55
    private static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // can't reach this position
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true; // can reach or exceed last index
            }
        }

        return true;
    }

    // https://leetcode.com/problems/sudoku-solver/
    //37
    public static void solveSudoku(char[][] board) {
     //Yet to be learn
    }


    //https://leetcode.com/problems/valid-sudoku/
    //36
    private static boolean isValidSudoko(char[][] board) {
        Set<String> track = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                char current = board[i][j];
                if (current != '.') {
                    String row = current + " row " + i;
                    String column = current + " column " + j;
                    String box = current + " box " + (i / 3) + "," + (j / 3);

                    if ((!track.add(row)) || !track.add(column) || !track.add(box)) {
                        return false;
                    }

                }


            }

        }
        return true;
    }

    //Reverse a string using two pointers
    private static String reverseString(String inp){
        char[] out=inp.toCharArray();
        int start = 0,end = inp.length()-1;
        while (start<end){
            char temp=out[start];
            out[start]=out[end];
            out[end]=temp;
            start++;
            end--;
        }
        return new String(out);


    }

    //using Recursion
    public static String reverse(String str) {
        if (str.isEmpty()) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }
}

package org.FAANG.matrix;

import java.util.*;

public class searchMatrix {
    public static void main(String[] args) {



    }
    //240 n*log m
    public static boolean searchMatrixCol(int[][] matrix, int target) {
        for (int col = 0; col < matrix[0].length; col++) {
            if(searchMatrixCol(matrix,target,col)) return  true;
        }
        return false;

    }
    //240 helper
    public static boolean searchMatrixCol(int[][] matrix, int target, int colIndex) {
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][colIndex] == target) {
                return true;
            } else {
                if (target > matrix[mid][colIndex]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }


        }
        return false;
    }

    //240 Optimised log m*n bs
    public static boolean searchMatrixCol1(int[][] matrix, int target){
        int n=matrix.length;
        int row=0,col=n-1;
        while (row <n && col>=0){
            if(matrix[row][col]==target) return true;
            else if (matrix[row][col]<target) col--;
            else row++;

            }
        return false;
    }



    //74
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchMatrixRowIndex(matrix, target);
        if (rowIndex == -1) {
            return false;
        }
        return searchMatrix(matrix, target, rowIndex);
    }

    // 74 helper 1
    public static int binarySearchMatrixRowIndex(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //if target is in row
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                return mid;
            } else if (target > matrix[mid][0]) start = mid + 1;
            else if (target < matrix[mid][0]) end = mid - 1;
        }
        return -1;

    }
    // 74 helper 2
    public static boolean searchMatrix(int[][] matrix, int target, int rowIndex) {
        int start = 0, end = matrix[rowIndex].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[rowIndex][mid] == target) {
                return true;
            } else {
                if (target > matrix[rowIndex][mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }


        }
        return false;
    }

    //36 valid suduko
    public static boolean isValidSuduko(int[][] matrix){
        boolean isValid=false;
        Set<Character[]> rowSeen=new HashSet<>();
        System.out.println(rowSeen);
        return isValid;
    }

}



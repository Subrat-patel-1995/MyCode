package org.FAANG.matrix;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtils {
    public static void main(String[] args) {
        int [][] matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(naturalTraverse(matrix));
        System.out.println(onlyOthRowTraverse(matrix));
        System.out.println(onlyOthColTraverse(matrix));
        System.out.println(spiralTraverse(matrix));
        System.out.println(naturalColTraverse(matrix));

    }

    //54
    public static List<Integer> spiralTraverse(int[][] matrix){
        List<Integer>result=new ArrayList<>();
        int n= matrix.length;
        int m=matrix[0].length;

        int left=0,right=m-1,top=0,bottom=n-1;
        while (left<=right && top<=bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[left][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    //74
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex= binarySearchMatrixRowIndex(matrix,target);
        if(rowIndex==-1){
            return false;
        }
       return searchMatrix(matrix,target,rowIndex);
    }
    // 74 helper 1
    public static int binarySearchMatrixRowIndex(int[][] matrix, int target) {
        int start=0,end=matrix.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            //if target is in row
            if(target>=matrix[mid][0] && target<=matrix[mid][matrix[0].length-1] ){
                return mid;
            }
            else if(target>matrix[mid][0]) start=mid+1;
            else if(target<matrix[mid][0]) end=mid-1;
        }
        return -1;

    }
    public static boolean searchMatrix(int[][] matrix, int target,int rowIndex){
        int start=0,end=matrix[rowIndex].length-1;
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if(matrix[rowIndex][mid]==target){
                return true;
            }else {
                if(target>matrix[rowIndex][mid]){
                    start=mid+1;
                }else {
                    end=mid-1;
                }

            }


        }
        return false;
    }


    public static List<Integer> naturalTraverse(int[][] matrix){
        List<Integer>result=new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result.add(matrix[i][j]);
            }
        }
        return result;
    }
    public static List<Integer> onlyOthRowTraverse(int[][] matrix){
        List<Integer>result=new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[0][i]);
        }
        return result;
    }
    public static List<Integer> onlyOthColTraverse(int[][] matrix){
        List<Integer>result=new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
        }
        return result;
    }
    public static List<Integer> naturalColTraverse(int[][] matrix){
        List<Integer>result=new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result.add(matrix[j][i]);
            }
        }
        return result;
    }

}

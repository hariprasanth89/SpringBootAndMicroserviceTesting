package com.example.paypalcodingtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;
       // int sizeOfRowAndCol = matrix.length * matrix[0].length;

        while (result.size() < rows * columns) {
            // Traverse from left to right.
            for (int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }
            // Traverse downwards.
            for (int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            // Make sure we are now on a different row.
            if (up != down) {
                // Traverse from right to left.
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[down][col]);
                }
            }
            // Make sure we are now on a different column.
            if (left != right) {
                // Traverse upwards.
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }
	
	public static List<Integer> sprinalMatrixApproach2(int[][] matrix) {
		int rowBegin = 0;
		int rowEnd = matrix.length-1;
		int columnBegin = 0;
		int columnEnd = matrix[0].length-1;
		int rowAndColumnSize =matrix.length * matrix[0].length;
		
		List<Integer> result = new ArrayList<Integer>();
		
		if (matrix.length == 0) {
			return result;
		}
		while ( result.size() < rowAndColumnSize) {
			for (int i = columnBegin; i <= columnEnd; i++) {
				result.add(matrix[rowBegin][i]);
			}
			rowBegin++;
			for (int i = rowBegin; i <= rowEnd; i++) {
				result.add(matrix[i][columnEnd]);
			}
			columnEnd--;
			if (rowBegin <= rowEnd) {
				for (int i = columnEnd; i >= columnBegin; i--) {
					result.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;
			if (columnBegin <= columnEnd) {
				for (int i = rowEnd; i >= rowBegin; i--) {
					result.add(matrix[i][columnBegin]);
				}
			}
			columnBegin++;
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		//int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int matrix[][] = {{1,2,3,4},{4,5,6,7},{7,8,9,0}};
		//List<Integer> spiralOrder = spiralOrder(matrix);
		List<Integer> sprinalMatrixApproach2 = sprinalMatrixApproach2(matrix);
		for (Integer integer : sprinalMatrixApproach2) {
			System.out.println(integer);
		}
	}
}

package ProblemSet_02;

import java.util.Arrays;

public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        // Take the transpose of the matrix
        for (int i = 0; i < matrix.length; i++) { // Run the loop from 0 to row.length - 1
            for (int j = i; j < matrix[0].length; j++) {// Run the loop from i to col.length-1 - first iteration will work on 0th row and column , next on 1st row and col then so on.
                int temp = 0; // Take a temp variable og integer type to swap
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];// element at 01 becomes element at 10 and same
                matrix[j][i]=temp; //
            }
        }
        // Now reverse the row
        for (int i = 0; i < matrix.length; i++) { // Run the loop from 0th row to row.length-1
            for (int j = 0; j < matrix.length / 2; j++) {// Run the loop from 0th column to middle of the column
                int temp = matrix[i][j]; // swap the first column element with last column
                matrix[i][j] = matrix[i][matrix.length - 1 - j];// Basically reversal of an array of row
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] A = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println(Arrays.deepToString(A));
        rotate(A);
        System.out.println(Arrays.deepToString(A));
    }

}

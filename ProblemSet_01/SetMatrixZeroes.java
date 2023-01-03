package ProblemSet_01;


import java.util.Arrays;

public class SetMatrixZeroes {
    // Brute Force approach - taking a new resultant matrix
    static void setZeroesNaive(int[][] matrix){
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int[][] ans = new int[maxRow][maxCol];

        // Make the whole matrix values equal to one
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                ans[i][j]=1;
            }
        }

        System.out.println("New Answer matrix");
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (matrix[i][j]==0){
                    for (int k = 0; k < maxCol; k++) {
                        ans[i][k]=0;
                    }
                    for (int l = 0; l < maxRow; l++) {
                        ans[l][j]=0;
                    }

                }
            }
        }
        System.out.println("Answer matrix after modification of zeroes");
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

        // Now add the element of original matrix where new matrix element are not zero
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (ans[i][j]!=0){
                    ans[i][j] = matrix[i][j];
                }
            }
        }
        System.out.println("Answer matrix after final modification");
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    // Time Efficient Approach
    static int[][] setZeroesEfficient(int[][] matrix){
        // Take the marker to set in our first row and column.
        boolean firstRow = false; // Marker for the Row.
        boolean firstCol = false; // Marker for the column.

        for (int i = 0; i < matrix.length; i++) { // Traversal of row.
            for (int j = 0; j < matrix[0].length; j++) { // Traversal of column.
                if (matrix[i][j]==0){ // If 0 is found to these things.
                    if (i==0) firstRow = true; // If first row contains 0 then mark the row marker to true.
                    if (j==0) firstCol = true; // If first column contains 0 then mark the row marker to be zero.
                    matrix[i][0]=0; // Make the corresponding column (first) element 0.
                    matrix[0][j]=0;// Make the corresponding row (first) element .
                }
            }
        }

        // Now make changes in inner matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // Check corresponding first row and first column element if there exists a zero in them.
                if (matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;// Make that element zero too.
                }
            }
        }

        // Now if there is 0 int the outer column or row make whole outer row/column equals to 0
        if (firstCol){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
        if (firstRow){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j]=0;
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        // Output: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
        int[][] matrix1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        // Output: [[0,0,0,0},{0,4,5,0},{0,3,1,0}};
        System.out.println(Arrays.deepToString(setZeroesEfficient(matrix)));
        System.out.println(Arrays.deepToString(setZeroesEfficient(matrix1)));
    }
}
package Day03;
//Write an efficient algorithm that searches for a value target in an m x n integer matrix.
// This matrix has the following properties:
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.

//[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 -> true
public class SearchInSortedMatrix {

    private static boolean searchInMatrix(int[][] matrix,int target){
        // We can also use linear search but its time complexity is too high
        // Two pointer approach

        int minRow=0;//Pointer for traversal of the row from 0th row
        int maxCol = matrix[0].length-1; // Pointer for traversal of column from last column

        // Main idea is that we will look at the top right index then ->

        while (minRow<matrix.length && maxCol>=0){ // Loop for the same
            if (matrix[minRow][maxCol]==target){ // If target index is equal to right most index then return true
                return true;
            }
            else if (target>matrix[minRow][maxCol]){// If it is greater than search in next row
                minRow++;
            }
            else maxCol--; // If it less than right element move pointer towards left
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchInMatrix(matrix,3));
    }


}

package ProblemSet_01;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    static List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<>(); // Make an arraylist of type list which contains Integer
        if (numRows==0) return triangle; // if numRows is equal to zero return empty list

        List<Integer> firstRow = new ArrayList<>(); // Make new array list firstRow
        firstRow.add(1); // Add 1 in it
        triangle.add(firstRow); // Now add the first row in triangle list
         // Means at 0th index of triangle we have [1]
        // So start iterating from 1st index
        for (int i = 1; i < numRows; i++) { // Loop from 1st to numRows-1
            List<Integer> prevRow = triangle.get(i-1); // get the prev row
            List<Integer> row = new ArrayList<>(); //make a new array list
            row.add(1); // add 1 to newly made arraylist - set first element of the internal list as 0
            for (int j = 1; j < i; j++) { // now from 1 till i
                row.add(prevRow.get(j-1)+prevRow.get(j)); // get previous row index elements and add it to the row
            }
            row.add(1); // add 1 at end of the row list
            triangle.add(row); // add whole list to triangle list
        }
        return triangle;
    }

    public static void main(String[] args) {
        int num = 5;
        List<List<Integer>> pascaltriangle=generate(5);
        System.out.println(pascaltriangle);
        List<Integer> list = pascaltriangle.get(3);
        System.out.println(list);
    }
}

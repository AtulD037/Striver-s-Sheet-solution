package ProblemSet_02;
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals){
        List<int[]> res = new ArrayList<>();
        if (intervals.length==0) return res.toArray(new int[0][]);
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);// Sort the array by using Comparable statement
        int start = intervals[0][0]; // Take the start as 0th element of 0th index i.e. 1 from [1,3]
        int end = intervals[0][1];  //  Take the end as 1st element of 0th index i.e. 3 from [1,3]

        for (int i = 1; i < intervals.length; i++) {// Run the loop from 1st index to last index of intervals array
            if (intervals[i][0]<=end){ // If 0th index of next interval is less than equal to last index of prev interval
                end = Math.max(end,intervals[i][0]); // Take the max value from prev end and next start and update the end
                // Intuition - If they are overlapping update the end
            }
            else {// And if they are not overlapping store them into list
                res.add(new int[] {start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }
}

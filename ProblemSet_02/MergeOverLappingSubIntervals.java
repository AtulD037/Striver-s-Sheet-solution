package ProblemSet_02;

import java.util.Stack;

public class MergeOverLappingSubIntervals {
    /*1.You are given a number n, representing number of interval of time intervals
      2.In next n lines , you are given a pair of space separated members
      3. The pair of number represent the start time and end time.
      4. You are required to merge overlapping sub intervals in increasing order of start time
    * */
    public class Pair implements Comparable<Pair>{
        int st;
        int et;

        public Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(Pair other) {
          if (this.st!=this.et){
              return this.st- other.st;
          }
          else return this.et-other.et;
        }
    }

    public static void merge(int[] intervals){
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i==0){
//                st.push([i]);
            }
//            else
        }
    }
}

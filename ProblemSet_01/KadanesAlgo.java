package ProblemSet_01;

public class KadanesAlgo {
    static int maximum(int[] array){
        int currentSum = array[0]; // Take the initial current sum as 0th element of the array
        int maxSum = array[0]; // Take maximum sum so far as 0th element of the array
        for (int i = 1; i < array.length; i++) {
           if (currentSum>=0){ // If current sum is greater than or equal to zero then only it will add next elements into it
               currentSum+=array[i];
           }
           else currentSum=array[i]; // If current some becomes negative start the current sum from that particular index only
           if (currentSum>maxSum){ // if max so far is greater than current sum , update the max Sum with current sum
               maxSum=currentSum;
           }
        }
        return maxSum;// Return the maximum sum
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximum(arr));
    }
}

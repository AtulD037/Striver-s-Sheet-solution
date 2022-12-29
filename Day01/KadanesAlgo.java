package Day01;

public class KadanesAlgo {
    static int maximum(int[] array){
        int currentSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
           if (currentSum>=0){
               currentSum+=array[i];
           }
           else currentSum=array[i];
           if (currentSum>maxSum){
               maxSum=currentSum;
           }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximum(arr));
    }
}

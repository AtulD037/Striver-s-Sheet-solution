package ProblemSet_01;

import java.util.Arrays;

public class SortColors {
    static int[] DNF(int[] arr){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        while (mid<=end){
            switch (arr[mid]){
                case 0:
                    swap(arr,mid,start);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr,mid,end);
                    end--;
                    break;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] flag = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(DNF(flag)));
    }
}

package Day04;

import java.util.Arrays;
import java.util.HashMap;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
public class TwoSumInArray {
    static int[] twoSumNaives(int[] arr,int target){
        int[] ans = {-1,-1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]+arr[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
    static int[] twoSumHashMap(int[] arr,int target){
        int[] ans = {-1,-1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target-arr[i])){
                ans[1] = i;
                ans[0] = map.get(target-arr[i]);
            }
            map.put(arr[i],i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSumHashMap(arr,9)));
        System.out.println(Arrays.toString(twoSumNaives(arr,9)));

    }
}

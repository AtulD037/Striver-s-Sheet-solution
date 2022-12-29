package Day02;

import java.util.Arrays;
import java.util.HashSet;

//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//There is only one repeated number in nums, return this repeated number.
//You must solve the problem without modifying the array nums and uses only constant extra space.
//Input: nums = [1,3,4,2,2]
//Output: 2
//Input: nums = [3,1,3,4,2]
//Output: 3
public class FindDuplicate {
    static int findDuplicateBruteForce(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
    static int findDuplicateUsingSort(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
    static int findDuplicateUsingHashSet(int[] nums){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])){
                return nums[i];
            }
            else hashSet.add(nums[i]);
        }
        return -1;
    }
    static int findDuplicatesUsingLoopDetectionMethod(int[] nums){
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        return slow;

        // As soon as the meet, move both pointer at same speed until they meet again
//        slow = 0;
//        while (slow!=fast){
//            slow = nums[slow];
//            fast = nums[fast];
//        }
//        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        int[] arr1 = {3,1,3,4,2};
        System.out.println(findDuplicateBruteForce(arr));
        System.out.println(findDuplicateBruteForce(arr1));
        System.out.println(findDuplicateUsingSort(arr));
        System.out.println(findDuplicateUsingSort(arr1));
        System.out.println(findDuplicateUsingHashSet(arr));
        System.out.println(findDuplicateUsingHashSet(arr1));

        System.out.println("Efficient solution using linked list loop concept");
        System.out.println(findDuplicatesUsingLoopDetectionMethod(arr));
        System.out.println(findDuplicatesUsingLoopDetectionMethod(arr1));
    }
}

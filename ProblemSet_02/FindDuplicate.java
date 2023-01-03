package ProblemSet_02;

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
        for (int i = 0; i < nums.length; i++) {// Run the loop for picking one element
            for (int j = i+1; j < nums.length; j++) {// Run the loop for comparing each element with right sub arrau
                if (nums[i]==nums[j]){ // If a match is founded match return the number
                    return nums[i];
                }
            }
        }
        return -1;// If we do not found any match return -1
    }
    static int findDuplicateUsingSort(int[] nums){
        Arrays.sort(nums); // Sort the numbers array
        for (int i = 0; i < nums.length-1; i++) { // Compare each element with its next element
            if (nums[i]==nums[i+1]){ // If a match occurs return the number
                return nums[i];
            }
        }
        return -1;// If we do not found any match return -1
    }
    static int findDuplicateUsingHashSet(int[] nums){
        HashSet<Integer> hashSet = new HashSet<>(); // Take an empty Hashset
        for (int i = 0; i < nums.length; i++) {// Iterate through every element of the array
            if (hashSet.contains(nums[i])){ // If hashSet contains element then return that particular element
                return nums[i];
            }
            else hashSet.add(nums[i]); // Otherwise, add the element to hashSet
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

         //As soon as the meet, move both pointer at same speed until they meet again
        slow = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
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

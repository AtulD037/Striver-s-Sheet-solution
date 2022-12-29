package Day02;

import java.util.Arrays;

//Integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
// and the last n elements are set to 0 and should be ignored. nums2 has a length of n
public class MergeTwoSortedArray {
    public static void merge(int[] nums1,int[] nums2, int m,int n){
        int tail1 = m-1; // last element pointer for the nums1 array
        int tail2 = n-1;  // last element pointer for the nums2 array
        int finished = m+n-1; // pointer for storing in the final nums1 array

        while (tail1>=0 && tail2>=0){ // Till pointer 1 is greater than pointer 2
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
            // If nums1 element is greater than nums2's last element then add it to final nums1 or otherwise add nums2 element to it
        }
        while (tail2>=0){ // Check for remaining if left
            nums1[finished--] = nums2[tail2--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};int m = 3;int[] nums2 = {2,5,6};int  n = 3;
        merge(nums1,nums2,m,n);
        System.out.println(Arrays.toString(nums1));
    }
}

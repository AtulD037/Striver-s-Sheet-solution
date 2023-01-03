package ProblemSet_02;
//Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.

public class MissingNumber {
    static int findMissingNumber(int[] nums){
        int i = 0; // Take i as 0
        while (i!=nums.length){// While i, is not equal to length of the array run the loop
            int correct = nums[i]; // correct index = element at index i
            if (nums[i]<nums.length && nums[i]!=nums[correct]){// if element is less than length of the array and number are not at correct position
                swap(nums,i,correct); // swap the number with their correct position
            }
            else i++; // If element is at correct index increment i by 1
        }
        // Search for first missing index
        for (int index = 0; index < nums.length; index++) { // Now search  fot the missing element
            if (nums[index]!=index) { // Intuition is that number at current index must be equal to current index
                return index;// If not then return the index
            }
        }
        return nums.length;// If all number are at correct position in the array then return length of the array as number
    }

    private static void swap(int[] nums, int f, int s) {
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3,0,1};
        System.out.println(findMissingNumber(a));
    }
}

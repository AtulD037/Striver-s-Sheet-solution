package Day03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.
public class MajorityElement {
    static int majorityElementBruteForceApproach(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[i]==nums[j]){
                    count++;
                    nums[j]=0;
                }
            }
            if (count>nums.length/2){
                return nums[i];
            }
        }
        return -1;
    }

    static int majorityElementUsingBinarySearch(int[] nums){
        // First sort the array and if element is majority element then it always passes the middle index
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    static int majorityElementsUsingHashMap(int[] nums){
        HashMap<Integer,Integer> hashMap = new HashMap<>(); // Initialize a Hashmap

        for (int i = 0; i < nums.length; i++) { // Loop through the array
            if (hashMap.containsKey(nums[i])){// If element is present then increase its value by one
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }
            else hashMap.put(nums[i],1); // If element is not present add it to hashmap with initial value as 1
        }
        for (Map.Entry<Integer,Integer> entry: // Loop through the entry set
                hashMap.entrySet()) {
                if (entry.getValue()>nums.length/2) return entry.getKey();// If there exist a key whose value is greater than half og the length of the array return that key
        }
        return -1; // if there is no majority element return -1;
    }

    static int majorityElementUsingMooresVotingAlgorithm(int nums[]){
        // To start let the first element be majority element and its equivalent vote to be 1
        int majority = nums[0],votes = 1;

        for (int i = 1; i < nums.length; i++) { // Loop through the array
            if (votes==0){ // If vote is 0 make current index element as the majority element
                votes++; // Increase the vote count
                majority = nums[i];
            } else if (majority==nums[i]) {
                votes++; // current element is equal to majority element increase the vote count by one
            }
            else votes--; // If not then decrease the vote count by one
        }
        return majority; // At last return the element having number of votes
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(Arrays.toString(arr));
        //System.out.println(majorityElementBruteForceApproach(arr));
        //System.out.println(majorityElementUsingBinarySearch(arr));
        //System.out.println(majorityElementsUsingHashMap(arr));
        System.out.println(majorityElementUsingMooresVotingAlgorithm(arr));
    }
}

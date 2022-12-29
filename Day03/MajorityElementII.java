package Day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an integer array of size n, find all elements that appear more than n/3 times.
public class MajorityElementII {
    public static List<Integer> majorityElementIIUsingHashmap(int[] nums) {
        List<Integer> list = new ArrayList<>(); // Initialize an empty arraylist
        HashMap<Integer,Integer> hashMap = new HashMap<>(); //Take a hashmap
        for (int i = 0; i < nums.length; i++) { // loop through the array
            if (hashMap.containsKey(nums[i])){ // If map contains the element increment the count by one
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }
            else hashMap.put(nums[i],1); // If map does not contain the element then add one as its equivalent value
        }
        for (Map.Entry<Integer,Integer> entry: // Loop through entry set
             hashMap.entrySet()) {
            if (entry.getValue() > nums.length/3){// If there exist a value whose count is greater than n/3
                list.add(entry.getKey()); // Then add it to the arrayList
            }
        }
        return list; // Return the arrayList
    }



    public static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majorityElementIIUsingHashmap(arr));
    }
}

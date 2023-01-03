import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];

        Map<Integer,Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = hmap.get(target-nums[i]);
                return result;
            }
            else {
                hmap.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr,9)));
    }
}
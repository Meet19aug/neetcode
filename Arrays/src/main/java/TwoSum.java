import java.util.*;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mapper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int finding = target - nums[i];
            if(mapper.containsKey(finding)){
                return new int[]{i,mapper.get(finding)};
            }
            mapper.put(nums[i],i);
        }
        return new int[]{0,0};

    }
    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 1; j < nums.length; j++) {
                int sum = nums[i]+nums[j];
                if(sum==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int nums[]=new int[]{3,2,4};
        int target =6;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}

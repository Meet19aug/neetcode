import java.util.*;

public class TopKElementsinList {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counter = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1]; // main [ [varaible length], [variable length]]
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (int n: nums) {
            counter.put(n,counter.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : counter.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length-1 ; i >0 && index<k; i--) {
            for(int n:freq[i]){
                res[index++]=n;
                if(index==k){
                    return res;
                }
            }
        }
        return res;

    }
    public static void main(String[] args) {
        int [] nums = new int[]{1,2};
        int target = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,target)));
    }
}

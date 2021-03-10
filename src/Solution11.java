import java.util.TreeMap;

public class Solution11 {


    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4};
        System.out.println(longestSubarray(nums,0));
    }

    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int left = 0,right = 0,ret = 0;
        while (right < nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while (map.lastKey() - map.firstKey() > limit){
                map.put(nums[left], map.get(nums[left]) -1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret,right-left+1);
            right++;
        }
        return ret;
    }
}

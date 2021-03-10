import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {

        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums).toString());
    }


    /*
    * 汇总区间
    * 给定一个无重复元素的有序整数数组 nums 。
    * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
    * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
    * */
    public static List<String> summaryRanges(int[] nums) {

        List<String> ranges = new ArrayList<>();
        if(nums.length == 0){
            return ranges;
        }
        int start = nums[0],end = nums[0];
        for(int i=1;i<nums.length;i++){
            if(end+1 == nums[i]){
                end = nums[i];
            }else {
                if(start == end){
                    ranges.add(start+"");
                }else {
                    ranges.add(start+"->"+end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if(start == end){
            ranges.add(start+"");
        }else {
            ranges.add(start+"->"+end);
        }
        return ranges;
    }
}

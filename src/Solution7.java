import java.util.Arrays;

public class Solution7 {


    /*
    * 村庄首位相连，小偷不能偷2个相邻的房子，求偷最大的金额
    * */
    public static void main(String[] args) {
        int[] nums = {1,3,1,3,100};
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.rob(nums));
    }

    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums,0,nums.length-1)),myRob(Arrays.copyOfRange(nums,1,nums.length)));
    }

    public int find(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);

            System.out.println(dp[i]);
        }
        return dp[dp.length-1];
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

}

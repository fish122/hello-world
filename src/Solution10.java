public class Solution10 {

    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1;i<nums.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max((dp[j] + 1),dp[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        int[] numbers = new int[max];
        int min = 999;
        for(int i = max;i>=0;i--){
            for(int j = 0;j<dp.length;j++){
                if(dp[j] == i && nums[j] < min){
                    numbers[i-1] = nums[j];
                    min = nums[j];
                    break;
                }
            }
        }
        for (int i =0;i<numbers.length;i++){
            System.out.print(numbers[i]+  " ");
        }


        return max;
    }
}

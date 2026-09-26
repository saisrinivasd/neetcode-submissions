class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return solve(0, dp, nums);
    }

    private int solve(int i, int[] dp, int[] nums) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int rob = nums[i] + solve(i+2, dp, nums);
        int skip = solve(i+1, dp, nums);
        dp[i] = Math.max(rob, skip);
        return dp[i];
    }
}

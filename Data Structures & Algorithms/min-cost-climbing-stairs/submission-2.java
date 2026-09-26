class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, dp, cost), solve(1, dp, cost));
    }

    private int solve(int i, int[] dp, int[] cost) {
        if(i >= cost.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        dp[i] = cost[i] + Math.min(solve(i+1, dp, cost), solve(i+2, dp, cost));        
        return dp[i];
    }
}

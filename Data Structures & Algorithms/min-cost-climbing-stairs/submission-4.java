class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = cost[0];
        int prev = cost[1];
        for(int i = 2; i < cost.length; i++) {
            int ans = cost[i] + Math.min(prev, prev2);
            prev2 = prev;
            prev = ans;
        }
        return Math.min(prev2, prev);
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if( nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob1(nums, 0, nums.length-2), rob1(nums, 1, nums.length-1));
    }

     public int rob1(int[] nums, int start, int end) {
        int prev2 = nums[start];
        int prev = Math.max(nums[start], nums[start+1]);
        for(int i = start+2; i <= end; i++) {
            int ans = Math.max(prev, nums[i] + prev2);
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }
}

class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int eleCount = 0;
            for(int j = 0; j < n; j++) {
                if(nums[i] == nums[j]) {
                    eleCount++;
                }
            }
            if(eleCount > 1) {
                return true;
            }
        }
        return false;
    }
}